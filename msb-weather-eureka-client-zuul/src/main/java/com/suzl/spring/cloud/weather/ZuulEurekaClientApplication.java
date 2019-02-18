package com.suzl.spring.cloud.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
  * @Description:
  * @author: zhenglongsu@163.com
  * @date: 2018.11.22 16:32
  */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulEurekaClientApplication.class, args);
	}
}
