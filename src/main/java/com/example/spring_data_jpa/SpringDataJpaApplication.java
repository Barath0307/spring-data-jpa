package com.example.spring_data_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		System.out.println("starting...");
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
