package com.stabletrader.v2.ibagent.grpc;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.google.protobuf.Timestamp;
import com.google.type.Date;
import com.google.type.Money;

public class GrpcUtils {
	protected static Timestamp toGoogleTimestampUTC(final LocalDateTime localDateTime) {
        return Timestamp.newBuilder()
                .setSeconds(localDateTime.toEpochSecond(ZoneOffset.UTC))
                .setNanos(localDateTime.getNano())
                .build();
    }

    protected static LocalDateTime fromGoogleTimestampUTC(final Timestamp googleTimestamp) {
        return Instant.ofEpochSecond(googleTimestamp.getSeconds(), googleTimestamp.getNanos())
                .atOffset(ZoneOffset.UTC)
                .toLocalDateTime();
    }
    
    protected static LocalDate fromGoogleTimestampUTC2(final Timestamp googleTimestamp) {
        return Instant.ofEpochSecond(googleTimestamp.getSeconds(), googleTimestamp.getNanos())
                .atOffset(ZoneOffset.UTC)
                .toLocalDate();
    }

    protected static Date toGoogleDate(final LocalDate localDate) {
        return Date.newBuilder()
                .setYear(localDate.getYear())
                .setMonth(localDate.getMonth().getValue())
                .setDay(localDate.getDayOfMonth())
                .build();
    }
    
    protected static Timestamp toGoogleTimestampUTC2(LocalDate date) {
		LocalDateTime localDateTime = date.atStartOfDay();
		Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
		return Timestamp.newBuilder().setSeconds(instant.getEpochSecond()).setNanos(instant.getNano()).build();
	}

    protected static LocalDate fromGoogleDate(final Date googleDate) {
        return LocalDate.of(googleDate.getYear(), googleDate.getMonth(), googleDate.getDay());
    }

    protected static Money toGoogleMoney(final BigDecimal decimal) {
        return Money.newBuilder()
                .setCurrencyCode("USD")
                .setUnits(decimal.longValue())
                .setNanos(decimal.remainder(BigDecimal.ONE).movePointRight(decimal.scale()).intValue())
                .build();
    }

    protected static BigDecimal fromGoogleMoney(final Money googleMoney) {
        return new BigDecimal(googleMoney.getUnits())
                .add(new BigDecimal(googleMoney.getNanos(), new MathContext(9)));
    }
}
