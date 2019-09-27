package Model.ForecastWeather;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Rain {

    @SerializedName("3h")
    private double rain;


}
