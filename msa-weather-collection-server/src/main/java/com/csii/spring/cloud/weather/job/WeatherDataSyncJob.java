package com.csii.spring.cloud.weather.job;

import com.csii.spring.cloud.weather.entities.City;
import com.csii.spring.cloud.weather.service.WeatherDataCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:Weather Data Sync Job.
 * @author: zhenglongsu@163.com
 * @date: 2018.11.20 16:25
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("===============同步天气信息开始===============");
        // 获取城市ID列表
        // TODO 改为由城市数据API微服务来提供数据
        List<City> cityList = null;


        // TODO 改为由城市数据API微服务提供数据
        cityList = new ArrayList<>();
        City city = new City();
        city.setCityId("101280601");
        city.setCityName("深圳");
        cityList.add(city);


        //遍历城市信息ID获取天气
        for (City c : cityList) {
            log.info("同步的城市Id:{},城市名字:{}", c.getCityId(), c.getCityName());
            weatherDataCollectionService.syncDateByCityId(city.getCityId());
        }

        log.info("===============同步天气信息完毕===============");
    }

}
