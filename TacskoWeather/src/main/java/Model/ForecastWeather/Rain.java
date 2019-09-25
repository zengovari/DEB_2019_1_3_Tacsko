package Model.ForecastWeather;

import com.google.gson.annotations.SerializedName;

public class Rain {

    @SerializedName("3h")
    private double rain;


    public double getRain() {
        return rain;
    }

}
