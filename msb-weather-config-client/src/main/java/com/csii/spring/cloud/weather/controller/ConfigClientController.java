package com.csii.spring.cloud.weather.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: zhenglongsu@163.com
 * @date: 2018.11.22 18:46
 */
@RestController
public class ConfigClientController {
    @Value("${auther}")
    private String auther;

    @GetMapping("/auther")
    public String hello() {
        return this.auther;
    }
}
