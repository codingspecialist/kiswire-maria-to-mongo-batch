package com.kiswire.migration.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CustomTimeUtils {
	
	public static Timestamp plus9Hour(Timestamp ts) {
		Timestamp rawTime = ts;
		LocalDateTime temp = rawTime.toLocalDateTime().plusHours(9);
		Timestamp encTime = Timestamp.valueOf(temp);
		return encTime;
	}
}
