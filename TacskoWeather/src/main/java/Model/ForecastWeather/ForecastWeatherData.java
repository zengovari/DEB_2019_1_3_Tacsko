package Model.ForecastWeather;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ForecastWeatherData {

    private String cod;
    private double message;
    private int cnt;

    @SerializedName("list")
    private ForecastWeather[] list;
    private City city;

}
