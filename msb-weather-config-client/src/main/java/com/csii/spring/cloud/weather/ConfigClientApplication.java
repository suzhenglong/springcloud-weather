package com.csii.spring.cloud.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

 /**
  * @Description:
  * @author: zhenglongsu@163.com
  * @date: 2018.11.22 19:50
  */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
}
