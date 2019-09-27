package Model.ForecastWeather;

import lombok.Data;

@Data
public class Main{

    private double temp;
    private double temp_min;
    private double temp_max;
    private double pressure;
    private double sea_level;
    private double grnd_level;
    private int humidity;
    private double temp_kf;

}
