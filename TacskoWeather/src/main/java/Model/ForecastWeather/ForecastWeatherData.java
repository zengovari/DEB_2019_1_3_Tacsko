package Model.ForecastWeather;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * This class contains all the necessary information regarding the upcoming weather in the next 5 days.
 */
@Data
public class ForecastWeatherData {

    private String cod;
    private double message;
    private int cnt;

    @SerializedName("list")
    private ForecastWeather[] list;
    private City city;

}
