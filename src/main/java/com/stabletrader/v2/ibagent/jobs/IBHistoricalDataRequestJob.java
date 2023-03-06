package com.stabletrader.v2.ibagent.jobs;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ib.client.Contract;
import com.ib.client.Types;
import com.stabletrader.v2.ibagent.data.HistoricalJobRequest;
import com.stabletrader.v2.ibagent.data.JobResponse;
import com.stabletrader.v2.ibagent.data.StockBean;

@Service
public class IBHistoricalDataRequestJob extends IBDataRequestBase {
	private Logger logger = LogManager.getLogger();
	private volatile int count = 0;
	private ScheduledExecutorService iBTaskExecutor;
	private ScheduledExecutorService deQueExecutor;

	private volatile HistoricalJobRequest historicalJobRequest;
	
	private ScheduledFuture<?> iBTaskFuture ;

	public JobResponse stopJob() {
		JobResponse resp = new JobResponse(200, "stop job success!");
		deQueExecutor.shutdownNow();
		iBTaskExecutor.shutdownNow();
		
		iBTaskFuture=null;
		deQueExecutor=null;
		iBTaskExecutor=null;
		
		return resp;
	}
	
	public JobResponse startJob(HistoricalJobRequest historicalJobRequest) {
		JobResponse resp = new JobResponse(200, "success!");
		this.historicalJobRequest = historicalJobRequest;
		
		if (iBTaskExecutor == null || iBTaskExecutor.isShutdown() || iBTaskExecutor.isTerminated()
				|| iBTaskFuture == null || iBTaskFuture.isDone() || iBTaskFuture.isCancelled()) {
			iBTaskExecutor = Executors.newScheduledThreadPool(1);
			iBTaskFuture = iBTaskExecutor.scheduleAtFixedRate(iBTask, 0, 10, TimeUnit.SECONDS);
		} else {
			requestHistoricalData();
		}

		try {
			iBTaskFuture.get(15, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
		}catch (InterruptedException e) {
			resp.setStatus(300);
			resp.setMessage(e.getLocalizedMessage());
			logger.log(Level.ERROR, () -> e);
		} catch (ExecutionException e) {
			resp.setStatus(400);
			resp.setMessage(e.getLocalizedMessage());
			logger.log(Level.ERROR, () -> e);
		} finally {
			if (resp.getStatus() != 200) {
				iBTaskExecutor.shutdown();
			}
		}

		return resp;
	}

	private Runnable iBTask = () -> {
		try {
			super.ibWrapper.init();
		} catch (IOException e) {
			logger.log(Level.ERROR, () -> e);
			throw new RuntimeException(e);
		}

		if (!super.ibWrapper.isConnected()) {
			super.ibWrapper.connectTWS(7);
			requestHistoricalData();
			startDeque();
		}

	};

	private void startDeque() {
		if ("1 day".equals(historicalJobRequest.getBarSize())) {
			super.ibWrapper.setSavePath("daily/");
		}
		deQueExecutor = Executors.newScheduledThreadPool(1);
		ScheduledFuture<?> future = deQueExecutor.scheduleAtFixedRate(super.ibWrapper.getHistoricalDequeueRunnable(), 1,
				5, TimeUnit.SECONDS);
		try {
			future.get(10, TimeUnit.SECONDS);
		}catch (TimeoutException e) {
		}catch (InterruptedException e) {
			logger.log(Level.ERROR, () -> e);
			throw new RuntimeException(e);
		} catch (ExecutionException e) {
			logger.log(Level.ERROR, () -> e);
			throw new RuntimeException(e);
		}
	}

	private void requestHistoricalData() {
		Map<Integer, StockBean> ibMap = super.ibWrapper.getStockByIDMap();
		List<String> symbolList = historicalJobRequest.getSymbols();
		if (!symbolList.isEmpty()) {
			if (symbolList.size() == 1 && "All".equals(symbolList.get(0))) {
				count = 0;
				for (StockBean bean : ibMap.values()) {
					Contract contract = getIBContract(bean.getStockSymbol());
					
					if(contract==null) {
						continue;
					}

					super.ibWrapper.requestHistoryData(bean.getId(), contract, historicalJobRequest.getEndDateTime(),
							historicalJobRequest.getDuration(), historicalJobRequest.getBarSize(),
							Types.WhatToShow.TRADES.name());
					logger.log(Level.DEBUG, () -> bean.getStockSymbol() + " is rquested.");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						logger.log(Level.ERROR, () -> e);
					}
					count++;
				}

				logger.log(Level.DEBUG, () -> "toatl " + count + " is rquested.");
			} else if (symbolList.size() == 1) {
				String symbol = symbolList.get(0);
				Contract contract = getIBContract(symbol);
				super.ibWrapper.requestHistoryData(super.ibWrapper.getStockBySymbolMap().get(symbol).getId(), contract,
						historicalJobRequest.getEndDateTime(), historicalJobRequest.getDuration(),
						historicalJobRequest.getBarSize(), Types.WhatToShow.TRADES.name());

				logger.log(Level.DEBUG, () -> symbol + " is rquested.");
			} else {
				for (String symbol : symbolList) {
					Contract contract = getIBContract(symbol);
					if(contract==null) {
						continue;
					}
					super.ibWrapper.requestHistoryData(super.ibWrapper.getStockBySymbolMap().get(symbol).getId(),
							contract, historicalJobRequest.getEndDateTime(), historicalJobRequest.getDuration(),
							historicalJobRequest.getBarSize(), Types.WhatToShow.TRADES.name());

					logger.log(Level.DEBUG, () -> symbol + " is rquested.");
				}
			}
		}
	}

}
