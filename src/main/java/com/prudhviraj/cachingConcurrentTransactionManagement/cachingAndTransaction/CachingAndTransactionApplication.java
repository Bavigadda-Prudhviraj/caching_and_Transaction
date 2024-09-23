package com.prudhviraj.cachingConcurrentTransactionManagement.cachingAndTransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class CachingAndTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingAndTransactionApplication.class, args);
	}

}
