package com.suzl.spring.cloud.weather.zuul;

import com.suzl.spring.cloud.weather.entities.City;
import com.suzl.spring.cloud.weather.entities.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: zhenglongsu@163.com
 * @date: 2018.11.23 10:16
 */
@Component
public class ZuulClientFallback implements ZuulClient{
    @Override
    public List<City> listCity() {
        List<City> cityList = null;
        cityList = new ArrayList<>();

        City city = new City();
        city.setCityId("101280601");
        city.setCityName("深圳");
        cityList.add(city);

        city = new City();
        city.setCityId("101280301");
        city.setCityName("惠州");
        cityList.add(city);

        return cityList;
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return null;
    }
}
