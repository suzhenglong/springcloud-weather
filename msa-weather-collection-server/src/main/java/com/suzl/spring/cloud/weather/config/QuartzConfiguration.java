package com.suzl.spring.cloud.weather.config;

import com.suzl.spring.cloud.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description:
 * @author: zhenglongsu@163.com
 * @date: 2018.11.20 16:27
 */
@Configuration
public class QuartzConfiguration {

    /**
     * 更新频率
     */
    private static final int TIME = 1800;

    /**
     * JobDetail
     *
     * @return
     */
    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
                .storeDurably().build();
    }

    /**
     * Trigger
     *
     * @return
     */
    @Bean
    public Trigger weatherDataSyncTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(TIME).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail()).withIdentity("weatherDataSyncTrigger").withSchedule(scheduleBuilder).build();
    }

}
