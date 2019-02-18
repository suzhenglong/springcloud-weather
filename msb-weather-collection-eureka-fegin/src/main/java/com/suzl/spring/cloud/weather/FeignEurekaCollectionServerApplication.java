package com.suzl.spring.cloud.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
  * @Description:
  * @author: zhenglongsu@163.com
  * @date: 2018.11.22 14:48
  */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignEurekaCollectionServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignEurekaCollectionServerApplication.class, args);
    }
}
