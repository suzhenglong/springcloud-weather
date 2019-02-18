package com.suzl.spring.cloud.weather.service;

import java.util.concurrent.TimeUnit;

import com.suzl.spring.cloud.weather.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:Weather Data Collection Service.
 * @author: zhenglongsu@163.com
 * @date: 2018.11.21 14:40
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    /**
     * 1800L  30分钟  此时是为了测试 设为10s
     */
    private static final long TIME_OUT = 1800L;

    /**
     * 调用接口返回的状态值 200表示成功
     */
    private static final int RESPONSE_STATUS = 200;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void syncDateByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    /**
     * 把天气数据放在缓存
     *
     * @param uri
     */
    private void saveWeatherData(String uri) {
        String key = uri;
        String strBody = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        // 调用服务接口来获取
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        if (responseEntity.getStatusCodeValue() == RESPONSE_STATUS) {
            strBody = StringUtil.conventFromGzip(responseEntity.getBody());
        }

        // 数据写入缓存
        ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);

    }
}
