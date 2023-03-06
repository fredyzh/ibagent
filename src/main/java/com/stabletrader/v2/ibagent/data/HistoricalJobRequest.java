package com.stabletrader.v2.ibagent.data;

import java.beans.JavaBean;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JavaBean
public class HistoricalJobRequest {
	private List<String> symbols;
	private String endDateTime;
	private String duration;
	private String barSize;
}
