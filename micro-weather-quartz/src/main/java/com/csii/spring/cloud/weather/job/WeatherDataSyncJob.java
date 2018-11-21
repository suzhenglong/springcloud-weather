package com.csii.spring.cloud.weather.job;

import com.csii.spring.cloud.weather.entities.City;
import com.csii.spring.cloud.weather.service.CityDataService;
import com.csii.spring.cloud.weather.service.WeatherDataService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @Description:Weather Data Sync Job.
 * @author: zhenglongsu@163.com
 * @date: 2018.11.20 16:25
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private WeatherDataService weatherDataService;
    @Autowired
    private CityDataService cityDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("===============同步天气信息开始===============");
        //获取城市列表
        List<City> cities = null;

        try {
            cities = cityDataService.listCity();
        } catch (Exception e) {
            log.error("Error ", e);
        }

        //遍历城市信息ID获取天气
        for (City city : cities) {
            log.info("同步的城市Id:{},城市名字:{}", city.getCityId(), city.getCityName());
            weatherDataService.syncDateByCityId(city.getCityId());
        }

        log.info("===============同步天气信息完毕===============");
    }
}
