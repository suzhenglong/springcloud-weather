package com.suzl.spring.cloud.weather.fegin;

import com.suzl.spring.cloud.weather.entities.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

 /**
  * @Description:Weather Data Client
  * @author: zhenglongsu@163.com
  * @date: 2018.11.22 15:41
  */
@FeignClient("msb-weather-data-eureka")
public interface WeatherDataFeignClient {
	
	@GetMapping("/weather/cityId/{cityId}")
	WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
