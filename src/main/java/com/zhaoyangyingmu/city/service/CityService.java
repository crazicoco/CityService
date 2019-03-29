package com.zhaoyangyingmu.city.service;

import com.zhaoyangyingmu.city.entity.City;

import java.util.List;

public interface CityService {
    City findCityByName(String cityName);

    List<City> getAllCities();

    List<City> searchCitiesByCityName(String city_name);

    void insertCity(int province_id, String city_name, String description);
}
