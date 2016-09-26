package ru.k66.myweb.dao.impl;

import org.hibernate.SessionFactory;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.k66.myweb.model.Weather;

import ru.k66.myweb.weather.DailyForecast;
import ru.k66.myweb.weather.OpenWeatherMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ikydp on 19.09.2016.
 */
@Transactional
@Repository
public class WeatherDaoImpl {


         @Autowired
        private SessionFactory session;


    public void add(Weather weather) {


        session.getCurrentSession().save(weather);
    }

    public Weather getWeather(String city) {

        OpenWeatherMap owm = new OpenWeatherMap(OpenWeatherMap.Units.METRIC, OpenWeatherMap.Language.RUSSIAN,"7f1bf29859c024305ecb1d116d9aa443");

        // getting current weather data for the "London" city
Weather weather = new Weather();
        if(session==null || session.getCurrentSession().get(Weather.class,city)==null ) {




        try {
            weather = new Weather();
            DailyForecast dwc = owm.dailyForecastByCityName(city,(byte)3 );
            weather.setCity(dwc.getCityInstance().getCityName());
            weather.setDate(dwc.getForecastInstance(0).getDateTime());
            weather.setwDay1Day((int) dwc.getForecastInstance(0).getTemperatureInstance().getDayTemperature());
            weather.setwDay1Evng((int) dwc.getForecastInstance(0).getTemperatureInstance().getEveningTemperature());
            weather.setwDay2Day((int) dwc.getForecastInstance(1).getTemperatureInstance().getDayTemperature());
            weather.setwDay2Evng((int) dwc.getForecastInstance(1).getTemperatureInstance().getEveningTemperature());
            weather.setwDay3Day((int) dwc.getForecastInstance(2).getTemperatureInstance().getDayTemperature());
            weather.setwDay3Evng((int) dwc.getForecastInstance(2).getTemperatureInstance().getEveningTemperature());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        }

        return weather;
    }


    public List seatchWeather(Weather weather) {



        List list = new ArrayList();
        if (weather.getCity()!= null){

            list =  session.getCurrentSession(). createQuery("from Weather where  concat(city,date,wDay1Day,wDay1Evng,wDay2Day,wDay2Evng,wDay3Day,wDay3Evng) like '%" +
                  weather.getCity().toLowerCase() +
                    "%'" ).list();
            if(list.size()>0) {

                Weather oldweather = (Weather) list.get(0);
                Date wDate = nullTime(oldweather.getDate());
                Date currDate = nullTime(new Date());
                if (wDate.equals(currDate)) {
                    return list;
                }
            }
        }
        list = new ArrayList();
        session.getCurrentSession().flush();
        session.getCurrentSession().clear();


            try {
                OpenWeatherMap owm = new OpenWeatherMap(OpenWeatherMap.Units.METRIC, OpenWeatherMap.Language.RUSSIAN,"7f1bf29859c024305ecb1d116d9aa443");

                DailyForecast dwc = owm.dailyForecastByCityName(weather.getCity(),(byte)3 );
                weather = new Weather();
                if (dwc.isValid()) {
                    weather.setCity(dwc.getCityInstance().getCityName());


                    Date someDate =nullTime( dwc.getForecastInstance(0).getDateTime());


                    weather.setDate(someDate);
                    weather.setwDay1Day((int) dwc.getForecastInstance(0).getTemperatureInstance().getDayTemperature());
                    weather.setwDay1Evng((int) dwc.getForecastInstance(0).getTemperatureInstance().getEveningTemperature());
                    weather.setwDay2Day((int) dwc.getForecastInstance(1).getTemperatureInstance().getDayTemperature());
                    weather.setwDay2Evng((int) dwc.getForecastInstance(1).getTemperatureInstance().getEveningTemperature());
                    weather.setwDay3Day((int) dwc.getForecastInstance(2).getTemperatureInstance().getDayTemperature());
                    weather.setwDay3Evng((int) dwc.getForecastInstance(2).getTemperatureInstance().getEveningTemperature());
                }

                list.add(weather);


            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        if (weather.getCity()!= null) {
System.out.println("getcity = " + weather.getCity());

                System.out.println("Update ");
                session.getCurrentSession().saveOrUpdate(weather);


        }
        return list;
    }
private static Date nullTime(Date date){
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    Date newDate = cal.getTime();
    return newDate;
}

    public List getAllWeather() {
        return session.getCurrentSession().createQuery("from Weather").list();
    }


}
