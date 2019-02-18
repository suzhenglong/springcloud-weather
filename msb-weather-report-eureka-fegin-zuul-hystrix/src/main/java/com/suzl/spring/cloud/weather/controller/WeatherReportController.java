package com.suzl.spring.cloud.weather.controller;

import com.suzl.spring.cloud.weather.entities.City;
import com.suzl.spring.cloud.weather.service.WeatherReportService;
import com.suzl.spring.cloud.weather.zuul.ZuulClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Weather Report Controller
 *
 * @Description:
 * @author: zhenglongsu@163.com
 * @date: 2018.11.21 09:42
 */
@RestController
@Slf4j
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private ZuulClient zuulClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) {
        //  改为由城市数据API微服务来提供数据
        List<City> cityList = zuulClient.listCity();

        model.addAttribute("title", "龍的天气预报-->浙江省");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }

}
