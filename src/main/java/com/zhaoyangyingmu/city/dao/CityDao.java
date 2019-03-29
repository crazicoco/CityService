package com.zhaoyangyingmu.city.dao;

import com.zhaoyangyingmu.city.entity.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityDao {
    City findByName(@Param("cityName") String cityName);

    List<City> getAllCities();

    List<City> searchCitiesByCityName(@Param("cityName") String city_name);

    void insertCity(@Param("province_id") int province_id, @Param("city_name") String city_name, @Param("description") String description);
}
