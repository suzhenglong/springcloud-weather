package com.suzl.spring.cloud.weather.service;

import com.suzl.spring.cloud.weather.entities.City;
import com.suzl.spring.cloud.weather.entities.CityList;
import com.suzl.spring.cloud.weather.util.XmlBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Description:City Data Service
 * @author: zhenglongsu@163.com
 * @date: 2018.11.20 16:56
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() {
        // 读取XML文件
        CityList cityList = null;
        try {
            Resource resource = new ClassPathResource("citylist.xml");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
            StringBuffer stringBuffer = new StringBuffer();
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }

            bufferedReader.close();

            // XML转为Java对象
            cityList = (CityList) XmlBuilder.xmlStrToOject(CityList.class, stringBuffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


        return cityList.getCityList();
    }

}
