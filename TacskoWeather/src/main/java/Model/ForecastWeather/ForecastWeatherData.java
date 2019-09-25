package Model.ForecastWeather;

import com.google.gson.annotations.SerializedName;

public class ForecastWeatherData {

    private String cod;
    private double message;
    private int cnt;

    @SerializedName("list")
    private ForecastWeather[] list;
    private City city;

    public String getCod() {
        return cod;
    }

    public double getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public ForecastWeather[] getList() {
        return list;
    }

    public City getCity() {
        return city;
    }

}
