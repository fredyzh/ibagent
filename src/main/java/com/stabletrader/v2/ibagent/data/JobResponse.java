package com.stabletrader.v2.ibagent.data;

import java.beans.JavaBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JavaBean
public class JobResponse {
	private int status;
	private String message;
}
