package com.kiswire.migration.domain.maria.fda001;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MariaFda001Repository extends JpaRepository<MariaFda001, Long>{
	
	@Query(value = "SELECT * FROM fda001 WHERE FDA001_PLC_R0001_TIMESTAMP BETWEEN :startTime AND :endTime limit 3", nativeQuery = true)
	List<MariaFda001> mFindByYesterday(Timestamp startTime, Timestamp endTime);
	
	List<MariaFda001> findByPlcR0001TimestampBetween(Timestamp startTime, Timestamp endTime, Pageable pageable);
}
