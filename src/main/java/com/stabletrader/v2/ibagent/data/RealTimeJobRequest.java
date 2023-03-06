package com.stabletrader.v2.ibagent.data;

import java.beans.JavaBean;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JavaBean
public class RealTimeJobRequest {
	private Set<String> activeSymbolList=new HashSet<>();
}
