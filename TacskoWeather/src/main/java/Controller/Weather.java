package Controller;

import Model.CurrentWeather.CurrentWeatherData;
import Model.ForecastWeather.ForecastWeatherData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

    @FXML
    private TextField telepulesTextField;

    @FXML
    private Button telepulesButton;

    private Map<String, ArrayList<String>> cities = Handler.createMapOfCities();
    private ArrayList<String> orszagok = Handler.getCountries(cities);
    private ArrayList<String> telepulesek;



    public void orszagAction(){

        if (orszagok.contains(orszagTextField.getText()) && orszagTextField.getLength() > 0) {

            telepulesButton.setDisable(false);
            telepulesTextField.setDisable(false);

            telepulesek = Handler.StringLike(cities, orszagTextField.getText(), telepulesTextField.getText());
            TextFields.bindAutoCompletion(telepulesTextField, telepulesek);
        } else {
            log.error("Hibás ország");
        }
    }


    public void telepulesKeyTyped() {
/*
        ArrayList<String> suggestions = Handler.StringLike(cities, orszagTextField.getText(), telepulesTextField.getText());
        System.out.println(suggestions);
*/

    }

    public void telepulesAction(){

        if (telepulesek.contains(telepulesTextField.getText()) && telepulesTextField.getLength() > 0) {
            CurrentWeatherData currentWeatherData = Handler.getCurrentWeatherData(telepulesTextField.getText()); //JELENLEGI IDŐJÁRÁS
            ForecastWeatherData forecastWeather= Handler.getForecastWeatherData(telepulesTextField.getText()); //IDŐJÁRÁS ELŐREJELZÉS

            System.out.println(forecastWeather.getList()[0].getWeather().getMain());
        } else {
            log.error("Hibás település");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        telepulesButton.setDisable(true);
        telepulesTextField.setDisable(true);

        orszagTextField.textProperty().addListener((observable) -> {});
        TextFields.bindAutoCompletion(orszagTextField, orszagok);

        telepulesTextField.textProperty().addListener((observable -> {}));
    }}


