package com.suzl.spring.cloud.weather.service;

import com.suzl.spring.cloud.weather.entities.City;

import java.util.List;


/**
 * City Data Service
 */
public interface CityDataService {

    /**
     * 获取City列表
     *
     * @return
     */
    List<City> listCity();
}
