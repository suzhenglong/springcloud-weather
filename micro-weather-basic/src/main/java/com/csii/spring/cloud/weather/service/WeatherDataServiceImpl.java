package com.csii.spring.cloud.weather.service;

import java.io.*;

import com.csii.spring.cloud.weather.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.csii.spring.cloud.weather.entities.WeatherResponse;

/**
 * @Description:WeatherDataService 实现
 * @author: zhenglongsu@163.com
 * @date: 2018.11.20 10:51
 */
@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用接口返回的状态值 200表示成功
     */
    private static final int RESPONSE_STATUS = 200;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(String uri) {

        log.info("===============获取数据 ===============");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        String strBody = null;

        if (responseEntity.getStatusCodeValue() == RESPONSE_STATUS) {
            strBody = StringUtil.conventFromGzip(responseEntity.getBody());

        }
        log.info("strBody->{}", strBody);

        try {
            resp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("resp->{}", resp);
        log.info("===============封装数据完毕 ===============");

        return resp;
    }

}
