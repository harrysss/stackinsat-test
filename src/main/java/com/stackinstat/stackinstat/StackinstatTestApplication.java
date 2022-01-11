package com.stackinstat.stackinstat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class StackinstatTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackinstatTestApplication.class, args);
	}

}
