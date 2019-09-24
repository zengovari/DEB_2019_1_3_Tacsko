package View;

import Controller.Handler;
import Model.WeatherData;

public class App {

    public static void main(String[] args) {
        String apiAnswer = Handler.readFromAPI("Debrecen");
        System.out.println(apiAnswer);

        WeatherData weatherData = Handler.ConvertToData(apiAnswer);

        System.out.println(weatherData.getSys().getSunrise());





    }
}
