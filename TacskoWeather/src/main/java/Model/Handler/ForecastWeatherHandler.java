package Model.Handler;

import Model.ForecastWeather.ForecastWeatherData;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ForecastWeatherHandler {
    private static Gson gson = new Gson();

    public static ForecastWeatherData getForecastWeatherData (String location) {
        log.debug(Handler.readFromAPI(location,true));
        return gson.fromJson(Handler.readFromAPI(location, true), ForecastWeatherData.class);
    }

    public static ForecastWeatherData getForecastWeatherData (String zip, String country) {
        return gson.fromJson(Handler.readFromAPI(zip, country, true), ForecastWeatherData.class);
    }
}
