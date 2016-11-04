package com.app.coolweather.model;

/**
 * Created by 王驰 on 2016-11-04.
 */

public class Country {
    private int id;
    private String countyName;
    private String countyCode;
    private int cityId;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCountyName() {
        return countyName;
    }
    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
    public String getCountyCode() {
        return countyCode;
    }
    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }
    public int getCityId() {
        return cityId;
    }
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
