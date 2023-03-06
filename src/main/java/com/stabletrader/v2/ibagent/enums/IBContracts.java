package com.stabletrader.v2.ibagent.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ib.client.Contract;

public enum IBContracts {
	SPX("SPX", IBContractRefs.EXCHANGE_CBOE.getName(), IBContractRefs.EXCHANGE_CBOE.getName(),
			IBContractRefs.IND_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	QQQ("QQQ", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	// NAZ("COMP",
	// IBContractRefs.EXCHANGE_NASDAQ.getName(),IBContractRefs.EXCHANGE_NASDAQ.getName(),
	// IBContractRefs.IND_SEC_TYPE.getName(),
	// IBContractRefs.CURRENCY_USD.getName()),
	RUT("RUT", IBContractRefs.EXCHANGE_RUSSELL.getName(), IBContractRefs.EXCHANGE_RUSSELL.getName(),
			IBContractRefs.IND_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	DIA("DIA", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	TNA("TNA", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	TZA("TZA", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	SPXL("SPXL", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	SPXS("SPXS", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_ARCA.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	TQQQ("TQQQ", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	SQQQ("SQQQ", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	TLT("TLT", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	AAPL("AAPL", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	GOOGL("GOOGL", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	GOOG("GOOG", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	MSFT("MSFT", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_NASDAQ.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	META("META", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_NASDAQ.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	AMZN("AMZN", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	GILD("GILD", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	XOM("XOM", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	JNJ("JNJ", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	WFC("WFC", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	GE("GE", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	BRK("BRK B", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	JPM("JPM", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	PG("PG", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	VZ("VZ", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	BAC("BAC", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	DIS("DIS", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	C("C", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	T("T", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	PFE("PFE", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	CVX("CVX", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	INTC("INTC", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	CMCSA("CMCSA", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	CSCO("CSCO", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_NASDAQ.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	PEP("PEP", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	BA("BA", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	GS("GS", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	HD("HD", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	HON("HON", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	MCD("MCD", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	NVDA("NVDA", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	TSLA("TSLA", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	UNH("UNH", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName()),
	V("V", IBContractRefs.EXCHANGE_SMART.getName(), IBContractRefs.EXCHANGE_SMART.getName(),
			IBContractRefs.STK_SEC_TYPE.getName(), IBContractRefs.CURRENCY_USD.getName());

	private String symbol;
	private String exchange;
	private String primExchange;
	private String secType;
	private String currency;

	private static Map<String, IBContracts> contractCache = new ConcurrentHashMap<>();

	private IBContracts(String symbol, String exchange, String primExchange, String secType, String currency) {
		this.symbol = symbol;
		this.exchange = exchange;
		this.primExchange = primExchange;
		this.secType = secType;
		this.currency = currency;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getExchange() {
		return exchange;
	}

	public String getSecType() {
		return secType;
	}

	public String getCurrency() {
		return currency;
	}

	public String getPrimExchange() {
		return primExchange;
	}

	public Contract getContract() {
		Contract contract = new Contract();
		contract.exchange(getExchange());
		contract.primaryExch(getPrimExchange());
		contract.secType(getSecType());
		contract.currency(getCurrency());
		contract.symbol(getSymbol());

		return contract;
	}

	public static IBContracts getIBContractsBySymbol(String symbol) {

		if (contractCache.containsKey(symbol)) {
			return contractCache.get(symbol);
		}

		for (IBContracts sticker : values()) {
			if (symbol.equals(sticker.getSymbol())) {
				contractCache.put(symbol, sticker);
				return sticker;
			}
		}

		return null;
	}

}
