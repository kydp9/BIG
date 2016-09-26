package ru.k66.myweb.weather;

/**
 * Created by ikydp on 21.09.2016.
 */
import org.json.JSONException;
import ru.k66.myweb.dao.impl.WeatherDaoImpl;
import ru.k66.myweb.model.Weather;

import java.io.IOException;
import java.net.MalformedURLException;
public class Test2 {
    public static void main(String[] args)

            throws IOException, MalformedURLException, JSONException {
        // declaring object of "OpenWeatherMap" class

        WeatherDaoImpl weatherDao = new WeatherDaoImpl();
        Weather weather = weatherDao.getWeather("london");

        System.out.print( weather.getCity());


        }
    }
