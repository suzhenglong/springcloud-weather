package com.suzl.spring.cloud.weather.service;

import com.suzl.spring.cloud.weather.entities.Weather;
import com.suzl.spring.cloud.weather.entities.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:Weather Report Service
 * @author: zhenglongsu@163.com
 * @date: 2018.11.21 09:39
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse response = weatherDataService.getDataByCityId(cityId);
        return response.getData();
    }
}
