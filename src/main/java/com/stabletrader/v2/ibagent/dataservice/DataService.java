package com.stabletrader.v2.ibagent.dataservice;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stabletrader.v2.ibagent.data.HistoicalStockBean;
import com.stabletrader.v2.ibagent.data.RealTimeStockBean;

@Service
public class DataService {
	private Logger logger = LogManager.getLogger();

	public List<Object> getStockList(String baseurl) throws IOException { 
		String url = baseurl + "getStocks";
		RestTemplate restTemplate = new RestTemplate();
		List<Object> resp = restTemplate.getForObject(url, List.class);
		return resp;
	}

	public List<Object> saveRealTimeBean(String baseurl, List <RealTimeStockBean> beanList) {
		String url = baseurl + "saveRealTimeStocks";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> result=restTemplate.postForEntity(url, beanList, List.class);
		//logger.log(Level.DEBUG, () -> "save status: "+ result.getStatusCode().value());
		return result.getBody();
	}
	
	public List<Object> saveHistoricalBean(String baseurl, String savePath, List<HistoicalStockBean> beanList) {
		String url = baseurl + savePath + "saveHistoricalStocks";
		logger.log(Level.DEBUG, () -> beanList.size());

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> result = restTemplate.postForEntity(url, beanList, List.class);
		logger.log(Level.DEBUG, () -> "save status: " + result.getStatusCode().value());
		return result.getBody();

	}
}
