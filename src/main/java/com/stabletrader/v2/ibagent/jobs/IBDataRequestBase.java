package com.stabletrader.v2.ibagent.jobs;

import org.springframework.beans.factory.annotation.Autowired;

import com.ib.client.Contract;
import com.stabletrader.v2.ibagent.enums.IBContracts;
import com.stabletrader.v2.ibagent.wrapper.IBDataProcessorWrapper;

public abstract class IBDataRequestBase {
	@Autowired
	protected IBDataProcessorWrapper ibWrapper;
	
	protected Contract getIBContract(String symbol) {
		Contract contract=IBContracts.getIBContractsBySymbol(symbol)==null?null:IBContracts.getIBContractsBySymbol(symbol).getContract();
		return contract;
	}

}
