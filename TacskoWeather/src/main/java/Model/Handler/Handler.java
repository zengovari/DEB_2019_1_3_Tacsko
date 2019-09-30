package Model.Handler;

import Model.CurrentWeather.City;
import Model.ForecastWeather.ForecastWeather;
import Model.ForecastWeather.ForecastWeatherData;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javafx.scene.image.ImageView;
import lombok.extern.slf4j.Slf4j;
import javafx.scene.image.Image;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Model.Error.InvalidCoordinatesError;
import Model.Error.InvalidLocationError;
import Model.Error.InvalidZipCodeError;

/**
 *  This class interacts with the API and creates the necessary data.
 */

@Slf4j
public class Handler {

    private static final String API_KEY = "5d304de85fb52e5b0e2ab6c556196364";
    private static Gson gson = new Gson();

    /**
     * Gets the weather data in the form of a JSON file from the API and returns it as a string.
     * @param location the name of the location from which we want to get the weather forecast or actual weather data.
     * @param forecast true value gets the forecast, false value gets the weather current weather.
     * @return A Json fle in the form of a String.
     * @throws InvalidLocationError The given location is not allowed.
     */
    public static String readFromAPI(String location, boolean forecast) throws InvalidLocationError {
        StringBuilder apiAnswer = new StringBuilder();
        URL request;

        try {
            if (!forecast) {
                request = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY);
            } else {
                request = new URL("http://api.openweathermap.org/data/2.5/forecast?q=" + location + "&appid=" + API_KEY);
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(request.openStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                apiAnswer.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            throw new InvalidLocationError();
        }
        return apiAnswer.toString();
    }

    /**
     * Gets the weather data in the form of a JSON file from the API and returns it as a string.
     * @param zip the zip code of the location from which we want to get the weather forecast or actual weather data.
     * @param country the country tag of the location from which we want to get the weather forecast or actual weather data.(ie. HU, DE)
     * @param forecast true value gets the forecast, false value gets the weather current weather.
     * @return A JSON fle in the form of a String.
     * @throws InvalidZipCodeError The given zipcode is not allowed.
     */

    public static String readFromAPI(String zip, String country, boolean forecast) throws InvalidZipCodeError {
        StringBuilder apiAnswer = new StringBuilder();
        URL request;

        try {
            if (!forecast) {
                request = new URL("http://api.openweathermap.org/data/2.5/weather?zip=" + zip + "," + country + "&appid=" + API_KEY);
            } else {
                request = new URL("http://api.openweathermap.org/data/2.5/forecast?zip=" + zip + "," + country +  "&appid=" + API_KEY);
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(request.openStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                apiAnswer.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            throw new InvalidZipCodeError();
        }
        return apiAnswer.toString();
    }

    /**
     * Gets the weather data in the form of a JSON file from the API and returns it as a string.
     * @param lat the latitude of the location from which we want to get the weather forecast or actual weather data.
     * @param lon the longitude of the location from which we want to get the weather forecast or actual weather data.(ie. HU, DE)
     * @param forecast true value gets the forecast, false value gets the weather current weather.
     * @return A JSON fle in the form of a String.
     * @throws InvalidCoordinatesError The given coordinates are not allowed.
     */

    public static String readFromAPI(double lat, double lon, boolean forecast) throws InvalidCoordinatesError {
        StringBuilder apiAnswer = new StringBuilder();
        URL request;

        try {
            if (!forecast) {
                request = new URL("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + API_KEY);
            } else {
                request = new URL("http://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lon + "&appid=" + API_KEY);
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(request.openStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                apiAnswer.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            throw new  InvalidCoordinatesError();
        }
        return apiAnswer.toString();
    }

    /**
     * Reads a list of City classes fom a json file and returns it as an array.
     * @param fileName name of the file from which the cities will be red.
     * @return An array of City classes.
     */
    private static City[] readCities(String fileName) {

        InputStream inputStream = Handler.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream != null) {
            log.info("{} successfully read.", fileName);
        } else {
            log.error("{} not found", fileName);
            log.info("Closing program..");
            System.exit(1);
        }

        Reader reader = new InputStreamReader(inputStream);

        JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
        JsonArray jsonArray = jsonObject.getAsJsonArray("Cities");

        City[] cities = gson.fromJson(jsonArray, City[].class);

        if (cities != null) {
            log.info("Cities list successfully created");
        } else {
            log.error("ERROR while creating the list of cities.");
            return null;
        }

        return cities;
    }


    /**
     * Gets the correct icon using {@link #getWeatherConditionIconByDate(ForecastWeatherData, String)} then sets the imageView's image to that .
     * @param forecastWeatherData the data set that contains all the forecast data.
     * @param imageView the imageView where we want to put our icon.
     * @param date the date which from we want to get the icon.
     */
    public static void setImageViewByDate( ForecastWeatherData forecastWeatherData, ImageView imageView, String date) {
        String icon = getWeatherConditionIconByDate(forecastWeatherData, date);

        System.out.println("http://openweathermap.org/img/wn/" + icon + "@2x.png");

        Image image = new Image("http://openweathermap.org/img/wn/" + icon + "@2x.png");
        imageView.setImage(image);
    }

    /**
     * Reads through the forecast data then returns the correct icon according to the date if it's found.
     * @param forecastWeatherData the data set that contains all the forecast data.
     * @param date the date which from we want to get the icon.
     * @return the icon if it's found, otherwise null.
     */
    private static String getWeatherConditionIconByDate (ForecastWeatherData forecastWeatherData, String date) {

        String icon = "";

        for (ForecastWeather forecastWeather: forecastWeatherData.getList()) {
            if (forecastWeather.getDt_txt().equals(date)) {
                icon = forecastWeather.getWeather().getIcon();
            }
        }

        if (!icon.equals("")) return icon;
        else {
            log.error("Nincs erre a dátumra ikon.");
            return null;
        }
    }

    /**
     * Reads through the forecast data then returns the correct description according to the date if it's found.
     * @param forecastWeatherData the data set that contains all the forecast data.
     * @param date the date which from we want to get the icon.
     * @return the description if it's found, otherwise null.
     */
    public static String getDescriptionByDate (ForecastWeatherData forecastWeatherData, String date) {
        String desc = "";
        for (ForecastWeather forecastWeather: forecastWeatherData.getList()) {
            if (forecastWeather.getDt_txt().equals(date)) {
                desc = forecastWeather.getWeather().getDescription();
            }
        }
        if (!desc.equals("")) return desc;
        else {
            log.error("Nincs erre a dátumra ikon.");
            return null;
        }

    }

    /**
     * From an array of City classes it creates a map of country tags as keys and a list of city names as values.
     * @return A map with the keys as country tags with string type(ie. HU, DE) and the values as a list of strings of city names.
     */
    public static Map createMapOfCities() {
        City[] cities = readCities("city.list.json");
        Map<String, ArrayList<String>> citiesMap = new HashMap<>();

        for (City city: cities) {
            if (citiesMap.containsKey(city.getCountry())) {
                citiesMap.get(city.getCountry()).add(city.getName());
            } else {
                citiesMap.put(city.getCountry(), new ArrayList<String>());
            }
        }


        return citiesMap;

    }

}
