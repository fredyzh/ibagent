package com.stabletrader.v2.ibagent.grpc.protos;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StockServiceGrpc {

  private StockServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "grpcserver.StockService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.stabletrader.v2.ibagent.grpc.protos.GrpcStock> getGetStocksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStocks",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.stabletrader.v2.ibagent.grpc.protos.GrpcStock.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.stabletrader.v2.ibagent.grpc.protos.GrpcStock> getGetStocksMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.stabletrader.v2.ibagent.grpc.protos.GrpcStock> getGetStocksMethod;
    if ((getGetStocksMethod = StockServiceGrpc.getGetStocksMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getGetStocksMethod = StockServiceGrpc.getGetStocksMethod) == null) {
          StockServiceGrpc.getGetStocksMethod = getGetStocksMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.stabletrader.v2.ibagent.grpc.protos.GrpcStock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStocks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stabletrader.v2.ibagent.grpc.protos.GrpcStock.getDefaultInstance()))
              .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("GetStocks"))
              .build();
        }
      }
    }
    return getGetStocksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.stabletrader.v2.ibagent.grpc.protos.GrpcStock,
      com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> getSaveOrUpdateStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveOrUpdateStock",
      requestType = com.stabletrader.v2.ibagent.grpc.protos.GrpcStock.class,
      responseType = com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.stabletrader.v2.ibagent.grpc.protos.GrpcStock,
      com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> getSaveOrUpdateStockMethod() {
    io.grpc.MethodDescriptor<com.stabletrader.v2.ibagent.grpc.protos.GrpcStock, com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> getSaveOrUpdateStockMethod;
    if ((getSaveOrUpdateStockMethod = StockServiceGrpc.getSaveOrUpdateStockMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getSaveOrUpdateStockMethod = StockServiceGrpc.getSaveOrUpdateStockMethod) == null) {
          StockServiceGrpc.getSaveOrUpdateStockMethod = getSaveOrUpdateStockMethod =
              io.grpc.MethodDescriptor.<com.stabletrader.v2.ibagent.grpc.protos.GrpcStock, com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SaveOrUpdateStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stabletrader.v2.ibagent.grpc.protos.GrpcStock.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("SaveOrUpdateStock"))
              .build();
        }
      }
    }
    return getSaveOrUpdateStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.stabletrader.v2.ibagent.grpc.protos.GrpcStock,
      com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> getCreateStocksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateStocks",
      requestType = com.stabletrader.v2.ibagent.grpc.protos.GrpcStock.class,
      responseType = com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.stabletrader.v2.ibagent.grpc.protos.GrpcStock,
      com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> getCreateStocksMethod() {
    io.grpc.MethodDescriptor<com.stabletrader.v2.ibagent.grpc.protos.GrpcStock, com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> getCreateStocksMethod;
    if ((getCreateStocksMethod = StockServiceGrpc.getCreateStocksMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getCreateStocksMethod = StockServiceGrpc.getCreateStocksMethod) == null) {
          StockServiceGrpc.getCreateStocksMethod = getCreateStocksMethod =
              io.grpc.MethodDescriptor.<com.stabletrader.v2.ibagent.grpc.protos.GrpcStock, com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateStocks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stabletrader.v2.ibagent.grpc.protos.GrpcStock.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("CreateStocks"))
              .build();
        }
      }
    }
    return getCreateStocksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int64Value,
      com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> getRemoveStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveStock",
      requestType = com.google.protobuf.Int64Value.class,
      responseType = com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Int64Value,
      com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> getRemoveStockMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Int64Value, com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> getRemoveStockMethod;
    if ((getRemoveStockMethod = StockServiceGrpc.getRemoveStockMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getRemoveStockMethod = StockServiceGrpc.getRemoveStockMethod) == null) {
          StockServiceGrpc.getRemoveStockMethod = getRemoveStockMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Int64Value, com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int64Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("RemoveStock"))
              .build();
        }
      }
    }
    return getRemoveStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock,
      com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> getCreateDailyStocksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDailyStocks",
      requestType = com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock.class,
      responseType = com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock,
      com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> getCreateDailyStocksMethod() {
    io.grpc.MethodDescriptor<com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock, com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> getCreateDailyStocksMethod;
    if ((getCreateDailyStocksMethod = StockServiceGrpc.getCreateDailyStocksMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getCreateDailyStocksMethod = StockServiceGrpc.getCreateDailyStocksMethod) == null) {
          StockServiceGrpc.getCreateDailyStocksMethod = getCreateDailyStocksMethod =
              io.grpc.MethodDescriptor.<com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock, com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDailyStocks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("CreateDailyStocks"))
              .build();
        }
      }
    }
    return getCreateDailyStocksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.stabletrader.v2.ibagent.grpc.protos.GrpcStockDurationRequest,
      com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock> getRetrieveDailyByDurationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveDailyByDuration",
      requestType = com.stabletrader.v2.ibagent.grpc.protos.GrpcStockDurationRequest.class,
      responseType = com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.stabletrader.v2.ibagent.grpc.protos.GrpcStockDurationRequest,
      com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock> getRetrieveDailyByDurationMethod() {
    io.grpc.MethodDescriptor<com.stabletrader.v2.ibagent.grpc.protos.GrpcStockDurationRequest, com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock> getRetrieveDailyByDurationMethod;
    if ((getRetrieveDailyByDurationMethod = StockServiceGrpc.getRetrieveDailyByDurationMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getRetrieveDailyByDurationMethod = StockServiceGrpc.getRetrieveDailyByDurationMethod) == null) {
          StockServiceGrpc.getRetrieveDailyByDurationMethod = getRetrieveDailyByDurationMethod =
              io.grpc.MethodDescriptor.<com.stabletrader.v2.ibagent.grpc.protos.GrpcStockDurationRequest, com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RetrieveDailyByDuration"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stabletrader.v2.ibagent.grpc.protos.GrpcStockDurationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock.getDefaultInstance()))
              .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("RetrieveDailyByDuration"))
              .build();
        }
      }
    }
    return getRetrieveDailyByDurationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock,
      com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> getSaveOrUdpdateDailyStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveOrUdpdateDailyStock",
      requestType = com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock.class,
      responseType = com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock,
      com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> getSaveOrUdpdateDailyStockMethod() {
    io.grpc.MethodDescriptor<com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock, com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> getSaveOrUdpdateDailyStockMethod;
    if ((getSaveOrUdpdateDailyStockMethod = StockServiceGrpc.getSaveOrUdpdateDailyStockMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getSaveOrUdpdateDailyStockMethod = StockServiceGrpc.getSaveOrUdpdateDailyStockMethod) == null) {
          StockServiceGrpc.getSaveOrUdpdateDailyStockMethod = getSaveOrUdpdateDailyStockMethod =
              io.grpc.MethodDescriptor.<com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock, com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SaveOrUdpdateDailyStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("SaveOrUdpdateDailyStock"))
              .build();
        }
      }
    }
    return getSaveOrUdpdateDailyStockMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StockServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StockServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StockServiceStub>() {
        @java.lang.Override
        public StockServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StockServiceStub(channel, callOptions);
        }
      };
    return StockServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StockServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StockServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StockServiceBlockingStub>() {
        @java.lang.Override
        public StockServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StockServiceBlockingStub(channel, callOptions);
        }
      };
    return StockServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StockServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StockServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StockServiceFutureStub>() {
        @java.lang.Override
        public StockServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StockServiceFutureStub(channel, callOptions);
        }
      };
    return StockServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getStocks(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcStock> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStocksMethod(), responseObserver);
    }

    /**
     */
    default void saveOrUpdateStock(com.stabletrader.v2.ibagent.grpc.protos.GrpcStock request,
        io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSaveOrUpdateStockMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcStock> createStocks(
        io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getCreateStocksMethod(), responseObserver);
    }

    /**
     */
    default void removeStock(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveStockMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock> createDailyStocks(
        io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getCreateDailyStocksMethod(), responseObserver);
    }

    /**
     */
    default void retrieveDailyByDuration(com.stabletrader.v2.ibagent.grpc.protos.GrpcStockDurationRequest request,
        io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRetrieveDailyByDurationMethod(), responseObserver);
    }

    /**
     */
    default void saveOrUdpdateDailyStock(com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock request,
        io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSaveOrUdpdateDailyStockMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service StockService.
   */
  public static abstract class StockServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return StockServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service StockService.
   */
  public static final class StockServiceStub
      extends io.grpc.stub.AbstractAsyncStub<StockServiceStub> {
    private StockServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StockServiceStub(channel, callOptions);
    }

    /**
     */
    public void getStocks(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcStock> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetStocksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void saveOrUpdateStock(com.stabletrader.v2.ibagent.grpc.protos.GrpcStock request,
        io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveOrUpdateStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcStock> createStocks(
        io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getCreateStocksMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void removeStock(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock> createDailyStocks(
        io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getCreateDailyStocksMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void retrieveDailyByDuration(com.stabletrader.v2.ibagent.grpc.protos.GrpcStockDurationRequest request,
        io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getRetrieveDailyByDurationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void saveOrUdpdateDailyStock(com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock request,
        io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveOrUdpdateDailyStockMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service StockService.
   */
  public static final class StockServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StockServiceBlockingStub> {
    private StockServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StockServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.stabletrader.v2.ibagent.grpc.protos.GrpcStock> getStocks(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetStocksMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse saveOrUpdateStock(com.stabletrader.v2.ibagent.grpc.protos.GrpcStock request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveOrUpdateStockMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse removeStock(com.google.protobuf.Int64Value request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveStockMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock> retrieveDailyByDuration(
        com.stabletrader.v2.ibagent.grpc.protos.GrpcStockDurationRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getRetrieveDailyByDurationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse saveOrUdpdateDailyStock(com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveOrUdpdateDailyStockMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service StockService.
   */
  public static final class StockServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<StockServiceFutureStub> {
    private StockServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StockServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> saveOrUpdateStock(
        com.stabletrader.v2.ibagent.grpc.protos.GrpcStock request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveOrUpdateStockMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> removeStock(
        com.google.protobuf.Int64Value request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveStockMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse> saveOrUdpdateDailyStock(
        com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveOrUdpdateDailyStockMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_STOCKS = 0;
  private static final int METHODID_SAVE_OR_UPDATE_STOCK = 1;
  private static final int METHODID_REMOVE_STOCK = 2;
  private static final int METHODID_RETRIEVE_DAILY_BY_DURATION = 3;
  private static final int METHODID_SAVE_OR_UDPDATE_DAILY_STOCK = 4;
  private static final int METHODID_CREATE_STOCKS = 5;
  private static final int METHODID_CREATE_DAILY_STOCKS = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STOCKS:
          serviceImpl.getStocks((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcStock>) responseObserver);
          break;
        case METHODID_SAVE_OR_UPDATE_STOCK:
          serviceImpl.saveOrUpdateStock((com.stabletrader.v2.ibagent.grpc.protos.GrpcStock) request,
              (io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse>) responseObserver);
          break;
        case METHODID_REMOVE_STOCK:
          serviceImpl.removeStock((com.google.protobuf.Int64Value) request,
              (io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse>) responseObserver);
          break;
        case METHODID_RETRIEVE_DAILY_BY_DURATION:
          serviceImpl.retrieveDailyByDuration((com.stabletrader.v2.ibagent.grpc.protos.GrpcStockDurationRequest) request,
              (io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock>) responseObserver);
          break;
        case METHODID_SAVE_OR_UDPDATE_DAILY_STOCK:
          serviceImpl.saveOrUdpdateDailyStock((com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock) request,
              (io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_STOCKS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.createStocks(
              (io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse>) responseObserver);
        case METHODID_CREATE_DAILY_STOCKS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.createDailyStocks(
              (io.grpc.stub.StreamObserver<com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetStocksMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.stabletrader.v2.ibagent.grpc.protos.GrpcStock>(
                service, METHODID_GET_STOCKS)))
        .addMethod(
          getSaveOrUpdateStockMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.stabletrader.v2.ibagent.grpc.protos.GrpcStock,
              com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse>(
                service, METHODID_SAVE_OR_UPDATE_STOCK)))
        .addMethod(
          getCreateStocksMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.stabletrader.v2.ibagent.grpc.protos.GrpcStock,
              com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse>(
                service, METHODID_CREATE_STOCKS)))
        .addMethod(
          getRemoveStockMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Int64Value,
              com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse>(
                service, METHODID_REMOVE_STOCK)))
        .addMethod(
          getCreateDailyStocksMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock,
              com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse>(
                service, METHODID_CREATE_DAILY_STOCKS)))
        .addMethod(
          getRetrieveDailyByDurationMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.stabletrader.v2.ibagent.grpc.protos.GrpcStockDurationRequest,
              com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock>(
                service, METHODID_RETRIEVE_DAILY_BY_DURATION)))
        .addMethod(
          getSaveOrUdpdateDailyStockMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock,
              com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse>(
                service, METHODID_SAVE_OR_UDPDATE_DAILY_STOCK)))
        .build();
  }

  private static abstract class StockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StockServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.stabletrader.v2.ibagent.grpc.protos.GRPCDataService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StockService");
    }
  }

  private static final class StockServiceFileDescriptorSupplier
      extends StockServiceBaseDescriptorSupplier {
    StockServiceFileDescriptorSupplier() {}
  }

  private static final class StockServiceMethodDescriptorSupplier
      extends StockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    StockServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StockServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StockServiceFileDescriptorSupplier())
              .addMethod(getGetStocksMethod())
              .addMethod(getSaveOrUpdateStockMethod())
              .addMethod(getCreateStocksMethod())
              .addMethod(getRemoveStockMethod())
              .addMethod(getCreateDailyStocksMethod())
              .addMethod(getRetrieveDailyByDurationMethod())
              .addMethod(getSaveOrUdpdateDailyStockMethod())
              .build();
        }
      }
    }
    return result;
  }
}
