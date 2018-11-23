package com.csii.spring.cloud.weather.controller;

import com.csii.spring.cloud.weather.entities.City;
import com.csii.spring.cloud.weather.fegin.CityFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    @HystrixCommand(fallbackMethod = "defaultCities")
    public List<City> listCity() {
        // 通过Feign客户端来查找
        List<City> cities = cityClient.listCity();
        return cities;
    }

    public List<City> defaultCities() {
        List<City> cityList = new ArrayList<>();
        City city = new City();
        city.setCityId("00000000");
        city.setCityName("City Data Server is down");
        cityList.add(city);

        return cityList;
    }
}
