package Model.Handler;

import Model.CurrentWeather.CurrentWeatherData;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import Model.Error.InvalidCoordinatesError;
import Model.Error.InvalidZipCodeError;
import Model.Error.InvalidLocationError;

/**
 * This class handles the current weather data.
 */

@Slf4j
public class CurrentWeatherHandler {
    private static Gson gson = new Gson();

    /**
     * Reads the current weather data, using {@link Handler#readFromAPI(String, boolean)} and returns it as a {@link CurrentWeatherData}.
     * @param location the name of the location from which we want to get the actual weather data.
     * @return the {@link CurrentWeatherData} object that contains all the necessary information.
     */
    public static CurrentWeatherData getCurrentWeatherData (String location){
        try {
            return gson.fromJson(Handler.readFromAPI(location, false), CurrentWeatherData.class);
        } catch (InvalidLocationError invalidLocationError) {
            invalidLocationError.printStackTrace();
            return null;
        }
    }

    /**
     * Reads the current weather data, using {@link Handler#readFromAPI(String, String, boolean)} and returns it as a {@link CurrentWeatherData}.
     * @param zip the zip code of the location from which from we want to get the actual weather data..
     * @param country the country tag of the location which we want to get the weather forecast or actual weather data.(ie. HU, DE).
     * @return the {@link CurrentWeatherData} object that contains all the necessary information.
     */

    public static CurrentWeatherData getCurrentWeatherData (String zip, String country){
        try {
            return gson.fromJson(Handler.readFromAPI(zip, country, false), CurrentWeatherData.class);
        } catch (InvalidZipCodeError invalidZipCodeError) {
            invalidZipCodeError.printStackTrace();
            return null;
        }
    }
    /**
     * Reads the current weather data, using {@link Handler#readFromAPI(double, double, boolean)} and returns it as a {@link CurrentWeatherData}.
     * @param lat the latitude of the location from which we want to get the weather forecast or actual weather data.
     * @param lon the longitude of the location from which we want to get the weather forecast or actual weather data.
     * @return the {@link CurrentWeatherData} object that contains all the necessary information.
     */
    public static CurrentWeatherData getCurrentWeatherData (double lat, double lon){
        try {
            return gson.fromJson(Handler.readFromAPI(lat, lon, false), CurrentWeatherData.class);
        } catch (InvalidCoordinatesError invalidCoordinatesError) {
            invalidCoordinatesError.printStackTrace();
            return null;
        }
    }
}
