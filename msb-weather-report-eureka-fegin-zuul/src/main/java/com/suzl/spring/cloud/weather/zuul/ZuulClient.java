package com.suzl.spring.cloud.weather.zuul;

import com.suzl.spring.cloud.weather.entities.City;
import com.suzl.spring.cloud.weather.entities.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Description:
 * @author: zhenglongsu@163.com
 * @date: 2018.11.22 16:48
 */
@FeignClient("msb-weather-eureka-client-zuul")
public interface ZuulClient {
    /**
     * 获取城市列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/city/cities")
    List<City> listCity();

    /**
     * 根据城市ID查询天气数据
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
