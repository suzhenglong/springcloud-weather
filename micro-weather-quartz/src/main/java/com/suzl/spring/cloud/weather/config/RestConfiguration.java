package com.suzl.spring.cloud.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:Rest Configuration.
 * @author: zhenglongsu@163.com
 * @date: 2018.11.20 14:17
 */
@Configuration
public class RestConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
