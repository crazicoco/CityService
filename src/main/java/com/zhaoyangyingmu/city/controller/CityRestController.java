package com.zhaoyangyingmu.city.controller;

import com.zhaoyangyingmu.city.entity.City;
import com.zhaoyangyingmu.city.service.CityService;
import com.zhaoyangyingmu.city.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Controller
public class CityRestController {
    @Autowired
    private CityService cityService;

//    @RequestMapping(value="/api/city", method=RequestMethod.GET)
//    public City findOneCity(@RequestParam(value="cityName", required=false, defaultValue = "龙岩市") String cityName) {
//        cityName.trim();
//        return cityService.findCityByName(cityName);
//    }
    @RequestMapping(value={"/index", "/"})
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("message", "Type in info to add city!");
        return "add";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addCity(@RequestParam(name = "province_id" , required = true) int province_id,
                          @RequestParam(name="city_name", required = true)String city_name,
                          @RequestParam(name = "description", required = true) String description, Model model) {
        cityService.insertCity(province_id, city_name, description);
        model.addAttribute("message", "Successfully add one more city!");
        return "add";
    }

    @RequestMapping(value="/modify")
    public String modify(Model model) {
        return "modify";
    }

    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String search(Model model) {
        List<City> cityList = cityService.getAllCities();
        model.addAttribute("cityList", cityList);
        List<Field> fields = Arrays.asList(City.class.getDeclaredFields());
        model.addAttribute("fields", fields);
        return "search";
    }

    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String searchByInfo(@RequestParam(name="city_name", required = false, defaultValue = "none") String city_name, Model model) {
        if (city_name.equals("none")) {
            return search(model);
        }
        List<City> cityList = cityService.searchCitiesByCityName(city_name);
        model.addAttribute("cityList", cityList);
        List<Field> fields = Arrays.asList(City.class.getDeclaredFields());
        model.addAttribute("fields", fields);
        return "search";
    }

    @RequestMapping(value="/delete")
    public String delete(Model model) {
        return "delete";
    }
}
