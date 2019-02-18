package com.suzl.spring.cloud.weather.controller;

import com.suzl.spring.cloud.weather.entities.City;
import com.suzl.spring.cloud.weather.fegin.CityFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:City Controller
 * @author: zhenglongsu@163.com
 * @date: 2018.11.22 20:01
 */
@RestController
public class CityController {
    @Autowired
    private CityFeignClient cityClient;

    @GetMapping("/cities")
    public List<City> listCity() {
        // 通过Feign客户端来查找
        List<City> cities = cityClient.listCity();
        return cities;
    }
}
