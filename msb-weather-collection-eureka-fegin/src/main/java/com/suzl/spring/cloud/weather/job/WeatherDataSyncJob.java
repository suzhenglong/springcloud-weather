package com.suzl.spring.cloud.weather.job;

import com.suzl.spring.cloud.weather.entities.City;
import com.suzl.spring.cloud.weather.fegin.CityFeignClient;
import com.suzl.spring.cloud.weather.service.WeatherDataCollectionService;
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
    private WeatherDataCollectionService weatherDataCollectionService;

    @Autowired
    private CityFeignClient cityFeignClient;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("===============同步天气信息开始===============");
        //  改为由城市数据API微服务来提供数据
        List<City> cityList = cityFeignClient.listCity();
        //遍历城市信息ID获取天气
        for (City city : cityList) {
            log.info("同步的城市Id:{},城市名字:{}", city.getCityId(), city.getCityName());
            weatherDataCollectionService.syncDateByCityId(city.getCityId());
        }

        log.info("===============同步天气信息完毕===============");
    }

}
