package ru.k66.myweb.weather;

/**
 * Created by ikydp on 16.09.2016.
 */
import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;
public class MainTest {
    public static void main(String[] args)

            throws IOException, MalformedURLException, JSONException {
        // declaring object of "OpenWeatherMap" class
        OpenWeatherMap owm = new OpenWeatherMap(OpenWeatherMap.Units.METRIC, OpenWeatherMap.Language.RUSSIAN,"7f1bf29859c024305ecb1d116d9aa443");

        // getting current weather data for the "London" city
        CurrentWeather cwd = owm.currentWeatherByCityName("Екатеринбург" );
DailyForecast dwc = owm.dailyForecastByCityName("Yekaterinburg",(byte)3 );



        // checking data retrieval was successful or not
        if (cwd.isValid()) {
            System.out.println("city  = " + dwc.getForecastCount());

            // checking if city name is available
            if (cwd.hasCityName()) {
                //printing city name from the retrieved data
                System.out.println("City: " + cwd.getCityName());


                //
                System.out.println("date 1 = " +  dwc.getForecastInstance(0).getDateTime());

                System.out.println("date 3 = " +  dwc.getForecastInstance(2).getDateTime());

                System.out.println("weathert 1 = " +  dwc.getForecastInstance(0).getTemperatureInstance().getDayTemperature());

                System.out.println("weathert 3 = " +  dwc.getForecastInstance(2).getTemperatureInstance().getDayTemperature());
                System.out.println("weathert 3 = " +  dwc.getForecastInstance(2).getTemperatureInstance().getMorningTemperature());
            }

            // checking if max. temp. and min. temp. is available
            if (cwd.getMainInstance().hasMaxTemperature() && cwd.getMainInstance().hasMinTemperature()) {
                // printing the max./min. temperature
                System.out.println("Temperature: " + cwd.getMainInstance().getMaxTemperature()
                        + "/" + cwd.getMainInstance().getMinTemperature() + "\'C");
            }

        }
    }
}