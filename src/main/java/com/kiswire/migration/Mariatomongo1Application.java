package com.kiswire.migration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Mariatomongo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Mariatomongo1Application.class, args);
	}

}
