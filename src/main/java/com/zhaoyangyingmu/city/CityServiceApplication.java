package com.zhaoyangyingmu.city;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhaoyangyingmu.city.dao")
public class CityServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CityServiceApplication.class, args);
    }
}
