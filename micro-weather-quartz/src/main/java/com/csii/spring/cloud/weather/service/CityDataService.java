package com.csii.spring.cloud.weather.service;

import com.csii.spring.cloud.weather.entities.City;

import java.util.List;


/**
 * City Data Service
 */
public interface CityDataService {

    /**
     * 获取City列表
     *
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
