package Model;

import com.google.gson.annotations.SerializedName;

public class WeatherData {

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

    public Coord getCoord() {
        return coordinate;
    }

    public Weather getWeather() {
        return weather[0];
    }

    public String getBase() {
        return base;
    }

    public Main getTemperature() {
        return temperature;
    }

    public int getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public int getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }

}
