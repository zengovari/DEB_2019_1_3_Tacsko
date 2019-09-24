package Controller;

import Model.Weather;
import Model.WeatherData;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URL;

@Slf4j
public class Handler {

    private static final String API_KEY = "5d304de85fb52e5b0e2ab6c556196364";

    public static String readFromAPI(String location) {
        StringBuilder apiAnswer = new StringBuilder();
        URL request;

        try {
            request = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY);
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

    public static WeatherData ConvertToData (String jsonString){

        Gson gson = new Gson();


        return gson.fromJson(jsonString, WeatherData.class);

    }
}
