package Model.Handler;

import Model.CurrentWeather.City;
import Model.CurrentWeather.CurrentWeatherData;
import Model.ForecastWeather.ForecastWeatherData;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Handler {

    private static final String API_KEY = "5d304de85fb52e5b0e2ab6c556196364";
    private static Gson gson = new Gson();

    /**
     * Gets the weather data in the form of a Jason file from the API and returns it as a string.
     * @param location the name of the location from which we want to get the weather forecast or actual weather data.
     * @param forecast true value gets the current weather, false value gets the weather forecast.
     * @return A Json fle in the form of a String.
     */
    public static String readFromAPI(String location, boolean forecast) {
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
            e.printStackTrace();
        }
        return apiAnswer.toString();
    }

    /**
     * Gets the weather data in the form of a Jason file from the API and returns it as a string.
     * @param zip the zip code of the location from which we want to get the weather forecast or actual weather data.
     * @param country the country tag of the location from which we want to get the weather forecast or actual weather data.(ie. HU, DE)
     * @param forecast true value gets the current weather, false value gets the weather forecast.
     * @return A Json fle in the form of a String.
     */
    public static String readFromAPI(String zip, String country, boolean forecast) {
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
            e.printStackTrace();
        }
        return apiAnswer.toString();
    }

    /**
     * Reads a list of City classes fom a json file and returns it as an array.
     * @param fileName name of the file from which the cities will be red.
     * @return An array of City classes.
     */
    public static City[] readCities(String fileName) {

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

    /**
     * Returns a list of cities of a certain tag.
     * @param cities A map with the keys as country tags with string type(ie. HU, DE) and the values as a list of strings of city names.
     * @return A list of cities corresponding to a certain tag.
     */
    public static ArrayList<String> getCountries(Map<String, ArrayList<String>> cities) {
        return new ArrayList<>(cities.keySet());
    }

    /**
     * Returns a list of city names which are suggested to complete the string.
     * @param cities A list of city names from which we can select the ones we need.
     * @param country The tag of the country from which we want to choose city names.
     * @param string A string for which we want to get suggestions to complete.
     * @return Returns a list of city names.
     */
    public static ArrayList<String> StringLike(Map<String, ArrayList<String>> cities ,String country, String string) {
        ArrayList<String> possibilities = cities.get(country);
        ArrayList<String> suggestions = new ArrayList<>();
        int stringLength = string.length();

        String substring;
        for (String city: possibilities) {
            if (city.length() > string.length() && city != null) {
                substring = city.substring(0, stringLength);
                if (string.toLowerCase().equals(substring.toLowerCase())) {
                    suggestions.add(city);
                }
            }
        }
        return suggestions;
    }



}
