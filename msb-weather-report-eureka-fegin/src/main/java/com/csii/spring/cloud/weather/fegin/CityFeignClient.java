package com.csii.spring.cloud.weather.fegin;


import com.csii.spring.cloud.weather.entities.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

 /**
  * @Description:City Client.
  * @author: zhenglongsu@163.com
  * @date: 2018.11.22 15:48
  */
@FeignClient("msb-weather-city-eureka")
public interface CityFeignClient {
	
	@GetMapping("/cities")
	List<City> listCity();
}
