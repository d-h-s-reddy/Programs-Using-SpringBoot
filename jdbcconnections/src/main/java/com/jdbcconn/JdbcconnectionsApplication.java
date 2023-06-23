package com.jdbcconn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import com.jdbcconn.operations.JdbcOperationController;

@SpringBootApplication
@ComponentScan(basePackageClasses = JdbcOperationController.class)
public class JdbcconnectionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcconnectionsApplication.class, args);
	}

}
