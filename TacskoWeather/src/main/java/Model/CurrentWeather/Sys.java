package Model.CurrentWeather;

import lombok.Data;

@Data
public class Sys {

    private int type;
    private int id;
    private double message;
    private String country;
    private int sunrise;
    private int sunset;

}
