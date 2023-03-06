package com.stabletrader.v2.ibagent.wrapper;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ib.client.Bar;
import com.ib.client.CommissionReport;
import com.ib.client.Contract;
import com.ib.client.ContractDescription;
import com.ib.client.ContractDetails;
import com.ib.client.Decimal;
import com.ib.client.DeltaNeutralContract;
import com.ib.client.DepthMktDataDescription;
import com.ib.client.EClientSocket;
import com.ib.client.EJavaSignal;
import com.ib.client.EReader;
import com.ib.client.EWrapper;
import com.ib.client.Execution;
import com.ib.client.FamilyCode;
import com.ib.client.HistogramEntry;
import com.ib.client.HistoricalSession;
import com.ib.client.HistoricalTick;
import com.ib.client.HistoricalTickBidAsk;
import com.ib.client.HistoricalTickLast;
import com.ib.client.NewsProvider;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.ib.client.PriceIncrement;
import com.ib.client.SoftDollarTier;
import com.ib.client.TagValue;
import com.ib.client.TickAttrib;
import com.ib.client.TickAttribBidAsk;
import com.ib.client.TickAttribLast;
import com.ib.client.Types;
import com.stabletrader.v2.ibagent.data.HistoicalStockBean;
import com.stabletrader.v2.ibagent.data.RealTimeStockBean;
import com.stabletrader.v2.ibagent.data.StockBean;
import com.stabletrader.v2.ibagent.dataservice.DataService;
import com.stabletrader.v2.ibagent.dataservice.PropertyEnvironmentAware;

@Service
public class IBDataProcessorWrapper implements EWrapper {

	private Logger logger = LogManager.getLogger();

	private Map<String, StockBean> stockBySymbolMap = new HashMap<>();
	private Map<Integer, StockBean> stockByIDMap = new HashMap<>();
	private volatile StockBean stockBean = null;
	List<RealTimeStockBean> realtimeTempList = new ArrayList<>();
	List<HistoicalStockBean> hisTempList = new ArrayList<>();

	private BlockingQueue<RealTimeStockBean> realTimeTradeBlockingQueue = new ArrayBlockingQueue<>(16384);
	private BlockingQueue<HistoicalStockBean> historyDailyBlockingQueue = new ArrayBlockingQueue<>(16384);

	@Autowired
	private PropertyEnvironmentAware env;

	@Autowired
	private DataService dataService;

	private EJavaSignal m_signal = new EJavaSignal();
	private EClientSocket m_client = new EClientSocket(this, m_signal);
	private EReader m_reader;
	private String baseurl;
	private volatile String savePath;

	private boolean isInit = false;

	private Runnable realtimeDequeueRunnable = () -> {
		try {
			processRealTimeDeque();
		} catch (InterruptedException e) {
			logger.log(Level.DEBUG, () -> e);
		}
	};

	private Runnable historicalDequeueRunnable = () -> {
		try {
			processHisDeque();
		} catch (InterruptedException e) {
			logger.log(Level.DEBUG, () -> e);
		}
	};

	public void init() throws IOException {
		if (!isInit) {
			baseurl = env.getProperty("app.dataservice.stock.urlbase");
			List<Object> stockJsonList = dataService.getStockList(baseurl);

			stockJsonList.stream().forEach((o) -> {
				if (o instanceof Map) {
					Map<String, Object> map = (Map<String, Object>) o;
					map.entrySet().forEach((entry) -> {
						if (stockBean == null) {
							stockBean = new StockBean();
						}

						if ("id".equals(entry.getKey())) {
							stockBean.setId((Integer) entry.getValue());
						} else {
							stockBean.setStockSymbol((String) entry.getValue());
							stockByIDMap.put(stockBean.getId(), stockBean);
							stockBySymbolMap.put(stockBean.getStockSymbol(), stockBean);
							stockBean = null;
						}
					});
				}
			});
			isInit = true;
			// System.out.println(stockByIDMap);
			// System.out.println(stockBySymbolMap);
			logger.log(Level.DEBUG, () -> "init done");
		}
	}

	public void connectTWS(int cid) {
		if (!m_client.isConnected()) {
			m_client.eConnect(null, 7777, cid);
		}

		if (m_client.isConnected()) {
			logger.log(Level.DEBUG, () -> "Connected to Tws server version " + m_client.serverVersion() + " at "
					+ m_client.getTwsConnectionTime());

			m_reader = new EReader(m_client, m_signal);

			m_reader.start();

			new Thread(() -> {
				processMessages();
			}).start();

			logger.log(Level.DEBUG, () -> "ready to request");
		} else {
			logger.log(Level.DEBUG, () -> "not connected.");
			throw new RuntimeException("unable to connect TWS!");
		}
	}

	private void processMessages() {

		while (m_client.isConnected()) {
			m_signal.waitForSignal();
			try {
				m_reader.processMsgs();
			} catch (Exception e) {
				error(e);
			}
		}
	}

	public boolean isConnected() {
		return m_client.isConnected();
	}

	public void DisConnectTWS() {
		m_client.eDisconnect();
		m_reader.stop();

	}

