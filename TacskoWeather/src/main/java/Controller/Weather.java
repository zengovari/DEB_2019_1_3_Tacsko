package Controller;

import Model.CurrentWeather.CurrentWeatherData;
import Model.ForecastWeather.ForecastWeatherData;
import Model.Handler.CurrentWeatherHandler;
import Model.Handler.ForecastWeatherHandler;
import Model.Handler.Handler;
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

            CurrentWeatherData currentWeatherData = CurrentWeatherHandler.getCurrentWeatherData(telepulesTextField.getText()); //JELENLEGI IDŐJÁRÁS
            ForecastWeatherData forecastWeather= ForecastWeatherHandler.getForecastWeatherData(telepulesTextField.getText()); //IDŐJÁRÁS ELŐREJELZÉS

            LocalDate date = LocalDate.now();
            day1date.setText(date.toString());
            day2date.setText(date.plusDays(1).toString());
            day3date.setText(date.plusDays(2).toString());
            day4date.setText(date.plusDays(3).toString());
            day5date.setText(date.plusDays(4).toString());

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
                        log.info("ez az negyedik nap homerseklete");
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
            //CurrentWeatherData currentWeatherData = Handler.getCurrentWeatherData(iranyitoszamTextField.getText(), iranyitoszamOrszagTextField.getText());
            //ForecastWeatherData forecastWeatherData = Handler.getForecastWeatherData(iranyitoszamTextField.getText(), iranyitoszamOrszagTextField.getText());

            CurrentWeatherData currentWeatherData = CurrentWeatherHandler.getCurrentWeatherData(iranyitoszamTextField.getText(), iranyitoszamOrszagTextField.getText());
            ForecastWeatherData forecastWeatherData = ForecastWeatherHandler.getForecastWeatherData(iranyitoszamTextField.getText(), iranyitoszamOrszagTextField.getText());
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


