package com.suzl.spring.cloud.weather.entities;

import java.io.Serializable;

/**
 * @Description:Weather 整个消息的返回对象
 * {"data"......,"status":1000,"desc":"OK"}
 * @author: zhenglongsu@163.com
 * @date: 2018.11.20 10:52
 */
public class WeatherResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private Weather data;
    private Integer status;
    private String desc;

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "data=" + data +
                ", status=" + status +
                ", desc='" + desc + '\'' +
                '}';
    }
}
