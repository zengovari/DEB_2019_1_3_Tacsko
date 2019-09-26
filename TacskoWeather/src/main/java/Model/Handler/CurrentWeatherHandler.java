package Model.Handler;

import Model.CurrentWeather.CurrentWeatherData;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CurrentWeatherHandler {
    private static Gson gson = new Gson();

    public static CurrentWeatherData getCurrentWeatherData (String location){
        log.debug(Handler.readFromAPI(location,false));
        return gson.fromJson(Handler.readFromAPI(location, false), CurrentWeatherData.class);
    }

    public static CurrentWeatherData getCurrentWeatherData (String zip, String country){
        return gson.fromJson(Handler.readFromAPI(zip, country, false), CurrentWeatherData.class);
    }

    public static CurrentWeatherData getCurrentWeatherData (double lat, double lon){
        return gson.fromJson(Handler.readFromAPI(lat, lon, false), CurrentWeatherData.class);
    }
}
