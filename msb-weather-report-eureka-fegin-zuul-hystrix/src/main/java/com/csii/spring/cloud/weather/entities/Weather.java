package com.csii.spring.cloud.weather.entities;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:天气信息类 {"data":{"yesterday":{"date":"19日星期一","high":"高温 24℃","fx":"无持续风向","low":"低温 20℃","fl":"<![CDATA[<3级]]>","type":"阵雨"},"city":"深圳","aqi":"53","forecast":[{"date":"20日星期二","high":"高温 25℃","fengli":"<![CDATA[<3级]]>","low":"低温 19℃","fengxiang":"无持续风向","type":"多云"},{"date":"21日星期三","high":"高温 26℃","fengli":"<![CDATA[<3级]]>","low":"低温 16℃","fengxiang":"无持续风向","type":"小雨"},{"date":"22日星期四","high":"高温 20℃","fengli":"<![CDATA[3-4级]]>","low":"低温 15℃","fengxiang":"北风","type":"小雨"},{"date":"23日星期五","high":"高温 23℃","fengli":"<![CDATA[<3级]]>","low":"低温 18℃","fengxiang":"无持续风向","type":"多云"},{"date":"24日星期六","high":"高温 24℃","fengli":"<![CDATA[<3级]]>","low":"低温 17℃","fengxiang":"无持续风向","type":"多云"}],"ganmao":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。","wendu":"22"},"status":1000,"desc":"OK"}
 * @author: zhenglongsu@163.com
 * @date: 2018.11.20 10:52
 */
public class Weather implements Serializable {

    private static final long serialVersionUID = 1L;

    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private Yeaterday yesterday;
    private List<Forecast> forecast;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public Yeaterday getYesterday() {
        return yesterday;
    }

    public void setYesterday(Yeaterday yesterday) {
        this.yesterday = yesterday;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", aqi='" + aqi + '\'' +
                ", ganmao='" + ganmao + '\'' +
                ", wendu='" + wendu + '\'' +
                ", yesterday=" + yesterday +
                ", forecast=" + forecast +
                '}';
    }
}
