package View;

import Controller.Handler;
import Model.City;
import Model.WeatherData;

import java.util.Map;

public class App {

    public static void main(String[] args) {
        String apiAnswer = Handler.readFromAPI("Debrecen");
        System.out.println(apiAnswer);

        WeatherData weatherData = Handler.ConvertToData(apiAnswer);

        System.out.println(weatherData.getSys().getSunrise());

        City[] cities = Handler.readCities("city.list.json");
        System.out.println(cities[0]);

        System.out.println(cities[0].getCountry());

        Map citiesMap = Handler.createMapOfCities();

        citiesMap.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
