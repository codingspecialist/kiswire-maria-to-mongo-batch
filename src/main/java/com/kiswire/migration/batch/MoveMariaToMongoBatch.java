package com.kiswire.migration.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kiswire.migration.domain.maria.fda001.MariaFda001Repository;
import com.kiswire.migration.domain.maria.fda002.MariaFda002Repository;
import com.kiswire.migration.domain.mongo.fda001.MongoFdaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MoveMariaToMongoBatch {
	
	private final MongoFdaRepository mongoFdaRepo;
	
	private final MariaFda001Repository f1Repo;
	private final MariaFda002Repository f2Repo;
	
	// 초 분 시 일 월 주
	@Scheduled(cron = "0 40 22 * * *", zone = "Asia/Seoul")
	public void mariaToMongoStart() {
		// 1. Maria 어제 날짜 기계 데이터 가져오기
		
		// 2. 가져온 모든 데이터에 group(1,2)과 name(fda001, fda002) 추가하기
		
		// 3. mongoFdaRepo 컬렉션에 전부 밀어넣기
		
		// 4. 오류는 handler 쪽으로 가져가서 DB에 로그 남기기
	}
}
