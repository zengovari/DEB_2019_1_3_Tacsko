package Controller;

import Model.CurrentWeather.CurrentWeatherData;
import Model.ForecastWeather.ForecastWeather;
import Model.ForecastWeather.ForecastWeatherData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import lombok.extern.slf4j.Slf4j;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

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

    private Map<String, ArrayList<String>> citiesByCountry = Handler.createMapOfCities();
    private ArrayList<String> countries = Handler.getCountries(citiesByCountry);
    private ArrayList<String> cities;

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


    public void orszagAction(){

        if (countries.contains(orszagTextField.getText()) && orszagTextField.getLength() > 0) {

            telepulesButton.setDisable(false);
            telepulesTextField.setDisable(false);

            cities = Handler.StringLike(citiesByCountry, orszagTextField.getText(), telepulesTextField.getText());
            TextFields.bindAutoCompletion(telepulesTextField, cities);
        } else {
            log.error("Hibás ország");
        }
    }

    public void telepulesAction(){

        if (cities.contains(telepulesTextField.getText()) && telepulesTextField.getLength() > 0) {
            CurrentWeatherData currentWeatherData = Handler.getCurrentWeatherData(telepulesTextField.getText()); //JELENLEGI IDŐJÁRÁS
            ForecastWeatherData forecastWeather= Handler.getForecastWeatherData(telepulesTextField.getText()); //IDŐJÁRÁS ELŐREJELZÉS

            System.out.println(forecastWeather.getList()[0].getWeather().getMain());
        } else {
            log.error("Hibás település");
        }
    }

    public void iranyitoszamOrszagAction() {

        if (countries.contains(iranyitoszamOrszagTextField.getText()) && iranyitoszamOrszagTextField.getLength() > 0) {
            iranyitoszamButton.setDisable(false);
            iranyitoszamTextField.setDisable(false);
        } else {
            log.error("Hibás ország");
        }
    }
    public void iranyitoszamAction(){
        if (iranyitoszamTextField.getLength() > 0) {
            CurrentWeatherData currentWeatherData = Handler.getCurrentWeatherData(iranyitoszamTextField.getText(), iranyitoszamOrszagTextField.getText());
            ForecastWeatherData forecastWeatherData = Handler.getForecastWeatherData(iranyitoszamTextField.getText(), iranyitoszamOrszagTextField.getText());
            System.out.println(currentWeatherData.getBase());
            System.out.println(forecastWeatherData.getList()[0].getMain().getTemp());
        }

    }

    public void  koordinataAction(){}

    public void  day1click(){}
    public void  day2click(){}
    public void  day3click(){}
    public void  day4click(){}
    public void  day5click(){}
    public void  hour0click(){}
    public void  hour3click(){}
    public void  hour6click(){}
    public void  hour9click(){}
    public void  hour12click(){}
    public void  hour15click(){}
    public void  hour18click(){}
    public void  hour21click(){}



}


