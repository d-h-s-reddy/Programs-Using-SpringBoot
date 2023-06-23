package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.usertable.usertablecontroller")
public class JobseekApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobseekApplication.class, args);
	}

}
