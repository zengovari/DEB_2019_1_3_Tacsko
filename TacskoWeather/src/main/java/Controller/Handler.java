package Controller;

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
            log.info("Mazes list successfully created");
        } else {
            log.error("ERROR while creating the list of cities.");
            return null;
        }

        return cities;
    }

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

    public static ArrayList<String> getCountries(Map<String, ArrayList<String>> cities) {

        return new ArrayList<>(cities.keySet());

    }

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

    public static CurrentWeatherData getCurrentWeatherData (String location){
        return gson.fromJson(readFromAPI(location, false), CurrentWeatherData.class);
    }

    public static ForecastWeatherData getForecastWeatherData (String location) {

        System.out.println(readFromAPI(location, true));

        return gson.fromJson(readFromAPI(location, true), ForecastWeatherData.class);

    }

    public static CurrentWeatherData getCurrentWeatherData (String zip, String country){
        return gson.fromJson(readFromAPI(zip, country, false), CurrentWeatherData.class);
    }

    public static ForecastWeatherData getForecastWeatherData (String zip, String country) {

        return gson.fromJson(readFromAPI(zip, country, true), ForecastWeatherData.class);

    }

}
