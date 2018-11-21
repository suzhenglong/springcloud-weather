package com.csii.spring.cloud.weather.service;

import com.csii.spring.cloud.weather.entities.WeatherResponse;

 /**
  * @Description: Weather Data Service.
  * @author: zhenglongsu@163.com
  * @date: 2018.11.20 10:51
  */
public interface WeatherDataService {
    /**
     * 根据城市ID查询天气数据
     *
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);

     /**
      * 根据城市ID来同步天气
      * @param cityId
      */
     void syncDateByCityId(String cityId);
}
