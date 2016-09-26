package ru.k66.myweb.controller;


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
public class WeatherController {


@Autowired
private WeatherServiceImpl weatherService;

   /*
     @Qualifier("weatherdaoimpl")
    @Autowired
    private HumanService humanService;
*/
    @RequestMapping("/weather")
    public String setupForm(Map<String,Object> map){

        Weather weather = new Weather();
        map.put("weather",weather);

        return "weather";
    }




    @RequestMapping (value = "/weather.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Weather weather, BindingResult result, @RequestParam String action, Map<String,Object> map ) {
        Weather newweather = new Weather();

//Weather getweather = weatherService.seatchWeather(weather.getCity());
        List<Weather> weatherList = new ArrayList<>();
  //     weatherList.add(getweather);



        map.put("weather",weather);
//map.put("weatherList",weatherList);
        map.put("weatherList",weatherService.seatchWeather(weather));
        return "weather";
    }

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        //The date format to parse or output your dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //Create a new CustomDateEditor
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        //Register it as custom editor for the Date type
        binder.registerCustomEditor(Date.class, editor);
    }


}
