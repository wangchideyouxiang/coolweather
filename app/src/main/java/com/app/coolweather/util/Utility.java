package com.app.coolweather.util;

import android.text.TextUtils;
import android.util.Log;

import com.app.coolweather.model.City;
import com.app.coolweather.model.CoolWeatherDB;
import com.app.coolweather.model.Country;
import com.app.coolweather.model.Province;

/**
 * Created by 王驰 on 2016-11-04.
 */

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public synchronized static boolean handleProvincesResponse(
            CoolWeatherDB coolWeatherDB, String response
    ) {
        if (!TextUtils.isEmpty(response)) {
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0) {
                for (String p : allProvinces) {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    // 将解析出来的数据存储到Province表
                    coolWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB, String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCities = response.split(",");
            for (String c:allCities) {
                String[] array = c.split("\\|");
                City city = new City();
                city.setCityCode(array[0]);
                city.setCityName(array[1]);
                city.setProvinceId(provinceId);
                coolWeatherDB.saveCity(city);
            }
            return true;
        }
        return false;
    }
    /*
    *解析和处理服务器返回的县级数据
     */
    public static boolean handleCountiesResponse(CoolWeatherDB coolWeatherDB,
                                                String response, int cityId)
    {
        String[] allCounties = response.split(",");
        if (allCounties != null && allCounties.length > 0) {
            for (String c:allCounties) {
                String[] array = c.split("\\|");
                Country country = new Country();
                country.setCountyCode(array[0]);
                country.setCountyName(array[1]);
                country.setCityId(cityId);
                //将解析出来的数据存储到Country表中
                coolWeatherDB.saveCountry(country);
            }
            return true;
        }
        return false;
    }
}
