package Controller;

import Model.CurrentWeather.CurrentWeatherData;
import Model.ForecastWeather.ForecastWeatherData;
import Model.Handler.CurrentWeatherHandler;
import Model.Handler.ForecastWeatherHandler;
import Model.Handler.Handler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.controlsfx.control.textfield.TextFields;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import java.time.*;
@Slf4j
public class Weather  implements Initializable {


    @FXML
    private TextField orszagTextField;
    public Button orszagButton;
    @FXML
    private TextField telepulesTextField;
    @FXML
    private Button telepulesButton;
    public Label telepulesHibauzenetLabel;

    public TextField iranyitoszamTextField;
    @FXML
    private Button iranyitoszamButton;
    @FXML
    private TextField iranyitoszamOrszagTextField;
    public Button iranyitoszamOrszagButton;
    public Label iranyitoszamHibauzenetLabel;

    public TextField koordinataXLabel;
    public TextField koordinataYLabel;
    public Button koordinataButton;
    public Label koordinataHibauzenetLabel;

    public VBox day1box;
    public Label day1date;
    public ImageView day1img;
    public Label day1max;
    public Label day1min;
    public VBox day2box;
    public Label day2date;
    public ImageView day2img;
    public Label day2max;
    public Label day2min;
    public VBox day3box;
    public Label day3date;
    public ImageView day3img;
    public Label day3max;
    public Label day3min;
    public VBox day4box;
    public Label day4date;
    public ImageView day4img;
    public Label day4max;
    public Label day4min;
    public VBox day5box;
    public Label day5date;
    public ImageView day5img;
    public Label day5max;
    public Label day5min;
    public VBox hour0box;
    public Label hour0;
    public ImageView hour0img;
    public Label hour0temp;
    public VBox hour3box;
    public Label hour3;
    public ImageView hour3img;
    public Label hour3temp;
    public VBox hour6box;
    public Label hour6;
    public ImageView hour6img;
    public Label hour6temp;
    public VBox hour9box;
    public Label hour9;
    public ImageView hour9img;
    public Label hour9temp;
    public VBox hour12box;
    public Label hour12;
    public ImageView hour12img;
    public Label hour12temp;
    public VBox hour15box;
    public Label hour15;
    public ImageView hour15img;
    public Label hour15temp;
    public VBox hour18box;
    public Label hour18;
    public ImageView hour18img;
    public Label hour18temp;
    public VBox hour21box;
    public Label hour21;
    public ImageView hour21img;
    public Label hour21temp;
    public Label hourlyMax;
    public Label hourlyMin;
    public Label hourlyHumidity;
    public Label hourlyclouds;
    public Label hourlyWindSpeed;
    public Label hourlyWindDeg;
    public Label hourlyPressure;

    public String nap = new String();
    private Map<String, ArrayList<String>> citiesByCountry = Handler.createMapOfCities();
    private ArrayList<String> countries = new ArrayList<>(citiesByCountry.keySet());
    private ArrayList<String> cities;
    CurrentWeatherData currentWeatherData = new CurrentWeatherData();
    ForecastWeatherData forecastWeatherData = new ForecastWeatherData();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        telepulesButton.setDisable(true);
        telepulesTextField.setDisable(true);
        iranyitoszamButton.setDisable(true);
        iranyitoszamTextField.setDisable(true);


        orszagTextField.textProperty().addListener((observable) -> {});
        iranyitoszamOrszagTextField.textProperty().addListener((observable) -> {});

        TextFields.bindAutoCompletion(orszagTextField, countries);
        TextFields.bindAutoCompletion(iranyitoszamOrszagTextField, countries);

