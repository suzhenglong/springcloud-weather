package com.suzl.spring.cloud.weather.service;

import com.suzl.spring.cloud.weather.entities.Weather;
import com.suzl.spring.cloud.weather.entities.WeatherResponse;
import com.suzl.spring.cloud.weather.zuul.ZuulClient;
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
    private ZuulClient zuulClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        //改为由天气数据API微服务来提供
        WeatherResponse response = zuulClient.getDataByCityId(cityId);
        Weather data = response.getData();
        return data;
    }
}
