package Model.ForecastWeather;

public class ForecastWeather {

    private int dt;
    private Main main;
    private Weather[] weather;
    private Clouds clouds;
    private Wind wind;
    private Rain rain;
    private Sys sys;
    private String dt_txt;

    public int getDt() {
        return dt;
    }

    public Main getMain() {
        return main;
    }

    public Weather getWeather() {
        return weather[0];
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public Sys getSys() {
        return sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

}
