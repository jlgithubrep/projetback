package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages="com.example.demo.controller")
@ComponentScan(basePackages="com.exeample.demo.security")
@EnableJpaRepositories("com.example.demo.dao")
@SpringBootApplication
public class RestBootSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestBootSpringProjectApplication.class, args);
	}
}
