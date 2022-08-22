package com.celean.spring21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Spring21Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring21Application.class, args);
	}

}
