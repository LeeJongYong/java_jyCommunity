package com.example.jycom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  JycomApplication {

	private static final Logger log = LogManager.getLogger(JycomApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JycomApplication.class, args);
		log.debug("로그 찍혀?");
		log.info("info 찍혀?");
	}

}
