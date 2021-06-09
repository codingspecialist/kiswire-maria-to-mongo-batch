package com.kiswire.migration.handler;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(CustomException.class)
	public void customException(Exception e) {
		// 예외 로그 남기기 (추후 MariaDB로 변경해서 남기기)
		String exceptionTime = LocalDateTime.now().toString();
		System.out.println(exceptionTime+" -> 예외 발생 : "+e.getMessage());
	}
}

