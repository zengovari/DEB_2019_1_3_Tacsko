package Model.ForecastWeather;

import lombok.Data;

@Data
public class ForecastWeather {

    private int dt;
    private Main main;
    private Weather[] weather;
    private Clouds clouds;
    private Wind wind;
    private Rain rain;
    private Sys sys;
    private String dt_txt;

    public Weather getWeather() {
        return weather[0];
    }

}
