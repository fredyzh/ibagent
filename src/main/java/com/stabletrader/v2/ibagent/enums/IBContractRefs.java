package com.stabletrader.v2.ibagent.enums;

public enum IBContractRefs {
	CURRENCY_USD("USD"),
	EXCHANGE_SMART("SMART"),
	EXCHANGE_NASDAQ("NASDAQ"),
	EXCHANGE_NYSE("NYSE"),
	EXCHANGE_CBOE("CBOE"),
	EXCHANGE_RUSSELL("RUSSELL"),
	EXCHANGE_ARCA("ARCA"),
	STK_SEC_TYPE("STK"),
	IND_SEC_TYPE("IND"),
	OPT_SEC_TYPE("OPT"),
	FUT_SEC_TYPE("FUT"),
	CASH_SEC_TYPE("CASH"),
	OPT_RIGHT_CALL("C"),
	OPT_RIGHT_PUT("P"),
	;
	
	private IBContractRefs(String name){
		this.name=name;
	}
	
	private String name;

	public String getName() {
		return name;
	}
}
