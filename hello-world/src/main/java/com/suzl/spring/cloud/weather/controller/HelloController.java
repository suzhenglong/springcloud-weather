package com.suzl.spring.cloud.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

 /**
  * @Description:
  * @author: zhenglongsu@163.com
  * @date: 2018.11.19 15:46
  */
@RestController
public class HelloController {

	/**
	 * @RequestMapping("/hello")
	 * @return
	 */
	@GetMapping("/hello")
	public String hello() {
		return "Hello World 关宁!!!";
	}
}
