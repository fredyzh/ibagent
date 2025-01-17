package com.stabletrader.v2.ibagent.enums;

import java.util.ArrayList;
import java.util.List;

public enum SymbolsEnum {
	
	QQQ("QQQ", "QQQ", true, false),
	//NAZ("COMP", "IXIC", true, false),
	AAPL("AAPL", "AAPL", true, true),
	GOOGL("GOOG", "GOOG", true, true),
	GOOG("GOOGL", "GOOGL", true, true),
	GILD("GILD", "GILD", true, true),
	MSFT("MSFT", "MSFT", true, true),
	META("META", "META", true, true),
	AMZN("AMZN", "AMZN", true, true),
	SPX("SPX", "GSPC", false, true),
    RUT("RUT", "RUT", false, false),
    DIA("DIA", "DIA", false, false),
    TNA("TNA", "TNA", false, false),
    TZA("TZA","TZA", false, false),
    SPXL("SPXL", "SPXL", false, false),
    SPXS("SPXS", "SPXS", false, false),
    TQQQ("TQQQ", "TQQQ", false, false),
    SQQQ("SQQQ", "SQQQ", false, false),
    TLT("TLT", "TLT", false, false),
    XOM("XOM", "XOM", false, true),
    JNJ("JNJ", "JNJ", false, true),
    WFC("WFC", "WFC", false, true),
    GE("GE", "GE", false, true),
    BRK_B("BRK B","BRK_B", false, true),
    JPM("JPM", "JPM", false, true),
    PG("PG", "PG", false, true),
    VZ("VZ", "VZ", false, true),
    BAC("BAC", "BAC", false, true),
    DIS("DIS", "DIS", false, true),
    C("C","C", false, true),
    T("T", "T", false, true),
    PFE("PFE","PFE", false, true),
    CVX("CVX","CVX", false, true),
    HON("HON","HON", false, false),
    MCD("MCD","MCD", false, false),
    TSLA("TSLA","TSLA", true, true),
    UNH("UNH","UNH", true, true),
    V("V","V", true, true),
	AVGO("AVGO","AVGO", false, true),
	COST("COST","COST", true, false),
	LLY("LLY","LLY", true, true),
	CRM("CRM","CRM", false, false),
	SOXX("SOXX","CRM", false, false),
	TRV("TRV","TRV", false, false)
	;
	
	private String IBSymbol;
	private String YahooSymbol;
	private Boolean isNazInd;
	private Boolean isSpxInd;
	private static List<SymbolsEnum> nazComList=new ArrayList<>();
	private static List<SymbolsEnum> spxComList=new ArrayList<>();
	private static List<String> nazSymbolList=new ArrayList<>();
	private static List<String> spxSymbolList=new ArrayList<>();
	private static List<String> ibSymbolList=new ArrayList<>();
	
	private SymbolsEnum(String IBSymbol, String YahooSymbol, Boolean isNazInd, Boolean isSpxInd){ 
		this.IBSymbol=IBSymbol;
		this.YahooSymbol=YahooSymbol;
		this.isNazInd=isNazInd;
		this.isSpxInd=isSpxInd;
	}

	public String getIBSymbol() {
		return IBSymbol;
	}

	public String getYahooSymbol() {
		return YahooSymbol;
	}

	public static List<SymbolsEnum> getNazComList() {
		if(nazComList.isEmpty()){
			for(SymbolsEnum e:values()){
				if(e.isNazInd){
					nazComList.add(e);
				}	
			}	
		}
		return nazComList;
	}
	
	public static List<String> getNazSymbolList() {
		if(nazSymbolList.isEmpty()){
			for(SymbolsEnum e:getNazComList()){
				nazSymbolList.add(e.getIBSymbol());
			}	
		}
		return nazSymbolList;
	}

	public static List<SymbolsEnum> getSpxComList() {
		if(spxComList.isEmpty()){
			for(SymbolsEnum e:values()){
				if(e.isSpxInd){
					spxComList.add(e);
				}	
			}
			
		}
		return spxComList;
	}
	
	public static List<String> getSpxSymbolList() {
		if(spxSymbolList.isEmpty()){
			for(SymbolsEnum e: getSpxComList()){
				spxSymbolList.add(e.getIBSymbol());	
			}
		}
		return spxSymbolList;
	}
	
	public static List<String> getIbSymbolList() {
		if(ibSymbolList.isEmpty()){
			for(SymbolsEnum e: values()){
				ibSymbolList.add(e.getIBSymbol());	
			}
		}
		return ibSymbolList;
	}

}
