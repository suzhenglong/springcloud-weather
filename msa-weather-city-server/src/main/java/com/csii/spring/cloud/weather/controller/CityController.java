package com.csii.spring.cloud.weather.controller;

import com.csii.spring.cloud.weather.entities.City;
import com.csii.spring.cloud.weather.service.CityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

 /**
  * @Description:City Controller
  * @author: zhenglongsu@163.com
  * @date: 2018.11.21 15:53
  */
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping
    public List<City> listCity() throws Exception {
        return cityDataService.listCity();
    }
}
