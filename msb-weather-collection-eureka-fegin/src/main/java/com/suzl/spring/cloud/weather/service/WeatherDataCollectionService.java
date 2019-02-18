package com.suzl.spring.cloud.weather.service;

/**
 * @Description:Weather Data Collection Service.
 * @author: zhenglongsu@163.com
 * @date: 2018.11.21 14:40
 */
public interface WeatherDataCollectionService {

    /**
     * 根据城市ID同步天气
     *
     * @param cityId
     */
    void syncDateByCityId(String cityId);
}
