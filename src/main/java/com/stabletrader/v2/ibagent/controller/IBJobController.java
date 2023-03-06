package com.stabletrader.v2.ibagent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stabletrader.v2.ibagent.data.HistoricalJobRequest;
import com.stabletrader.v2.ibagent.data.RealTimeJobRequest;
import com.stabletrader.v2.ibagent.data.JobResponse;
import com.stabletrader.v2.ibagent.jobs.IBHistoricalDataRequestJob;
import com.stabletrader.v2.ibagent.jobs.IBRealTimeDataRequestsJob;

@RestController
public class IBJobController {
	@Autowired
	private IBRealTimeDataRequestsJob ibRealTimeDataRequestsJob;
	
	@Autowired
	private IBHistoricalDataRequestJob ibHistoricalDataRequestJob;
	
	
	
	@PostMapping("/ibJobs/startRealTimeJob")
	public JobResponse startRealTimeJob(@RequestBody RealTimeJobRequest realTimeJob) {
		ibRealTimeDataRequestsJob.setActiveSymbol(realTimeJob.getActiveSymbolList());
		return ibRealTimeDataRequestsJob.startJob();
	}
	
	@PostMapping("/ibJobs/startHistoricalJob")
	public JobResponse startHistoryJob(@RequestBody HistoricalJobRequest hisReq) {
		return ibHistoricalDataRequestJob.startJob(hisReq);
	}
	
	@PostMapping("/ibJobs/stopHistoricalJob")
	public JobResponse stopHistoryJob() {
		return ibHistoricalDataRequestJob.stopJob();
	}
}
