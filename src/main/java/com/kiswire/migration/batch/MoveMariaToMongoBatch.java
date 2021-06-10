package com.kiswire.migration.batch;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kiswire.migration.domain.maria.MariaFda;
import com.kiswire.migration.domain.maria.fda001.MariaFda001;
import com.kiswire.migration.domain.maria.fda001.MariaFda001Repository;
import com.kiswire.migration.domain.maria.fda002.MariaFda002;
import com.kiswire.migration.domain.maria.fda002.MariaFda002Repository;
import com.kiswire.migration.domain.mongo.MongoFda;
import com.kiswire.migration.domain.mongo.MongoFdaRepository;
import com.kiswire.migration.handler.CustomException;
import com.kiswire.migration.util.CustomConvert;
import com.kiswire.migration.util.CustomPickedTime;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MoveMariaToMongoBatch {

	private final MongoFdaRepository mongoFdaRepo;

	private final MariaFda001Repository f1Repo;
	private final MariaFda002Repository f2Repo;

	// 초 분 시 일 월 주
	// @Scheduled(cron = "0 30 00 * * *", zone = "Asia/Seoul")
	public void mariaToMongoStartTest() {

		System.out.println("mariaToMongoStartTest 실행");
		// 1. Maria 7일전 날짜 기계 데이터 가져오기
		CustomPickedTime cpt = CustomPickedTime.getStartEndTs(7);
		List<MariaFda> mariaFs1 = f1Repo.findByPlcR0001TimestampBetween(cpt.getStartTs(), cpt.getEndTs(),
				PageRequest.of(1, 3));
		List<MariaFda> mariaFs2 = f2Repo.findByPlcR0001TimestampBetween(cpt.getStartTs(), cpt.getEndTs(),
				PageRequest.of(1, 3));
		System.out.println(mariaFs1);
		System.out.println(mariaFs2);

		// 2. group(1,2)과 name(fda001, fda002) 추가하기
		List<MongoFda> mf1 = CustomConvert.mariaToMongoObject(mariaFs1, "fds001", "1");
		List<MongoFda> mf2 = CustomConvert.mariaToMongoObject(mariaFs2, "fds002", "2");

		// 3. mongoFdaRepo 컬렉션에 전부 밀어넣기 addAll() 사용
		List<MongoFda> mongoFs = new ArrayList<>();
		mongoFs.addAll(mf1);
		mongoFs.addAll(mf2);

		mongoFdaRepo.saveAll(mongoFs);

	}

	@Scheduled(cron = "0 4 10 * * *", zone = "Asia/Seoul")
	public void mariaToMongoStart() {

		try {
			System.out.println(LocalDateTime.now()+" -> mariaToMongoStart 실행 ===================================");
			// 1. Maria 7일전 날짜 기계 데이터 가져오기
			CustomPickedTime cpt = CustomPickedTime.getStartEndTs(7);
			List<MariaFda> mariaFs1 = f1Repo.findByPlcR0001TimestampBetween(cpt.getStartTs(), cpt.getEndTs());
			List<MariaFda> mariaFs2 = f2Repo.findByPlcR0001TimestampBetween(cpt.getStartTs(), cpt.getEndTs());

			// 2. group(1,2)과 name(fda001, fda002) 추가하기
			List<MongoFda> mf1 = CustomConvert.mariaToMongoObject(mariaFs1, "fds001", "1");
			List<MongoFda> mf2 = CustomConvert.mariaToMongoObject(mariaFs2, "fds002", "2");

			// 3. mongoFdaRepo 컬렉션에 전부 밀어넣기 addAll() 사용
			List<MongoFda> mongoFs = new ArrayList<>();
			mongoFs.addAll(mf1);
			mongoFs.addAll(mf2);

			mongoFdaRepo.saveAll(mongoFs);
			
			System.out.println(LocalDateTime.now()+" -> mariaToMongoStart 종료 ===================================");
		} catch (Exception e) {
			// 4. 오류는 handler 쪽으로 가져가서 DB에 로그 남기기
			throw new CustomException("마이그레이션 오류 : " + e.getMessage());
		}

	}
}
