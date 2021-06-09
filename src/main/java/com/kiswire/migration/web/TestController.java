package com.kiswire.migration.web;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiswire.migration.domain.maria.fda001.MariaFda001;
import com.kiswire.migration.domain.maria.fda001.MariaFda001Repository;
import com.kiswire.migration.domain.maria.fda002.MariaFda002Repository;
import com.kiswire.migration.domain.mongo.fda001.MongoFda;
import com.kiswire.migration.domain.mongo.fda001.MongoFdaRepository;
import com.kiswire.migration.util.CustomPickedTime;
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

	@PostMapping("/mongo/fda")
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

	@GetMapping("/maria/fda001/minus/{minusDay}")
	public List<MariaFda001> pickDay(@PathVariable int minusDay) {
		// 날짜 LocalDate.now().minusDays(1) 어제
		LocalDateTime startTime = LocalDateTime.of(LocalDate.now().minusDays(minusDay), LocalTime.of(0, 0, 0));
		LocalDateTime endTime = LocalDateTime.of(LocalDate.now().minusDays(minusDay), LocalTime.of(23, 59, 59));

		Timestamp startTs = Timestamp.valueOf(startTime);
		Timestamp endTs = Timestamp.valueOf(endTime);

		System.out.println("startTime : " + startTime);
		System.out.println("endTime : " + endTime);

		System.out.println("startTs : " + startTs);
		System.out.println("endTs : " + endTs);

		return mariaFda001Repository.mFindByYesterday(startTs, endTs);
	}

	@GetMapping("/maria/fda001/named/minus/{minusDay}")
	public List<MariaFda001> pickDayNamed(@PathVariable int minusDay, @PageableDefault(size = 3) Pageable pageable) {
		// 날짜 LocalDate.now().minusDays(1) 어제
		LocalDateTime startTime = LocalDateTime.of(LocalDate.now().minusDays(minusDay), LocalTime.of(0, 0, 0));
		LocalDateTime endTime = LocalDateTime.of(LocalDate.now().minusDays(minusDay), LocalTime.of(23, 59, 59));
		Timestamp startTs = Timestamp.valueOf(startTime);
		Timestamp endTs = Timestamp.valueOf(endTime);
		return mariaFda001Repository.findByPlcR0001TimestampBetween(startTs, endTs, pageable);
	}

	@GetMapping("/maria/fda001/named/util/minus/{minusDay}")
	public List<MariaFda001> pickDayNamedUtil(@PathVariable int minusDay,
			@PageableDefault(size = 3) Pageable pageable) {
		// 날짜 LocalDate.now().minusDays(1) 어제
		CustomPickedTime ts = CustomPickedTime.getStartEndTs(minusDay);
		return mariaFda001Repository.findByPlcR0001TimestampBetween(ts.getStartTs(), ts.getEndTs(), pageable);
	}
	
@GetMapping("/maria/fda001/count/{minusDay}")
public Integer countFda001MinusDay(@PathVariable int minusDay) {
	CustomPickedTime cpt = CustomPickedTime.getStartEndTs(7);
	return mariaFda001Repository.findByPlcR0001TimestampBetween(cpt.getStartTs(), cpt.getEndTs()).size();
}

@GetMapping("/maria/fda002/count/{minusDay}")
public Integer countFda002MinusDay(@PathVariable int minusDay) {
	CustomPickedTime cpt = CustomPickedTime.getStartEndTs(7);
	return mariaFda002Repository.findByPlcR0001TimestampBetween(cpt.getStartTs(), cpt.getEndTs()).size();
}
}
