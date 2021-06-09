package com.kiswire.migration.web;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiswire.migration.domain.maria.fda001.MariaFda001;
import com.kiswire.migration.domain.maria.fda001.MariaFda001Repository;
import com.kiswire.migration.domain.maria.fda002.MariaFda002Repository;
import com.kiswire.migration.domain.mongo.fda001.MongoFda;
import com.kiswire.migration.domain.mongo.fda001.MongoFdaRepository;
import com.kiswire.migration.util.CustomTimeUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestController {

	private final MariaFda001Repository mariaFda001Repository;
	private final MariaFda002Repository mariaFda002Repository;
	private final MongoFdaRepository mongoFdaRepository;

	@GetMapping("/maria/fda001")
	public Long countFda001() {
		return mariaFda001Repository.count();
	}

	@GetMapping("/maria/fda002")
	public Long countFda002() {
		return mariaFda002Repository.count();
	}

	@PostMapping("/mongo/fda001")
	public MongoFda saveOne() {
		MongoFda mongoFda = MongoFda.builder().id(1L).build();
		return mongoFdaRepository.save(mongoFda);
	}

	@PostMapping("/time/fda001")
	public MongoFda time() {
		MariaFda001 ma = mariaFda001Repository.findById(1817308L).get();
		MongoFda mongoFda = MongoFda.builder().id(ma.getId()).plcR0001Timestamp(ma.getPlcR0001Timestamp()).build();
		return mongoFdaRepository.save(mongoFda);
	}

	@PostMapping("/time/plus/fda001")
	public MongoFda timePlus9() {
		MariaFda001 ma = mariaFda001Repository.findById(1817308L).get();

		// 시간 더하기
		Timestamp rawTime = ma.getPlcR0001Timestamp();
		LocalDateTime temp = rawTime.toLocalDateTime().plusHours(9);
		Timestamp encTime = Timestamp.valueOf(temp);
		ma.setPlcR0001Timestamp(encTime);

		MongoFda mongoFda = MongoFda.builder().id(ma.getId()).plcR0001Timestamp(ma.getPlcR0001Timestamp()).build();
		return mongoFdaRepository.save(mongoFda);
	}

	@PostMapping("/time/plus/util/fda001")
	public MongoFda timePlus9Util() {
		MariaFda001 ma = mariaFda001Repository.findById(1817308L).get();

		// 시간 더하기
		ma.setPlcR0001Timestamp(CustomTimeUtils.plus9Hour(ma.getPlcR0001Timestamp()));

		MongoFda mongoFda001 = MongoFda.builder().id(ma.getId()).plcR0001Timestamp(ma.getPlcR0001Timestamp()).build();
		return mongoFdaRepository.save(mongoFda001);
	}
}
