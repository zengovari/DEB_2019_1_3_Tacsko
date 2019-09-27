package Model.CurrentWeather;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CurrentWeatherData {

    private Coord coordinate;
    private Weather[] weather;
    private String base;

    @SerializedName("main")
    private Main temperature;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private int dt;
    private Sys sys;
    private int id;
    private String name;
    private int cod;


    public Weather getWeather() {
        return weather[0];
    }



}
