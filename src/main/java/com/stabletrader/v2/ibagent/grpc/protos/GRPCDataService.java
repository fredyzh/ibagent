// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package com.stabletrader.v2.ibagent.grpc.protos;

public final class GRPCDataService {
  private GRPCDataService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcserver_GrpcResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcserver_GrpcResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcserver_GrpcStockDurationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcserver_GrpcStockDurationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcserver_GrpcStock_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcserver_GrpcStock_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcserver_GrpcDailyHistoricalStock_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcserver_GrpcDailyHistoricalStock_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rservice.proto\022\ngrpcserver\032\031google/prot" +
      "obuf/any.proto\032\037google/protobuf/Timestam" +
      "p.proto\032\033google/protobuf/Empty.proto\032\036go" +
      "ogle/protobuf/wrappers.proto\"R\n\014GrpcResp" +
      "onse\022\r\n\005error\030\001 \001(\010\022\017\n\007message\030\002 \001(\t\022\"\n\004" +
      "data\030\003 \001(\0132\024.google.protobuf.Any\"\177\n\030Grpc" +
      "StockDurationRequest\022\017\n\007symbols\030\001 \003(\t\022)\n" +
      "\005start\030\002 \001(\0132\032.google.protobuf.Timestamp" +
      "\022\'\n\003end\030\003 \001(\0132\032.google.protobuf.Timestam" +
      "p\"-\n\tGrpcStock\022\n\n\002id\030\001 \001(\004\022\024\n\014stock_symb" +
      "ol\030\002 \001(\t\"\306\001\n\030GrpcDailyHistoricalStock\022\n\n" +
      "\002id\030\001 \001(\004\022\r\n\005close\030\002 \001(\001\022\014\n\004open\030\003 \001(\001\022\014" +
      "\n\004high\030\004 \001(\001\022\013\n\003low\030\005 \001(\001\022(\n\004date\030\006 \001(\0132" +
      "\032.google.protobuf.Timestamp\022\020\n\010stock_id\030" +
      "\007 \001(\004\022\r\n\005count\030\010 \001(\004\022\016\n\006volume\030\t \001(\004\022\013\n\003" +
      "wap\030\n \001(\0012\266\004\n\014StockService\022<\n\tGetStocks\022" +
      "\026.google.protobuf.Empty\032\025.grpcserver.Grp" +
      "cStock0\001\022D\n\021SaveOrUpdateStock\022\025.grpcserv" +
      "er.GrpcStock\032\030.grpcserver.GrpcResponse\022A" +
      "\n\014CreateStocks\022\025.grpcserver.GrpcStock\032\030." +
      "grpcserver.GrpcResponse(\001\022D\n\013RemoveStock" +
      "\022\033.google.protobuf.Int64Value\032\030.grpcserv" +
      "er.GrpcResponse\022U\n\021CreateDailyStocks\022$.g" +
      "rpcserver.GrpcDailyHistoricalStock\032\030.grp" +
      "cserver.GrpcResponse(\001\022g\n\027RetrieveDailyB" +
      "yDuration\022$.grpcserver.GrpcStockDuration" +
      "Request\032$.grpcserver.GrpcDailyHistorical" +
      "Stock0\001\022Y\n\027SaveOrUdpdateDailyStock\022$.grp" +
      "cserver.GrpcDailyHistoricalStock\032\030.grpcs" +
      "erver.GrpcResponseB<\n\'com.stabletrader.v" +
      "2.ibagent.grpc.protosB\017GRPCDataServiceP\001" +
      "b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.AnyProto.getDescriptor(),
          com.google.protobuf.TimestampProto.getDescriptor(),
          com.google.protobuf.EmptyProto.getDescriptor(),
          com.google.protobuf.WrappersProto.getDescriptor(),
        });
    internal_static_grpcserver_GrpcResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_grpcserver_GrpcResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcserver_GrpcResponse_descriptor,
        new java.lang.String[] { "Error", "Message", "Data", });
    internal_static_grpcserver_GrpcStockDurationRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_grpcserver_GrpcStockDurationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcserver_GrpcStockDurationRequest_descriptor,
        new java.lang.String[] { "Symbols", "Start", "End", });
    internal_static_grpcserver_GrpcStock_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_grpcserver_GrpcStock_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcserver_GrpcStock_descriptor,
        new java.lang.String[] { "Id", "StockSymbol", });
    internal_static_grpcserver_GrpcDailyHistoricalStock_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_grpcserver_GrpcDailyHistoricalStock_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcserver_GrpcDailyHistoricalStock_descriptor,
        new java.lang.String[] { "Id", "Close", "Open", "High", "Low", "Date", "StockId", "Count", "Volume", "Wap", });
    com.google.protobuf.AnyProto.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
    com.google.protobuf.EmptyProto.getDescriptor();
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