        telepulesTextField.textProperty().addListener((observable -> {}));


    }

    public void tab1OrszagButtonAction(ActionEvent actionEvent) {
        if (countries.contains(orszagTextField.getText()) && orszagTextField.getLength() > 0) {

            telepulesButton.setDisable(false);
            telepulesTextField.setDisable(false);

            cities = Handler.StringLike(citiesByCountry, orszagTextField.getText(), telepulesTextField.getText());
            TextFields.bindAutoCompletion(telepulesTextField, cities);
        } else {
            log.error("Hibás ország");
        }
    }
    public void tab1TelepulesButtonAction(ActionEvent actionEvent) {
        if (cities.contains(telepulesTextField.getText()) && telepulesTextField.getLength() > 0) {

            currentWeatherData = CurrentWeatherHandler.getCurrentWeatherData(telepulesTextField.getText()); //JELENLEGI IDŐJÁRÁS
            forecastWeatherData = ForecastWeatherHandler.getForecastWeatherData(telepulesTextField.getText()); //IDŐJÁRÁS ELŐREJELZÉS

            weatherLoader(forecastWeatherData);

        }
        else {
            log.error("Hibás település");
        }
    }

    public void tab2OrszagButtonAction(ActionEvent actionEvent) {
        if (countries.contains(iranyitoszamOrszagTextField.getText()) && iranyitoszamOrszagTextField.getLength() > 0) {
            iranyitoszamButton.setDisable(false);
            iranyitoszamTextField.setDisable(false);
        } else {
            log.error("Hibás ország");
        }
    }
    public void tab2IranyitoszamButtonAction(ActionEvent actionEvent) {
        if (iranyitoszamTextField.getLength() > 0) {

            currentWeatherData = CurrentWeatherHandler.getCurrentWeatherData(iranyitoszamTextField.getText(), iranyitoszamOrszagTextField.getText());
            forecastWeatherData = ForecastWeatherHandler.getForecastWeatherData(iranyitoszamTextField.getText(), iranyitoszamOrszagTextField.getText());
            weatherLoader(forecastWeatherData);

        }
    }

    public void tab3KoordinataButtonAction(ActionEvent actionEvent) {
        if (koordinataXLabel.getLength() > 0 && koordinataYLabel.getLength() > 0) {
            try {
                currentWeatherData = CurrentWeatherHandler.getCurrentWeatherData(Double.parseDouble(koordinataXLabel.getText()) , Double.parseDouble(koordinataYLabel.getText()));
                forecastWeatherData = ForecastWeatherHandler.getForecastWeatherData(Double.parseDouble(koordinataXLabel.getText()) , Double.parseDouble(koordinataYLabel.getText()));

                weatherLoader(forecastWeatherData);

            } catch(NumberFormatException e) {
                log.error("Hibás koordináták");
            }
        }
    }

    public String mennyiazido(String ido) {
        if(ido.equals("00:00:00"))
            return "00:00:00";
        if(ido.equals("03:00:00"))
            return "03:00:00";
        if(ido.equals("06:00:00"))
            return "06:00:00";
        if(ido.equals("09:00:00"))
            return "09:00:00";
        if(ido.equals("12:00:00"))
            return "12:00:00";
        if(ido.equals("15:00:00"))
            return "15:00:00";
        if(ido.equals("18:00:00"))
            return "18:00:00";
        if(ido.equals("21:00:00"))
            return "21:00:00";
        return "nincs ilyen idopont";
    }
    public void setHourlyWeather(int which_day) {
        String currentTime;
        for(int i = 0; i < 39; i++) {
            currentTime = forecastWeatherData.getList()[i].getDt_txt();
            String[] preciseDate = currentTime.split(" ");
            if (preciseDate[0].equals(LocalDate.now().plusDays(which_day).toString())) {
                if(mennyiazido(preciseDate[1]).equals("00:00:00"))
                {
                    hour0.setText(preciseDate[1]);
                    hour0temp.setText(String.valueOf(forecastWeatherData.getList()[i].getMain().getTemp()));
                    Handler.setImageViewByDate(forecastWeatherData,hour0img,currentTime);
                }
                if(mennyiazido(preciseDate[1]).equals("03:00:00"))
                {
                    hour3.setText(preciseDate[1]);
                    hour3temp.setText(String.valueOf(forecastWeatherData.getList()[i].getMain().getTemp()));
                    Handler.setImageViewByDate(forecastWeatherData,hour3img,currentTime);
                }
                if(mennyiazido(preciseDate[1]).equals("06:00:00"))
                {
                    hour6.setText(preciseDate[1]);
                    hour6temp.setText(String.valueOf(forecastWeatherData.getList()[i].getMain().getTemp()));
                    Handler.setImageViewByDate(forecastWeatherData,hour6img,currentTime);
                }
                if(mennyiazido(preciseDate[1]).equals("09:00:00"))
                {
                    hour9.setText(preciseDate[1]);
                    hour9temp.setText(String.valueOf(forecastWeatherData.getList()[i].getMain().getTemp()));
                    Handler.setImageViewByDate(forecastWeatherData,hour9img,currentTime);
                }
                if(mennyiazido(preciseDate[1]).equals("12:00:00"))
                {
                    hour12.setText(preciseDate[1]);
                    hour12temp.setText(String.valueOf(forecastWeatherData.getList()[i].getMain().getTemp()));
                    Handler.setImageViewByDate(forecastWeatherData,hour12img,currentTime);
                }
                if(mennyiazido(preciseDate[1]).equals("15:00:00"))
                {
                    hour15.setText(preciseDate[1]);
                    hour15temp.setText(String.valueOf(forecastWeatherData.getList()[i].getMain().getTemp()));
                    Handler.setImageViewByDate(forecastWeatherData,hour15img,currentTime);
                }
                if(mennyiazido(preciseDate[1]).equals("18:00:00"))
                {
                    hour18.setText(preciseDate[1]);
                    hour18temp.setText(String.valueOf(forecastWeatherData.getList()[i].getMain().getTemp()));
                    Handler.setImageViewByDate(forecastWeatherData,hour18img,currentTime);
                }
                if(mennyiazido(preciseDate[1]).equals("21:00:00"))
                {
                    log.info("van 21 ora is");
                    hour21.setText(preciseDate[1]);
                    hour21temp.setText(String.valueOf(forecastWeatherData.getList()[i].getMain().getTemp()));
                    Handler.setImageViewByDate(forecastWeatherData,hour21img,currentTime);
                }
            }
        }

    }
    public void clearHourlyWeather(){
        hour0.setText("");
        hour0temp.setText("");
        hour0img.setImage(null);
        hour3.setText("");
        hour3temp.setText("");
        hour3img.setImage(null);
        hour6.setText("");
        hour6temp.setText("");
        hour6img.setImage(null);
        hour9.setText("");
        hour9temp.setText("");
        hour9img.setImage(null);
        hour12.setText("");
        hour12temp.setText("");
        hour12img.setImage(null);
        hour15.setText("");
        hour15temp.setText("");
        hour15img.setImage(null);
        hour18.setText("");
        hour18temp.setText("");
        hour18img.setImage(null);
        hour21.setText("");
        hour21temp.setText("");
        hour21img.setImage(null);
    }

    public void weatherLoader(ForecastWeatherData forecastWeather) {
        LocalDate date = LocalDate.now();
        day1date.setText(date.toString());
        day2date.setText(date.plusDays(1).toString());
        day3date.setText(date.plusDays(2).toString());
        day4date.setText(date.plusDays(3).toString());
        day5date.setText(date.plusDays(4).toString());

        Handler.setImageViewByDate(forecastWeather, day1img, "2019-09-26 15:00:00");

        String currentTime = forecastWeather.getList()[0].getDt_txt();

        log.info("most a currentime ennyi" + currentTime);
        String[] previoustime = currentTime.split(" ");
        double maxTemperature = -273;
        double minTemperature = 1000;

        log.info("belepunk a for ciklusba");
        for(int i = 0; i < 39; i++)
        {
            currentTime = forecastWeather.getList()[i].getDt_txt();
            String[] temporaryTime = currentTime.split(" ");
            if(! temporaryTime[0].equals(previoustime[0])) {
                log.info("A temporaryTime nem ugyanazz mint a previousTime");

                if(previoustime[0].equals(LocalDate.now().toString()))
                {
                    log.info("ez az elso nap homerseklete");
                    System.out.println("a max ertek jelenleg" + String.valueOf(maxTemperature));
                    day1max.setText(Double.toString(maxTemperature));
                    day1min.setText(Double.toString(minTemperature));
                }

                if(temporaryTime[0].equals(LocalDate.now().plusDays(1).toString()))
                {
                    log.info("ez az masodik nap homerseklete");
                    day2max.setText(Double.toString(maxTemperature));
                    day2min.setText(Double.toString(minTemperature));
                }

                if(temporaryTime[0].equals(LocalDate.now().plusDays(2).toString()))
                {
                    log.info("ez az harmadik nap homerseklete");
                    day3max.setText(Double.toString(maxTemperature));
                    day3min.setText(Double.toString(minTemperature));
                }

                if(temporaryTime[0].equals(LocalDate.now().plusDays(3).toString()))
                {
                    log.info("ez az neNumberFormatException:gyedik nap homerseklete");
                    day4max.setText(Double.toString(maxTemperature));
                    day4min.setText(Double.toString(minTemperature));
                }

                if(temporaryTime[0].equals(LocalDate.now().plusDays(4).toString()))
                {
                    log.info("ez az otodik nap homerseklete");
                    day5max.setText(Double.toString(maxTemperature));
                    day5min.setText(Double.toString(minTemperature));
                }

                maxTemperature = -273;
                minTemperature = 1000;
                log.info("a previous time mielott elore vinnenk" + previoustime[0]);
                previoustime[0] = temporaryTime[0];
                log.info("a previous timeot elore visszuk 1 nappal "+ previoustime[0]);
            }
            else {
                log.info("a ket nap egyforma");
                if(minTemperature > forecastWeather.getList()[i].getMain().getTemp_min())
                {
                    log.info("talaltunk kisebb homersekletet");
                    minTemperature =  forecastWeather.getList()[i].getMain().getTemp_min();
                }

                if(maxTemperature < forecastWeather.getList()[i].getMain().getTemp_max())
                {
                    log.info("talaltunk nagyobb homersekletet");
                    maxTemperature =  forecastWeather.getList()[i].getMain().getTemp_max();
                }
            }

        }

}
    public void  day1click(){
        clearHourlyWeather();
        setHourlyWeather(0);
        nap = LocalDate.now().toString();
    }
    public void  day2click(){
        clearHourlyWeather();
        setHourlyWeather(1);
        nap = LocalDate.now().plusDays(1).toString();
    }
    public void  day3click(){
        clearHourlyWeather();
        setHourlyWeather(2);
        nap = LocalDate.now().plusDays(2).toString();
    }
    public void  day4click(){
        clearHourlyWeather();
        setHourlyWeather(3);
        nap = LocalDate.now().plusDays(3).toString();
    }
    public void  day5click() {
        clearHourlyWeather();
        setHourlyWeather(4);
        nap = LocalDate.now().plusDays(4).toString();
    }

    public void hourClear(){
        hourlyWindSpeed.setText("");
        hourlyWindDeg.setText("");
        hourlyPressure.setText("");
        hourlyMin.setText("");
        hourlyMax.setText("");
        hourlyHumidity.setText("");
        hourlyclouds.setText("");
    }
    public void setDetailedHourlyWeather(String currentHour) {
        hourClear();
        for(int i = 0; i < 39; i++) {
            if(forecastWeatherData.getList()[i].getDt_txt().equals(currentHour)) {
                log.info("talaltunk valamit");
                hourlyclouds.setText(Double.toString(forecastWeatherData.getList()[i].getClouds().getAll()));
                hourlyHumidity.setText(Integer.toString(forecastWeatherData.getList()[i].getMain().getHumidity()));
                hourlyMax.setText(Double.toString(forecastWeatherData.getList()[i].getMain().getTemp_max()));
                hourlyMin.setText(Double.toString(forecastWeatherData.getList()[i].getMain().getTemp_min()));
                hourlyPressure.setText(Double.toString(forecastWeatherData.getList()[i].getMain().getPressure()));
                hourlyWindDeg.setText(Double.toString(forecastWeatherData.getList()[i].getWind().getDeg()));
                hourlyWindSpeed.setText(Double.toString(forecastWeatherData.getList()[i].getWind().getSpeed()));
            }
        }

    }

    public void  hour0click(){
        String currentHour = nap + " 00:00:00";
        setDetailedHourlyWeather(currentHour);
    }
    public void  hour3click(){
        String currentHour = nap + " 03:00:00";
        setDetailedHourlyWeather(currentHour);

    }
    public void  hour6click(){
        String currentHour = nap + " 06:00:00";
        setDetailedHourlyWeather(currentHour);

    }
    public void  hour9click(){
        String currentHour = nap + " 09:00:00";
        setDetailedHourlyWeather(currentHour);

    }
    public void  hour12click(){
        String currentHour = nap + " 12:00:00";
        setDetailedHourlyWeather(currentHour);

    }
    public void  hour15click(){
        String currentHour = nap + " 15:00:00";
        setDetailedHourlyWeather(currentHour);

    }
    public void  hour18click(){
        String currentHour = nap + " 18:00:00";
        setDetailedHourlyWeather(currentHour);

    }
    public void  hour21click(){
        String currentHour = nap + " 21:00:00";
        System.out.println(currentHour);
        setDetailedHourlyWeather(currentHour);
    }

}


