package com.suzl.spring.cloud.weather.service;

import com.suzl.spring.cloud.weather.entities.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;

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
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 1800L  30分钟  此时是为了测试 设为10s
     */
    private static final long TIME_OUT = 1800L;

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
        String strBody = null;
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        // 先查缓存
        if (stringRedisTemplate.hasKey(uri)) {
            log.info("===============缓存中获取数据 ===============");
            strBody = ops.get(uri);
        } else {
            //缓存中无 则调用服务接口
            log.info("===============Redis don't has data ===============");
            // 缓存中没有 抛出异常
            throw new RuntimeException("Don't has data");
        }
        try {
            resp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            log.error("Error->{}", e);
        }

        log.info("resp->{}", resp);
        log.info("===============封装数据完毕 ===============");

        return resp;
    }

}
