package ru.k66.myweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.k66.myweb.dao.impl.WeatherDaoImpl;
import ru.k66.myweb.model.Weather;

import java.util.List;

/**
 * Created by ikydp on 20.09.2016.
 */
@Service
public class WeatherServiceImpl {



        @Autowired
        private WeatherDaoImpl weatherDao;



        @Transactional
        public List getWeather() {
            return null;
        }

        @Transactional
        public Weather seatchWeather (String weather) {
            return weatherDao.getWeather(weather);
        }

    @Transactional
    public List seatchWeather(Weather weather) {
        return weatherDao.seatchWeather(weather);
    }


    @Transactional
    public List getAllWeather() {
        return weatherDao.getAllWeather();
    }
    }

