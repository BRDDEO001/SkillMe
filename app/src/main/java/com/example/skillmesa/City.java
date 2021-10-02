package com.example.skillmesa;

public class City {

    private String cityID;
    private String city;
    private String province;

    public City() {
    }

    public City(String cityID, String city, String province) {
        this.cityID = cityID;
        this.city = city;
        this.province = province;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
