package com.cuaderno.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CuadernoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuadernoServiceApplication.class, args);
	}

}
