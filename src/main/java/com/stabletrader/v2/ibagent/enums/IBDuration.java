package com.stabletrader.v2.ibagent.enums;

public enum IBDuration {
	
	SEC("S"),
	DAY("D"),
	WEEK("W"),
	MON("M"),
	YEAR("Y");
		
	private String value;
	private IBDuration(String value){
		this.value=value;
	}
	public String getValue(int length) {
		return length+" "+value;
	}
}
