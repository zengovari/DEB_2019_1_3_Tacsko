package Model.Handler;

import Model.ForecastWeather.ForecastWeatherData;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import Model.Error.InvalidCoordinatesError;
import Model.Error.InvalidZipCodeError;
import Model.Error.InvalidLocationError;

/**
 * This class handles the forecast weather data.
 */

@Slf4j
public class ForecastWeatherHandler {
    private static Gson gson = new Gson();

    /**
     * Reads the current weather data, using {@link Handler#readFromAPI(String, boolean)}.
     * @param location the name of the location from which we want to get the weather forecast.
     * @return the {@link ForecastWeatherData} object that contains all the necessary information
     */
    public static ForecastWeatherData getForecastWeatherData (String location) {
        try {
            return gson.fromJson(Handler.readFromAPI(location, true), ForecastWeatherData.class);
        } catch (InvalidLocationError invalidLocationError) {
            invalidLocationError.printStackTrace();
            return null;
        }
    }

    /**
     * Reads the current weather data, using {@link Handler#readFromAPI(String, String, boolean)} and returns it as a {@link ForecastWeatherData}.
     * @param zip the zip code of the location from which from we want to get the weather forecast.
     * @param country the country tag of the location which we want to get the weather forecast.
     * @return the {@link ForecastWeatherData} object that contains all the necessary information.
     */
    public static ForecastWeatherData getForecastWeatherData (String zip, String country) {
        try {
            return gson.fromJson(Handler.readFromAPI(zip, country, true), ForecastWeatherData.class);
        } catch (InvalidZipCodeError invalidZipCodeError) {
            invalidZipCodeError.printStackTrace();
            return null;
        }
    }

    /**
     * Reads the current weather data, using {@link Handler#readFromAPI(double, double, boolean)} and returns it as a {@link ForecastWeatherData}.
     * @param lat the latitude of the location from which we want to get the weather forecast.
     * @param lon the longitude of the location from which we want to get the weather forecast.
     * @return the {@link ForecastWeatherData} object that contains all the necessary information.
     */
    public static ForecastWeatherData getForecastWeatherData (double lat, double lon) {
        try {
            return gson.fromJson(Handler.readFromAPI(lat, lon, true), ForecastWeatherData.class);
        } catch (InvalidCoordinatesError invalidCoordinatesError) {
            invalidCoordinatesError.printStackTrace();
            return null;
        }
    }



}
