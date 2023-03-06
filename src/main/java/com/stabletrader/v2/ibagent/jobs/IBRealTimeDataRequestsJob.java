package com.stabletrader.v2.ibagent.jobs;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ib.client.Contract;
import com.stabletrader.v2.ibagent.data.JobResponse;
import com.stabletrader.v2.ibagent.data.StockBean;
import com.stabletrader.v2.ibagent.enums.FederalHoliday;

@Service
public class IBRealTimeDataRequestsJob extends IBDataRequestBase{
	private Logger logger = LogManager.getLogger();
	
	private  String [] activeSymbolArray={"AAPL", "GOOG", "MSFT", "QQQ", "AMZN", "FB", "INTC", "CMCSA", "BRK B"};
	
	private Set<String> activeSymbol =new HashSet<String>(Arrays.asList(activeSymbolArray));
	
	private ScheduledExecutorService iBTaskExecutor;
	
	private volatile int count=0;
	
	private LocalTime markeetOpen=LocalTime.of(9, 30);
	private LocalTime markeetcloase=LocalTime.of(16, 0);
	

	public JobResponse startJob() {
		JobResponse resp=new JobResponse(200, "success!");
		if(isTradingTime()) {
			iBTaskExecutor = Executors.newScheduledThreadPool(1);
			ScheduledFuture<?> future =iBTaskExecutor.scheduleAtFixedRate(iBTask, 0, 10, TimeUnit.SECONDS);
			try {
				future.get();
			} catch (InterruptedException e) {
				resp.setStatus(300);
				resp.setMessage(e.getLocalizedMessage());
				logger.log(Level.ERROR, () -> e);
			} catch (ExecutionException e) {
				resp.setStatus(400);
				resp.setMessage(e.getLocalizedMessage());
				logger.log(Level.ERROR, () -> e);
			}finally{
				if(resp.getStatus()!=200) {
					iBTaskExecutor.shutdown();
				}
			}
		}else {
			resp.setStatus(500);
			resp.setMessage("it is not trading time");
		}
		
		return resp;
	}
	

	public void stopJob() {
		iBTaskExecutor.shutdown();
	}
	
	private Runnable iBTask = () ->{
			try {
				super.ibWrapper.init();
			} catch (IOException e) {
				logger.log(Level.ERROR, () -> e);
				throw new RuntimeException(e);
			}
			
			if(!super.ibWrapper.isConnected()){
				super.ibWrapper.connectTWS(7);
				requestRealTimeData();
				startDeque();
			}
			
	};
	
	private void requestRealTimeData(){
		Map<Integer, StockBean> ibMap=super.ibWrapper.getStockByIDMap();
		///System.out.println(ibMap);
		count=0;
		for (StockBean bean: ibMap.values()) {
			Contract contract =getIBContract(bean.getStockSymbol());
			if(contract==null || !activeSymbol.contains(bean.getStockSymbol())) {
				continue;
			}
			super.ibWrapper.reqestRealTimeBar(bean.getId(), contract);
			logger.log(Level.DEBUG, () -> bean.getStockSymbol() +" is rquested.");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				logger.log(Level.ERROR, () -> e);
			}
			count++;
		}
		
		logger.log(Level.DEBUG, () -> "toatl "+count+" is rquested.");
	}
	
	private void startDeque() {
		ScheduledExecutorService deQueExecutor = Executors.newScheduledThreadPool(1);
		ScheduledFuture<?> future =deQueExecutor.scheduleAtFixedRate(super.ibWrapper.getRealtimeDequeueRunnable(), 1, 20, TimeUnit.SECONDS);
		try {
			future.get();
		} catch (InterruptedException e) {
			logger.log(Level.ERROR, () -> e);
			throw new RuntimeException(e);
		} catch (ExecutionException e) {
			logger.log(Level.ERROR, () -> e);
			throw new RuntimeException(e);
		}
	}

	public void setActiveSymbol(Set<String> activeSymbol) {
		this.activeSymbol = activeSymbol;
	}
	
	private boolean isTradingTime(){
		LocalTime nowTime=LocalTime.now();
		LocalDate nowDay=LocalDate.now();
		
		if(!FederalHoliday.isNonWorkday(nowDay)) {
			return nowTime.isAfter(markeetOpen) && nowTime.isBefore(markeetcloase);
		}
		
		return false;
	}
}
