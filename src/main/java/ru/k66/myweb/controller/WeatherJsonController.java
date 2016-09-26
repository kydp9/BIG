package ru.k66.myweb.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.k66.myweb.model.Weather;
import ru.k66.myweb.service.impl.WeatherServiceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
public class WeatherJsonController {


    @Autowired
    private WeatherServiceImpl weatherService;


    @RequestMapping("/gsonweather")
    public String setupForm(Map<String,Object> map){
        Gson gson = new Gson();
        Weather weather = new Weather();
        map.put("weather",weather);
List listWeather = weatherService.getAllWeather();
        List<String> gsonWeather = new ArrayList();

        for(int i =0 ; i < listWeather.size() ; i++) {

gsonWeather.add(gson.toJson(listWeather.get(i)));
        }
        map.put("weatherList",gsonWeather);
        return "gsonweather";
    }






}

