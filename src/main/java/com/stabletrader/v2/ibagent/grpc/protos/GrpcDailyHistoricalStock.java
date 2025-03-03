// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package com.stabletrader.v2.ibagent.grpc.protos;

/**
 * Protobuf type {@code grpcserver.GrpcDailyHistoricalStock}
 */
public final class GrpcDailyHistoricalStock extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpcserver.GrpcDailyHistoricalStock)
    GrpcDailyHistoricalStockOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GrpcDailyHistoricalStock.newBuilder() to construct.
  private GrpcDailyHistoricalStock(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GrpcDailyHistoricalStock() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GrpcDailyHistoricalStock();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.stabletrader.v2.ibagent.grpc.protos.GRPCDataService.internal_static_grpcserver_GrpcDailyHistoricalStock_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.stabletrader.v2.ibagent.grpc.protos.GRPCDataService.internal_static_grpcserver_GrpcDailyHistoricalStock_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock.class, com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private long id_ = 0L;
  /**
   * <code>uint64 id = 1;</code>
   * @return The id.
   */
  @java.lang.Override
  public long getId() {
    return id_;
  }

  public static final int CLOSE_FIELD_NUMBER = 2;
  private double close_ = 0D;
  /**
   * <code>double close = 2;</code>
   * @return The close.
   */
  @java.lang.Override
  public double getClose() {
    return close_;
  }

  public static final int OPEN_FIELD_NUMBER = 3;
  private double open_ = 0D;
  /**
   * <code>double open = 3;</code>
   * @return The open.
   */
  @java.lang.Override
  public double getOpen() {
    return open_;
  }

  public static final int HIGH_FIELD_NUMBER = 4;
  private double high_ = 0D;
  /**
   * <code>double high = 4;</code>
   * @return The high.
   */
  @java.lang.Override
  public double getHigh() {
    return high_;
  }

  public static final int LOW_FIELD_NUMBER = 5;
  private double low_ = 0D;
  /**
   * <code>double low = 5;</code>
   * @return The low.
   */
  @java.lang.Override
  public double getLow() {
    return low_;
  }

  public static final int DATE_FIELD_NUMBER = 6;
  private com.google.protobuf.Timestamp date_;
  /**
   * <code>.google.protobuf.Timestamp date = 6;</code>
   * @return Whether the date field is set.
   */
  @java.lang.Override
  public boolean hasDate() {
    return date_ != null;
  }
  /**
   * <code>.google.protobuf.Timestamp date = 6;</code>
   * @return The date.
   */
  @java.lang.Override
  public com.google.protobuf.Timestamp getDate() {
    return date_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : date_;
  }
  /**
   * <code>.google.protobuf.Timestamp date = 6;</code>
   */
  @java.lang.Override
  public com.google.protobuf.TimestampOrBuilder getDateOrBuilder() {
    return date_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : date_;
  }

  public static final int STOCK_ID_FIELD_NUMBER = 7;
  private long stockId_ = 0L;
  /**
   * <code>uint64 stock_id = 7;</code>
   * @return The stockId.
   */
  @java.lang.Override
  public long getStockId() {
    return stockId_;
  }

  public static final int COUNT_FIELD_NUMBER = 8;
  private long count_ = 0L;
  /**
   * <code>uint64 count = 8;</code>
   * @return The count.
   */
  @java.lang.Override
  public long getCount() {
    return count_;
  }

  public static final int VOLUME_FIELD_NUMBER = 9;
  private long volume_ = 0L;
  /**
   * <code>uint64 volume = 9;</code>
   * @return The volume.
   */
  @java.lang.Override
  public long getVolume() {
    return volume_;
  }

  public static final int WAP_FIELD_NUMBER = 10;
  private double wap_ = 0D;
  /**
   * <code>double wap = 10;</code>
   * @return The wap.
   */
  @java.lang.Override
  public double getWap() {
    return wap_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0L) {
      output.writeUInt64(1, id_);
    }
    if (java.lang.Double.doubleToRawLongBits(close_) != 0) {
      output.writeDouble(2, close_);
    }
    if (java.lang.Double.doubleToRawLongBits(open_) != 0) {
      output.writeDouble(3, open_);
    }
    if (java.lang.Double.doubleToRawLongBits(high_) != 0) {
      output.writeDouble(4, high_);
    }
    if (java.lang.Double.doubleToRawLongBits(low_) != 0) {
      output.writeDouble(5, low_);
    }
    if (date_ != null) {
      output.writeMessage(6, getDate());
    }
    if (stockId_ != 0L) {
      output.writeUInt64(7, stockId_);
    }
    if (count_ != 0L) {
      output.writeUInt64(8, count_);
    }
    if (volume_ != 0L) {
      output.writeUInt64(9, volume_);
    }
    if (java.lang.Double.doubleToRawLongBits(wap_) != 0) {
      output.writeDouble(10, wap_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(1, id_);
    }
    if (java.lang.Double.doubleToRawLongBits(close_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, close_);
    }
    if (java.lang.Double.doubleToRawLongBits(open_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(3, open_);
    }
    if (java.lang.Double.doubleToRawLongBits(high_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(4, high_);
    }
    if (java.lang.Double.doubleToRawLongBits(low_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(5, low_);
    }
    if (date_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(6, getDate());
    }
    if (stockId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(7, stockId_);
    }
    if (count_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(8, count_);
    }
    if (volume_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(9, volume_);
    }
    if (java.lang.Double.doubleToRawLongBits(wap_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(10, wap_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock)) {
      return super.equals(obj);
    }
    com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock other = (com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock) obj;

    if (getId()
        != other.getId()) return false;
    if (java.lang.Double.doubleToLongBits(getClose())
        != java.lang.Double.doubleToLongBits(
            other.getClose())) return false;
    if (java.lang.Double.doubleToLongBits(getOpen())
        != java.lang.Double.doubleToLongBits(
            other.getOpen())) return false;
    if (java.lang.Double.doubleToLongBits(getHigh())
        != java.lang.Double.doubleToLongBits(
            other.getHigh())) return false;
    if (java.lang.Double.doubleToLongBits(getLow())
        != java.lang.Double.doubleToLongBits(
            other.getLow())) return false;
    if (hasDate() != other.hasDate()) return false;
    if (hasDate()) {
      if (!getDate()
          .equals(other.getDate())) return false;
    }
    if (getStockId()
        != other.getStockId()) return false;
    if (getCount()
        != other.getCount()) return false;
    if (getVolume()
        != other.getVolume()) return false;
    if (java.lang.Double.doubleToLongBits(getWap())
        != java.lang.Double.doubleToLongBits(
            other.getWap())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getId());
    hash = (37 * hash) + CLOSE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getClose()));
    hash = (37 * hash) + OPEN_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getOpen()));
    hash = (37 * hash) + HIGH_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getHigh()));
    hash = (37 * hash) + LOW_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getLow()));
    if (hasDate()) {
      hash = (37 * hash) + DATE_FIELD_NUMBER;
      hash = (53 * hash) + getDate().hashCode();
    }
    hash = (37 * hash) + STOCK_ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getStockId());
    hash = (37 * hash) + COUNT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCount());
    hash = (37 * hash) + VOLUME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getVolume());
    hash = (37 * hash) + WAP_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getWap()));
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code grpcserver.GrpcDailyHistoricalStock}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpcserver.GrpcDailyHistoricalStock)
      com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStockOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.stabletrader.v2.ibagent.grpc.protos.GRPCDataService.internal_static_grpcserver_GrpcDailyHistoricalStock_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.stabletrader.v2.ibagent.grpc.protos.GRPCDataService.internal_static_grpcserver_GrpcDailyHistoricalStock_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock.class, com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock.Builder.class);
    }

    // Construct using com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      id_ = 0L;
      close_ = 0D;
      open_ = 0D;
      high_ = 0D;
      low_ = 0D;
      date_ = null;
      if (dateBuilder_ != null) {
        dateBuilder_.dispose();
        dateBuilder_ = null;
      }
      stockId_ = 0L;
      count_ = 0L;
      volume_ = 0L;
      wap_ = 0D;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.stabletrader.v2.ibagent.grpc.protos.GRPCDataService.internal_static_grpcserver_GrpcDailyHistoricalStock_descriptor;
    }

    @java.lang.Override
    public com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock getDefaultInstanceForType() {
      return com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock.getDefaultInstance();
    }

    @java.lang.Override
    public com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock build() {
      com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock buildPartial() {
      com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock result = new com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.id_ = id_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.close_ = close_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.open_ = open_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.high_ = high_;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.low_ = low_;
      }
      if (((from_bitField0_ & 0x00000020) != 0)) {
        result.date_ = dateBuilder_ == null
            ? date_
            : dateBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000040) != 0)) {
        result.stockId_ = stockId_;
      }
      if (((from_bitField0_ & 0x00000080) != 0)) {
        result.count_ = count_;
      }
      if (((from_bitField0_ & 0x00000100) != 0)) {
        result.volume_ = volume_;
      }
      if (((from_bitField0_ & 0x00000200) != 0)) {
        result.wap_ = wap_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock) {
        return mergeFrom((com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock other) {
      if (other == com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock.getDefaultInstance()) return this;
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (other.getClose() != 0D) {
        setClose(other.getClose());
      }
      if (other.getOpen() != 0D) {
        setOpen(other.getOpen());
      }
      if (other.getHigh() != 0D) {
        setHigh(other.getHigh());
      }
      if (other.getLow() != 0D) {
        setLow(other.getLow());
      }
      if (other.hasDate()) {
        mergeDate(other.getDate());
      }
      if (other.getStockId() != 0L) {
        setStockId(other.getStockId());
      }
      if (other.getCount() != 0L) {
        setCount(other.getCount());
      }
      if (other.getVolume() != 0L) {
        setVolume(other.getVolume());
      }
      if (other.getWap() != 0D) {
        setWap(other.getWap());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              id_ = input.readUInt64();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 17: {
              close_ = input.readDouble();
              bitField0_ |= 0x00000002;
              break;
            } // case 17
            case 25: {
              open_ = input.readDouble();
              bitField0_ |= 0x00000004;
              break;
            } // case 25
            case 33: {
              high_ = input.readDouble();
              bitField0_ |= 0x00000008;
              break;
            } // case 33
            case 41: {
              low_ = input.readDouble();
              bitField0_ |= 0x00000010;
              break;
            } // case 41
            case 50: {
              input.readMessage(
                  getDateFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000020;
              break;
            } // case 50
            case 56: {
              stockId_ = input.readUInt64();
              bitField0_ |= 0x00000040;
              break;
            } // case 56
            case 64: {
              count_ = input.readUInt64();
              bitField0_ |= 0x00000080;
              break;
            } // case 64
            case 72: {
              volume_ = input.readUInt64();
              bitField0_ |= 0x00000100;
              break;
            } // case 72
            case 81: {
              wap_ = input.readDouble();
              bitField0_ |= 0x00000200;
              break;
            } // case 81
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private long id_ ;
    /**
     * <code>uint64 id = 1;</code>
     * @return The id.
     */
    @java.lang.Override
    public long getId() {
      return id_;
    }
    /**
     * <code>uint64 id = 1;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(long value) {

      id_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      id_ = 0L;
      onChanged();
      return this;
    }

    private double close_ ;
    /**
     * <code>double close = 2;</code>
     * @return The close.
     */
    @java.lang.Override
    public double getClose() {
      return close_;
    }
    /**
     * <code>double close = 2;</code>
     * @param value The close to set.
     * @return This builder for chaining.
     */
    public Builder setClose(double value) {

      close_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>double close = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearClose() {
      bitField0_ = (bitField0_ & ~0x00000002);
      close_ = 0D;
      onChanged();
      return this;
    }

    private double open_ ;
    /**
     * <code>double open = 3;</code>
     * @return The open.
     */
    @java.lang.Override
    public double getOpen() {
      return open_;
    }
    /**
     * <code>double open = 3;</code>
     * @param value The open to set.
     * @return This builder for chaining.
     */
    public Builder setOpen(double value) {

      open_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>double open = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearOpen() {
      bitField0_ = (bitField0_ & ~0x00000004);
      open_ = 0D;
      onChanged();
      return this;
    }

    private double high_ ;
    /**
     * <code>double high = 4;</code>
     * @return The high.
     */
    @java.lang.Override
    public double getHigh() {
      return high_;
    }
    /**
     * <code>double high = 4;</code>
     * @param value The high to set.
     * @return This builder for chaining.
     */
    public Builder setHigh(double value) {

      high_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>double high = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearHigh() {
      bitField0_ = (bitField0_ & ~0x00000008);
      high_ = 0D;
      onChanged();
      return this;
    }

    private double low_ ;
    /**
     * <code>double low = 5;</code>
     * @return The low.
     */
    @java.lang.Override
    public double getLow() {
      return low_;
    }
    /**
     * <code>double low = 5;</code>
     * @param value The low to set.
     * @return This builder for chaining.
     */
    public Builder setLow(double value) {

      low_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>double low = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearLow() {
      bitField0_ = (bitField0_ & ~0x00000010);
      low_ = 0D;
      onChanged();
      return this;
    }

    private com.google.protobuf.Timestamp date_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> dateBuilder_;
    /**
     * <code>.google.protobuf.Timestamp date = 6;</code>
     * @return Whether the date field is set.
     */
    public boolean hasDate() {
      return ((bitField0_ & 0x00000020) != 0);
    }
    /**
     * <code>.google.protobuf.Timestamp date = 6;</code>
     * @return The date.
     */
    public com.google.protobuf.Timestamp getDate() {
      if (dateBuilder_ == null) {
        return date_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : date_;
      } else {
        return dateBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Timestamp date = 6;</code>
     */
    public Builder setDate(com.google.protobuf.Timestamp value) {
      if (dateBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        date_ = value;
      } else {
        dateBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000020;
      onChanged();
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp date = 6;</code>
     */
    public Builder setDate(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (dateBuilder_ == null) {
        date_ = builderForValue.build();
      } else {
        dateBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000020;
      onChanged();
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp date = 6;</code>
     */
    public Builder mergeDate(com.google.protobuf.Timestamp value) {
      if (dateBuilder_ == null) {
        if (((bitField0_ & 0x00000020) != 0) &&
          date_ != null &&
          date_ != com.google.protobuf.Timestamp.getDefaultInstance()) {
          getDateBuilder().mergeFrom(value);
        } else {
          date_ = value;
        }
      } else {
        dateBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000020;
      onChanged();
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp date = 6;</code>
     */
    public Builder clearDate() {
      bitField0_ = (bitField0_ & ~0x00000020);
      date_ = null;
      if (dateBuilder_ != null) {
        dateBuilder_.dispose();
        dateBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp date = 6;</code>
     */
    public com.google.protobuf.Timestamp.Builder getDateBuilder() {
      bitField0_ |= 0x00000020;
      onChanged();
      return getDateFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Timestamp date = 6;</code>
     */
    public com.google.protobuf.TimestampOrBuilder getDateOrBuilder() {
      if (dateBuilder_ != null) {
        return dateBuilder_.getMessageOrBuilder();
      } else {
        return date_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : date_;
      }
    }
    /**
     * <code>.google.protobuf.Timestamp date = 6;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
        getDateFieldBuilder() {
      if (dateBuilder_ == null) {
        dateBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getDate(),
                getParentForChildren(),
                isClean());
        date_ = null;
      }
      return dateBuilder_;
    }

    private long stockId_ ;
    /**
     * <code>uint64 stock_id = 7;</code>
     * @return The stockId.
     */
    @java.lang.Override
    public long getStockId() {
      return stockId_;
    }
    /**
     * <code>uint64 stock_id = 7;</code>
     * @param value The stockId to set.
     * @return This builder for chaining.
     */
    public Builder setStockId(long value) {

      stockId_ = value;
      bitField0_ |= 0x00000040;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 stock_id = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearStockId() {
      bitField0_ = (bitField0_ & ~0x00000040);
      stockId_ = 0L;
      onChanged();
      return this;
    }

    private long count_ ;
    /**
     * <code>uint64 count = 8;</code>
     * @return The count.
     */
    @java.lang.Override
    public long getCount() {
      return count_;
    }
    /**
     * <code>uint64 count = 8;</code>
     * @param value The count to set.
     * @return This builder for chaining.
     */
    public Builder setCount(long value) {

      count_ = value;
      bitField0_ |= 0x00000080;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 count = 8;</code>
     * @return This builder for chaining.
     */
    public Builder clearCount() {
      bitField0_ = (bitField0_ & ~0x00000080);
      count_ = 0L;
      onChanged();
      return this;
    }

    private long volume_ ;
    /**
     * <code>uint64 volume = 9;</code>
     * @return The volume.
     */
    @java.lang.Override
    public long getVolume() {
      return volume_;
    }
    /**
     * <code>uint64 volume = 9;</code>
     * @param value The volume to set.
     * @return This builder for chaining.
     */
    public Builder setVolume(long value) {

      volume_ = value;
      bitField0_ |= 0x00000100;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 volume = 9;</code>
     * @return This builder for chaining.
     */
    public Builder clearVolume() {
      bitField0_ = (bitField0_ & ~0x00000100);
      volume_ = 0L;
      onChanged();
      return this;
    }

    private double wap_ ;
    /**
     * <code>double wap = 10;</code>
     * @return The wap.
     */
    @java.lang.Override
    public double getWap() {
      return wap_;
    }
    /**
     * <code>double wap = 10;</code>
     * @param value The wap to set.
     * @return This builder for chaining.
     */
    public Builder setWap(double value) {

      wap_ = value;
      bitField0_ |= 0x00000200;
      onChanged();
      return this;
    }
    /**
     * <code>double wap = 10;</code>
     * @return This builder for chaining.
     */
    public Builder clearWap() {
      bitField0_ = (bitField0_ & ~0x00000200);
      wap_ = 0D;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:grpcserver.GrpcDailyHistoricalStock)
  }

  // @@protoc_insertion_point(class_scope:grpcserver.GrpcDailyHistoricalStock)
  private static final com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock();
  }

  public static com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GrpcDailyHistoricalStock>
      PARSER = new com.google.protobuf.AbstractParser<GrpcDailyHistoricalStock>() {
    @java.lang.Override
    public GrpcDailyHistoricalStock parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<GrpcDailyHistoricalStock> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GrpcDailyHistoricalStock> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

