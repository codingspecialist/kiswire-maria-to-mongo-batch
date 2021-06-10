package com.kiswire.migration.domain.maria.fda002;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kiswire.migration.domain.maria.MariaFda;

public interface MariaFda002Repository extends JpaRepository<MariaFda002, Long>{
	List<MariaFda> findByPlcR0001TimestampBetween(Timestamp startTime, Timestamp endTime, Pageable pageable);
	List<MariaFda> findByPlcR0001TimestampBetween(Timestamp startTime, Timestamp endTime);
}
