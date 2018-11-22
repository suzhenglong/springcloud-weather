package com.csii.spring.cloud.weather.service;

import com.csii.spring.cloud.weather.entities.Forecast;
import com.csii.spring.cloud.weather.entities.Weather;
import com.csii.spring.cloud.weather.entities.WeatherResponse;
import com.csii.spring.cloud.weather.fegin.WeatherDataFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:Weather Report Service
 * @author: zhenglongsu@163.com
 * @date: 2018.11.21 09:39
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataFeignClient weatherDataFeignClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        //改为由天气数据API微服务来提供
        WeatherResponse response = weatherDataFeignClient.getDataByCityId(cityId);
        Weather data = response.getData();
        return data;
    }
}
