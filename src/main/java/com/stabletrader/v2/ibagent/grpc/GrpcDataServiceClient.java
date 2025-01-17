package com.stabletrader.v2.ibagent.grpc;

import com.stabletrader.v2.ibagent.grpc.protos.StockServiceGrpc;

import io.grpc.Channel;

public class GrpcDataServiceClient {
	private StockServiceGrpc.StockServiceBlockingStub svcblkStub;
	
	private StockServiceGrpc.StockServiceStub svcbStub;
	
	public GrpcDataServiceClient(Channel chan) {
		svcblkStub=StockServiceGrpc.newBlockingStub(chan);
		svcbStub=StockServiceGrpc.newStub(chan);
	}

	public StockServiceGrpc.StockServiceBlockingStub getSvcBlockingStub() {
		return svcblkStub;
	}
	
	public StockServiceGrpc.StockServiceStub getSvcStub() {
		return svcbStub;
	}

}
