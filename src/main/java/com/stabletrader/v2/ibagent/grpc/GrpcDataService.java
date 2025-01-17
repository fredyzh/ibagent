package com.stabletrader.v2.ibagent.grpc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.net.ssl.SSLException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.protobuf.Empty;
import com.stabletrader.v2.ibagent.data.HistoicalStockBean;
import com.stabletrader.v2.ibagent.data.StockBean;
import com.stabletrader.v2.ibagent.grpc.protos.GrpcDailyHistoricalStock;
import com.stabletrader.v2.ibagent.grpc.protos.GrpcResponse;
import com.stabletrader.v2.ibagent.grpc.protos.GrpcStock;
import com.stabletrader.v2.ibagent.grpc.protos.StockServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.Status;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;

@Service
public class GrpcDataService {
	private static final String LOCALHOST_CERTIFICATE = "-----BEGIN CERTIFICATE-----\r\n"
			+ "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\r\n"
			+ "-----END CERTIFICATE-----";

	private Collection<X509Certificate> certificates;

	private Logger logger = LogManager.getLogger();

	public List<StockBean> getStockList(String baseurl, String port) throws IOException, CertificateException {
		List<StockBean> stockBeans = new ArrayList<>();

		if (certificates == null) {
			certificates = getCerts();
		}

		ManagedChannel channel = getGrpcChannel(baseurl, port);

		GrpcDataServiceClient grpcClt = new GrpcDataServiceClient(channel);

		try {
			StockServiceGrpc.StockServiceBlockingStub stub = grpcClt.getSvcBlockingStub();
			Empty empty = Empty.getDefaultInstance();
			java.util.Iterator<GrpcStock> stockIter = stub.getStocks(empty);

			while (stockIter.hasNext()) {
				GrpcStock grpcStock = stockIter.next();
				StockBean bean = new StockBean();
				bean.setId((int) grpcStock.getId());
				bean.setStockSymbol(grpcStock.getStockSymbol());
				stockBeans.add(bean);
			}
		} finally {
			channel.shutdown();
		}

		return stockBeans;
	}

	private ManagedChannel getGrpcChannel(String baseurl, String port) throws SSLException {
		ManagedChannel channel = NettyChannelBuilder.forAddress(baseurl, Integer.valueOf(port))
				.usePlaintext().build();
		return channel;
	}

	public void saveHistoricalBean(String baseurl, String port, List<HistoicalStockBean> beanList)
			throws CertificateException, IOException {
		if (certificates == null) {
			certificates = getCerts();
		}

		ManagedChannel channel = getGrpcChannel(baseurl, port);

		GrpcDataServiceClient grpcClt = new GrpcDataServiceClient(channel);

		StockServiceGrpc.StockServiceStub stub = grpcClt.getSvcStub();

		final CountDownLatch finishLatch = new CountDownLatch(1);
		AtomicBoolean isError=new AtomicBoolean(false);

		StreamObserver<GrpcResponse> responseObserver = new StreamObserver<GrpcResponse>() {

			@Override
			public void onNext(GrpcResponse value) {
				logger.log(Level.DEBUG, () -> "Response: " + value.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				Status status = Status.fromThrowable(t);
				logger.log(Level.DEBUG, () -> "save status: " + status);
				isError.getAndSet(true);
				finishLatch.countDown();
			}

			@Override
			public void onCompleted() {
				logger.log(Level.DEBUG, () -> "Finished RecordRoute");
				finishLatch.countDown();
			}

		};
		StreamObserver<GrpcDailyHistoricalStock> requestObserver = stub.createDailyStocks(responseObserver);
		try {
			beanList.stream().forEach(b -> {
				requestObserver.onNext(getGrcpDialyBean(b));
				if (finishLatch.getCount() == 0) {
					return;
				}
			});
			requestObserver.onCompleted();
		} catch (RuntimeException e) {
			requestObserver.onError(e);
			throw e;
		}

		try {
			finishLatch.await(5, TimeUnit.SECONDS);
			
			logger.log(Level.DEBUG, () -> "Finished");
			
			if (isError.compareAndSet(true, false)) {
				throw new RuntimeException("failed retrieved history data.");
			}
		} catch (InterruptedException e) {
		} finally {
			channel.shutdown();
		}
	}

	private Collection<X509Certificate> getCerts() throws CertificateException, IOException {

		try (final InputStream inputStream = new ByteArrayInputStream(
				LOCALHOST_CERTIFICATE.getBytes(StandardCharsets.UTF_8))) {
			// noinspection unchecked
			certificates = (Collection<X509Certificate>) CertificateFactory.getInstance("X.509")
					.generateCertificates(inputStream);
		}

		return certificates;
	}

	private GrpcDailyHistoricalStock getGrcpDialyBean(HistoicalStockBean bean) {
		return GrpcDailyHistoricalStock.newBuilder().setClose(bean.getClose()).setStockId(bean.getStockId())
				.setHigh(bean.getHigh()).setCount(bean.getCount()).setOpen(bean.getOpen()).setLow(bean.getLow())
				.setVolume(bean.getVolume()).setWap(bean.getWap()).setDate(GrpcUtils.toGoogleTimestampUTC2(bean.getDate())).build();
	}

//	private Timestamp getTimestamp(LocalDate date) {
//		LocalDateTime localDateTime = date.atStartOfDay();
//		Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
//		return Timestamp.newBuilder().setSeconds(instant.getEpochSecond()).setNanos(instant.getNano()).build();
//	}
}
