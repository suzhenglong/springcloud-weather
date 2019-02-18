package com.suzl.spring.cloud.weather.service;


import com.suzl.spring.cloud.weather.entities.Weather;

 /**
  * @Description:Weather Report Service
  * @author: zhenglongsu@163.com
  * @date: 2018.11.21 09:38
  */
public interface WeatherReportService {

	/**
	 * 根据城市ID查询天气信息
	 * @param cityId
	 * @return
	 */
	Weather getDataByCityId(String cityId);
}