	public Map<String, StockBean> getStockBySymbolMap() {
		return stockBySymbolMap;
	}

	public Map<Integer, StockBean> getStockByIDMap() {
		return stockByIDMap;
	}

	public void reqestRealTimeBar(int tickerId, Contract contract) {
		List<TagValue> mktDataOptions = new ArrayList<>();
		m_client.reqRealTimeBars(tickerId, contract, 5, Types.WhatToShow.TRADES.name(), false,
				(ArrayList<TagValue>) mktDataOptions);
	}

	public void requestHistoryData(int reqId, Contract contract, String endDate, String duration, String barSize,
			String tradeType) {
		List<TagValue> mktDataOptions = new ArrayList<>();
		m_client.reqHistoricalData(reqId, contract, endDate, duration, barSize, tradeType, 1, 1, false, mktDataOptions);
	}

	/////////////////////////////////////////////////////////////////////////

	public Runnable getRealtimeDequeueRunnable() {
		return realtimeDequeueRunnable;
	}

	public Runnable getHistoricalDequeueRunnable() {
		return historicalDequeueRunnable;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	/////////////////////////////////////////////////////////////////////////////

	@Override
	public void accountDownloadEnd(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void accountSummary(int arg0, String arg1, String arg2, String arg3, String arg4) {
		// TODO Auto-generated method stub

	}

	@Override
	public void accountSummaryEnd(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void accountUpdateMulti(int arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
		// TODO Auto-generated method stub

	}

	@Override
	public void accountUpdateMultiEnd(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void bondContractDetails(int arg0, ContractDetails arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void commissionReport(CommissionReport arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void completedOrder(Contract arg0, Order arg1, OrderState arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void completedOrdersEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void connectAck() {
		// TODO Auto-generated method stub

	}

	@Override
	public void connectionClosed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void contractDetails(int arg0, ContractDetails arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contractDetailsEnd(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void currentTime(long arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deltaNeutralValidation(int arg0, DeltaNeutralContract arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayGroupList(int arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayGroupUpdated(int arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void error(Exception e) {
		logger.log(Level.ERROR, () -> e);
	}

	@Override
	public void error(String s) {
		logger.log(Level.ERROR, () -> s);
	}

	@Override
	public void error(int id, int errorCode, String errorMsg, String advancedOrderRejectJson) {
		if (id < 1) {
			logger.log(Level.DEBUG, () -> errorMsg);
		} else if (errorMsg.contains("connection is broken") || errorMsg.contains("Bust event occurred")
				|| errorMsg.contains("Bad Message")) {
			logger.log(Level.ERROR, () -> id + "---" + errorCode + "---" + errorMsg + "---" + advancedOrderRejectJson);
			DisConnectTWS();
			// throw new RuntimeException(errorMsg);
		} else {
			logger.log(Level.ERROR, () -> id + "---" + errorCode + "---" + errorMsg + "---" + advancedOrderRejectJson);
		}

	}

	@Override
	public void execDetails(int arg0, Contract arg1, Execution arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execDetailsEnd(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void familyCodes(FamilyCode[] arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fundamentalData(int arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void headTimestamp(int arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void histogramData(int arg0, List<HistogramEntry> arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void historicalDataEnd(int arg0, String arg1, String arg2) {
	}

	@Override
	public void historicalDataUpdate(int arg0, Bar arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void historicalNews(int arg0, String arg1, String arg2, String arg3, String arg4) {
		// TODO Auto-generated method stub

	}

	@Override
	public void historicalNewsEnd(int arg0, boolean arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void historicalSchedule(int arg0, String arg1, String arg2, String arg3, List<HistoricalSession> arg4) {
		// TODO Auto-generated method stub

	}

	@Override
	public void historicalTicks(int arg0, List<HistoricalTick> arg1, boolean arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void historicalTicksBidAsk(int arg0, List<HistoricalTickBidAsk> arg1, boolean arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void historicalTicksLast(int arg0, List<HistoricalTickLast> arg1, boolean arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void managedAccounts(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void marketDataType(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void marketRule(int arg0, PriceIncrement[] arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mktDepthExchanges(DepthMktDataDescription[] arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void newsArticle(int arg0, int arg1, String arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void newsProviders(NewsProvider[] arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nextValidId(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void openOrder(int arg0, Contract arg1, Order arg2, OrderState arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void openOrderEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void orderBound(long arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void orderStatus(int arg0, String arg1, Decimal arg2, Decimal arg3, double arg4, int arg5, int arg6,
			double arg7, int arg8, String arg9, double arg10) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pnl(int arg0, double arg1, double arg2, double arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pnlSingle(int arg0, Decimal arg1, double arg2, double arg3, double arg4, double arg5) {
		// TODO Auto-generated method stub

	}

	@Override
	public void position(String arg0, Contract arg1, Decimal arg2, double arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void positionEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void positionMulti(int arg0, String arg1, String arg2, Contract arg3, Decimal arg4, double arg5) {
		// TODO Auto-generated method stub

	}

	@Override
	public void positionMultiEnd(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void receiveFA(int arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void replaceFAEnd(int arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rerouteMktDataReq(int arg0, int arg1, String arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rerouteMktDepthReq(int arg0, int arg1, String arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scannerData(int arg0, int arg1, ContractDetails arg2, String arg3, String arg4, String arg5,
			String arg6) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scannerDataEnd(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scannerParameters(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void securityDefinitionOptionalParameter(int arg0, String arg1, int arg2, String arg3, String arg4,
			Set<String> arg5, Set<Double> arg6) {
		// TODO Auto-generated method stub

	}

	@Override
	public void securityDefinitionOptionalParameterEnd(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void smartComponents(int arg0, Map<Integer, Entry<String, Character>> arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void softDollarTiers(int arg0, SoftDollarTier[] arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void symbolSamples(int arg0, ContractDescription[] arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickByTickAllLast(int arg0, int arg1, long arg2, double arg3, Decimal arg4, TickAttribLast arg5,
			String arg6, String arg7) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickByTickBidAsk(int arg0, long arg1, double arg2, double arg3, Decimal arg4, Decimal arg5,
			TickAttribBidAsk arg6) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickByTickMidPoint(int arg0, long arg1, double arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickEFP(int arg0, int arg1, double arg2, String arg3, double arg4, int arg5, String arg6, double arg7,
			double arg8) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickGeneric(int arg0, int arg1, double arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickNews(int arg0, long arg1, String arg2, String arg3, String arg4, String arg5) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickOptionComputation(int arg0, int arg1, int arg2, double arg3, double arg4, double arg5, double arg6,
			double arg7, double arg8, double arg9, double arg10) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickPrice(int arg0, int arg1, double arg2, TickAttrib arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickReqParams(int arg0, double arg1, String arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickSize(int arg0, int arg1, Decimal arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickSnapshotEnd(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickString(int arg0, int arg1, String arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAccountTime(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAccountValue(String arg0, String arg1, String arg2, String arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMktDepth(int arg0, int arg1, int arg2, int arg3, double arg4, Decimal arg5) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMktDepthL2(int arg0, int arg1, String arg2, int arg3, int arg4, double arg5, Decimal arg6,
			boolean arg7) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNewsBulletin(int arg0, int arg1, String arg2, String arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePortfolio(Contract arg0, Decimal arg1, double arg2, double arg3, double arg4, double arg5,
			double arg6, String arg7) {
		// TODO Auto-generated method stub

	}

	@Override
	public void userInfo(int arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyAndAuthCompleted(boolean arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyAndAuthMessageAPI(String arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyCompleted(boolean arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyMessageAPI(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void wshEventData(int arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void wshMetaData(int arg0, String arg1) {
		// TODO Auto-generated method stub

	}

/////////////////////////////
	@Override
	public void realtimeBar(int reqId, long time, double open, double high, double low, double close, Decimal volume,
			Decimal wap, int count) {

		if (volume.longValue() > 0) {
			LocalDateTime cvDate = Instant.ofEpochMilli(time * 1000l).atZone(ZoneId.systemDefault()).toLocalDateTime();
			RealTimeStockBean realTimeStockBean = new RealTimeStockBean(reqId, cvDate, time * 1000l, open, high, low,
					close, volume.longValue(), Double.valueOf(wap.toString()), Long.valueOf(count));

			try {
				realTimeTradeBlockingQueue.put(realTimeStockBean);
			} catch (InterruptedException e) {
				logger.log(Level.DEBUG, () -> e);
			}
		}
	}

	private void processRealTimeDeque() throws InterruptedException {
		realtimeTempList.clear();
		while (!realTimeTradeBlockingQueue.isEmpty()) {
			realtimeTempList.add(realTimeTradeBlockingQueue.take());
		}

		// save
		// logger.log(Level.DEBUG, () -> "save total: "+ tempList.size());
		dataService.saveRealTimeBean(baseurl, realtimeTempList);
	}

	@Override
	public void historicalData(int id, Bar bar) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		HistoicalStockBean bean = new HistoicalStockBean(id, LocalDate.parse(bar.time(), formatter), bar.open(), bar.high(), bar.low(), 
				bar.close(), Double.valueOf(bar.wap().toString()), Long.valueOf(bar.volume().toString()), Long.valueOf(bar.count()));
		try {
			historyDailyBlockingQueue.put(bean);
		} catch (InterruptedException e) {
			logger.log(Level.DEBUG, () -> e);
		}
	}

	private void processHisDeque() throws InterruptedException {
		hisTempList.clear();
		while (!historyDailyBlockingQueue.isEmpty()) {
			hisTempList.add(historyDailyBlockingQueue.take());
		}
		
		if(hisTempList.size()>0) {
			logger.log(Level.DEBUG, () -> "save total: " + hisTempList.size());
			dataService.saveHistoricalBean(baseurl, savePath, hisTempList);
		}else {
			logger.log(Level.WARN, () -> "save total: " + hisTempList.size());
		}
	}

}
