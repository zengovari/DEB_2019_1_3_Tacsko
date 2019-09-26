import Model.ForecastWeather.ForecastWeatherData;
import Model.Handler.ForecastWeatherHandler;
import Model.Handler.Handler;
import View.App;

public class Launcher {
    public static void main(String[] args) {
        ForecastWeatherData forecastWeatherData = ForecastWeatherHandler.getForecastWeatherData("Debrecen");


        App.main(args);
    }
}
