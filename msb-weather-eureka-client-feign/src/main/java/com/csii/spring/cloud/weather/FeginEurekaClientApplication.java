package com.csii.spring.cloud.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class FeginEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeginEurekaClientApplication.class, args);
	}
}
