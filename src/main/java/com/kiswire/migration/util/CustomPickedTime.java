package com.kiswire.migration.util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

@Data
public class CustomPickedTime {
	private Timestamp startTs;
	private Timestamp endTs;
	
	public static CustomPickedTime getStartEndTs(int minusDay) {
		LocalDateTime startTime = LocalDateTime.of(LocalDate.now().minusDays(minusDay), LocalTime.of(0, 0, 0));
		LocalDateTime endTime = LocalDateTime.of(LocalDate.now().minusDays(minusDay), LocalTime.of(23, 59, 59));
		
		CustomPickedTime c = new CustomPickedTime();
		c.startTs = Timestamp.valueOf(startTime);
		c.endTs = Timestamp.valueOf(endTime);
		
		return c;
	}
}
