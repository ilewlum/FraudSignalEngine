package com.MulweliCoding.FraudSignalEngine;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.MulweliCoding.FraudSignalEngine.Model.Transaction;

import com.MulweliCoding.FraudSignalEngine.Repository.TransactionRepository;

@SpringBootApplication
public class FraudSignalEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(FraudSignalEngineApplication.class, args);
	}

	// @Bean
	// CommandLineRunner testDb(TransactionRepository repo) {
	// 	return args -> {
	// 		repo.save(new Transaction(1, 100.0, "2023-10-01T10:00:00", "New York"));
	// 		repo.findAll().forEach(i -> System.out.println(i.getLocation()));
	// 	};
	// }

}
