package com.stabletrader.v2.ibagent.data;

import java.beans.JavaBean;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JavaBean
public class RealTimeStockBean {

	public RealTimeStockBean(int reqId, LocalDateTime cvDate, long time, double open, double high, double low,
			double close, long volume, double wap, Long count) {
		this.stockId=reqId;
		this.date=cvDate;
		this.time=time;
		this.open=open;
		this.high=high;
		this.low=low;
		this.close=close;
		this.volume=volume;
		this.wap=wap;
		this.count=count;
	}

	private Integer stockId;

	private LocalDateTime date;

	private Long time;

	private Double open;

	private Double high;

	private Double low;

	private Double close;

	private Double wap;

	private Long volume;

	private Long count;
}
