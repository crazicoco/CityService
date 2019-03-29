package com.zhaoyangyingmu.city.service.impl;

import com.zhaoyangyingmu.city.dao.CityDao;
import com.zhaoyangyingmu.city.entity.City;
import com.zhaoyangyingmu.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityServiceImpl implements CityService {

    @Autowired
    CityDao cityDao;

    @Override
    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

    @Override
    public List<City> getAllCities() {
        return cityDao.getAllCities();
    }

    @Override
    public List<City> searchCitiesByCityName(String city_name) {
        return cityDao.searchCitiesByCityName(city_name);
    }

    @Override
    public void insertCity(int province_id, String city_name, String description) {
        cityDao.insertCity(province_id, city_name, description);
    }
}
