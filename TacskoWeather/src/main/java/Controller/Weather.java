package Controller;

import Model.CurrentWeather.CurrentWeatherData;
import Model.ForecastWeather.ForecastWeatherData;
import Model.Handler.CurrentWeatherHandler;
import Model.Handler.ForecastWeatherHandler;
import Model.Handler.Handler;
import Model.Handler.ImageHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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

    /**
     * This class interacts with the GUI, it is a bridge between the {@link Model} package and the GUI.
     */
    public AnchorPane hourlyPane;
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
    public Label hourlyClouds;
    public Label hourlyWindSpeed;
    public Label hourlyWindDeg;
    public Label hourlyPressure;

    private String nap = "";
    private Map citiesByCountry = Handler.createMapOfCities();
    private ArrayList countries = new ArrayList<>(citiesByCountry.keySet());
    private ArrayList<String> cities;
    private CurrentWeatherData currentWeatherData = new CurrentWeatherData();
    private ForecastWeatherData forecastWeatherData = new ForecastWeatherData();

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

        orszagTextField.setText("HU");
        tab1OrszagButtonAction();
        telepulesTextField.setText("Debrecen");
        tab1TelepulesButtonAction();
        day1click();

    }

    /**
     * Enables the use of a button, a text field and the text fields auto completion if its criteria ar met, also clears the error message. Otherwise it displays an error message.
     */
    public void tab1OrszagButtonAction() {
        if (countries.contains(orszagTextField.getText()) && orszagTextField.getLength() > 0) {


            telepulesButton.setDisable(false);
            telepulesTextField.setDisable(false);

            cities = (ArrayList<String>) citiesByCountry.get(orszagTextField.getText());

            TextFields.bindAutoCompletion(telepulesTextField, cities);
            telepulesHibauzenetLabel.setText("");
        } else {
            log.error("Hibás ország");
            telepulesHibauzenetLabel.setText("Hibás Ország!");
        }
    }

    /**
     * loads the weather forecast and displays it on the screen if its criteria are met, also clears the error message. Otherwise it displays an error message.
     */
    public void tab1TelepulesButtonAction() {
        if (cities.contains(telepulesTextField.getText()) && telepulesTextField.getLength() > 0) {

            currentWeatherData = CurrentWeatherHandler.getCurrentWeatherData(telepulesTextField.getText()); //JELENLEGI IDŐJÁRÁS
            forecastWeatherData = ForecastWeatherHandler.getForecastWeatherData(telepulesTextField.getText()); //IDŐJÁRÁS ELŐREJELZÉS

            weatherLoader(forecastWeatherData);
            telepulesHibauzenetLabel.setText("");
        }
        else {
            log.error("Hibás település");
            telepulesHibauzenetLabel.setText("Hibás Település!");
        }
    }

    /**
     * Enables the use of a button and text field if its criteria ar met, also clears the error message. Otherwise it displays an error message.
     */
    public void tab2OrszagButtonAction() {
        if (countries.contains(iranyitoszamOrszagTextField.getText()) && iranyitoszamOrszagTextField.getLength() > 0) {
            iranyitoszamButton.setDisable(false);
            iranyitoszamTextField.setDisable(false);
            iranyitoszamHibauzenetLabel.setText("");
        } else {
            log.error("Hibás ország");
            iranyitoszamHibauzenetLabel.setText("Hibás Ország!");
        }
    }

    /**
     * loads the weather forecast and displays it on the screen if its criteria are met.
     */
    public void tab2IranyitoszamButtonAction() {
        if (iranyitoszamTextField.getLength() > 0) {

            currentWeatherData = CurrentWeatherHandler.getCurrentWeatherData(iranyitoszamTextField.getText(), iranyitoszamOrszagTextField.getText());
            forecastWeatherData = ForecastWeatherHandler.getForecastWeatherData(iranyitoszamTextField.getText(), iranyitoszamOrszagTextField.getText());
            weatherLoader(forecastWeatherData);

        }
    }

    /**
     * loads the weather forecast and displays it on the screen if its criteria are met, also clears the error message. Otherwise it displays an error message.
     */
    public void tab3KoordinataButtonAction() {
        if (koordinataXLabel.getLength() > 0 && koordinataYLabel.getLength() > 0) {
            try {
                currentWeatherData = CurrentWeatherHandler.getCurrentWeatherData(Double.parseDouble(koordinataXLabel.getText()) , Double.parseDouble(koordinataYLabel.getText()));
                forecastWeatherData = ForecastWeatherHandler.getForecastWeatherData(Double.parseDouble(koordinataXLabel.getText()) , Double.parseDouble(koordinataYLabel.getText()));

                weatherLoader(forecastWeatherData);
                koordinataHibauzenetLabel.setText("");

            } catch(NumberFormatException e) {
                log.error("Hibás koordináták");
                koordinataHibauzenetLabel.setText("Hibás koordináták!");
            }
        }
    }

    /**
     * Loads the data regarding the upcoming five days of weather into the Graphical User Interface.
     * @param forecastWeather {@link ForecastWeatherData} Object that contains all the necessary information.
     */
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
        double maxCelsius = maxTemperature - 273.15;
        double minCelsius = minTemperature - 273.15;

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
                    day1max.setText(String.format("%.1f",maxTemperature) + "K  " + String.format("%.1f", maxCelsius) + "℃");
                    day1min.setText(String.format("%.1f",minTemperature) + "K  " + String.format("%.1f", minCelsius) + "℃");
                }

                if(temporaryTime[0].equals(LocalDate.now().plusDays(1).toString()))
                {
                    log.info("ez az masodik nap homerseklete");
                    day2max.setText(String.format("%.1f",maxTemperature) + "K  " + String.format("%.1f", maxCelsius) + "℃");
                    day2min.setText(String.format("%.1f",minTemperature) + "K  " + String.format("%.1f", minCelsius) + "℃");
                }

                if(temporaryTime[0].equals(LocalDate.now().plusDays(2).toString()))
                {
                    log.info("ez az harmadik nap homerseklete");
                    day3max.setText(String.format("%.1f",maxTemperature) + "K  " + String.format("%.1f", maxCelsius) + "℃");
                    day3min.setText(String.format("%.1f",minTemperature) + "K  " + String.format("%.1f", minCelsius) + "℃");
                }

                if(temporaryTime[0].equals(LocalDate.now().plusDays(3).toString()))
                {
                    log.info("ez az neNumberFormatException:gyedik nap homerseklete");
                    day4max.setText(String.format("%.1f",maxTemperature) + "K  " + String.format("%.1f", maxCelsius) + "℃");
                    day4min.setText(String.format("%.1f",minTemperature) + "K  " + String.format("%.1f", minCelsius) + "℃");
                }

                if(temporaryTime[0].equals(LocalDate.now().plusDays(4).toString()))
                {
                    log.info("ez az otodik nap homerseklete");
                    day5max.setText(String.format("%.1f",maxTemperature) + "K  " + String.format("%.1f", maxCelsius) + "℃");
                    day5min.setText(String.format("%.1f",minTemperature) + "K  " + String.format("%.1f", minCelsius) + "℃");
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
                    minCelsius = minTemperature - 273.15;
                }

                if(maxTemperature < forecastWeather.getList()[i].getMain().getTemp_max())
                {
                    log.info("talaltunk nagyobb homersekletet");
                    maxTemperature =  forecastWeather.getList()[i].getMain().getTemp_max();
                    maxCelsius = maxTemperature - 273.15;
                }
            }

        }

    }

    /**
     * Sets the color of the chosen VBox by css code.
     * @param whitchDay Integer that tells the function which VBoxes color needs to be set.
     */
    public void setDayColor(int whitchDay){
        String style = "-fx-background-color: rgba(255, 255, 255, 0.5);";
        switch (whitchDay) {
            case 0:
                day1box.setStyle(style);
                break;
            case 1:
                day2box.setStyle(style);
                break;
            case 2:
                day3box.setStyle(style);
                break;
            case 3:
                day4box.setStyle(style);
                break;
            default:
                day5box.setStyle(style);
        }
    }

    /**
     * Clears the color of the VBoxes containing the daily weather forecast information, by clearing their css style.
     */
    public void clearDayColor(){
        day1box.setStyle("");
        day2box.setStyle("");
        day3box.setStyle("");
        day4box.setStyle("");
        day5box.setStyle("");
    }

    /**
     *  Loads the hourly information regarding the weather forecast into the Graphical User Interface.
     * @param which_day Integer that helps in identifying the day for which we have to load the forecast data.
     */
    public void setHourlyWeather(int which_day) {
        String currentTime;
        double kelvin;
        double celsius;
        for(int i = 0; i < 39; i++) {
            currentTime = forecastWeatherData.getList()[i].getDt_txt();
            String[] preciseDate = currentTime.split(" ");
            if (preciseDate[0].equals(LocalDate.now().plusDays(which_day).toString())) {
                if(preciseDate[1].equals("00:00:00"))
                {
                    hour0.setText(preciseDate[1]);
                    kelvin = forecastWeatherData.getList()[i].getMain().getTemp();
                    celsius = kelvin - 273.15;
                    hour0temp.setText(String.format("%.1f",kelvin) + "K  " + String.format("%.1f", celsius) + "℃");
                    Handler.setImageViewByDate(forecastWeatherData,hour0img,currentTime);
                }
                if(preciseDate[1].equals("03:00:00"))
                {
                    hour3.setText(preciseDate[1]);
                    kelvin = forecastWeatherData.getList()[i].getMain().getTemp();
                    celsius = kelvin - 273.15;
                    hour3temp.setText(String.format("%.1f",kelvin) + "K  " + String.format("%.1f", celsius) + "℃");
                    Handler.setImageViewByDate(forecastWeatherData,hour3img,currentTime);
                }
                if(preciseDate[1].equals("06:00:00"))
                {
                    hour6.setText(preciseDate[1]);
                    kelvin = forecastWeatherData.getList()[i].getMain().getTemp();
                    celsius = kelvin - 273.15;
                    hour6temp.setText(String.format("%.1f",kelvin) + "K  " + String.format("%.1f", celsius) + "℃");
                    Handler.setImageViewByDate(forecastWeatherData,hour6img,currentTime);
                }
                if(preciseDate[1].equals("09:00:00"))
                {
                    hour9.setText(preciseDate[1]);
                    kelvin = forecastWeatherData.getList()[i].getMain().getTemp();
                    celsius = kelvin - 273.15;
                    hour9temp.setText(String.format("%.1f",kelvin) + "K  " + String.format("%.1f", celsius) + "℃");
                    Handler.setImageViewByDate(forecastWeatherData,hour9img,currentTime);
                }
                if(preciseDate[1].equals("12:00:00"))
                {
                    hour12.setText(preciseDate[1]);
                    kelvin = forecastWeatherData.getList()[i].getMain().getTemp();
                    celsius = kelvin - 273.15;
                    hour12temp.setText(String.format("%.1f",kelvin) + "K  " + String.format("%.1f", celsius) + "℃");
                    Handler.setImageViewByDate(forecastWeatherData,hour12img,currentTime);
                }
                if(preciseDate[1].equals("15:00:00"))
                {
                    hour15.setText(preciseDate[1]);
                    kelvin = forecastWeatherData.getList()[i].getMain().getTemp();
                    celsius = kelvin - 273.15;
                    hour15temp.setText(String.format("%.1f",kelvin) + "K  " + String.format("%.1f", celsius) + "℃");
                    Handler.setImageViewByDate(forecastWeatherData,hour15img,currentTime);
                }
                if(preciseDate[1].equals("18:00:00"))
                {
                    hour18.setText(preciseDate[1]);
                    kelvin = forecastWeatherData.getList()[i].getMain().getTemp();
                    celsius = kelvin - 273.15;
                    hour18temp.setText(String.format("%.1f",kelvin) + "K  " + String.format("%.1f", celsius) + "℃");
                    Handler.setImageViewByDate(forecastWeatherData,hour18img,currentTime);
                }
                if(preciseDate[1].equals("21:00:00"))
                {
                    hour21.setText(preciseDate[1]);
                    kelvin = forecastWeatherData.getList()[i].getMain().getTemp();
                    celsius = kelvin - 273.15;
                    hour21temp.setText(String.format("%.1f",kelvin) + "K  " + String.format("%.1f", celsius) + "℃");
                    Handler.setImageViewByDate(forecastWeatherData,hour21img,currentTime);
                }
            }
        }

    }

    /**
     * Clears the existing information regarding the hourly weather data from the Graphical User Interface.
     */
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

    /**
     * Sets the corresponding VBoxes color and clears the unselected VBoxes, writes out the corresponding hourly weather data.
     */
    public void  day1click(){
        clearDayColor();
        setDayColor(0);
        clearHourlyWeather();
        setHourlyWeather(0);
        nap = LocalDate.now().toString();
    }

    /**
     * Sets the corresponding VBoxes color and clears the unselected VBoxes, writes out the corresponding hourly weather data.
     */
    public void  day2click(){
        clearDayColor();
        setDayColor(1);
        clearHourlyWeather();
        setHourlyWeather(1);
        nap = LocalDate.now().plusDays(1).toString();
    }

    /**
     * Sets the corresponding VBoxes color and clears the unselected VBoxes, writes out the corresponding hourly weather data.
     */
    public void  day3click(){
        clearDayColor();
        setDayColor(2);
        clearHourlyWeather();
        setHourlyWeather(2);
        nap = LocalDate.now().plusDays(2).toString();
    }

    /**
     * Sets the corresponding VBoxes color and clears the unselected VBoxes, writes out the corresponding hourly weather data.
     */
    public void  day4click(){
        clearDayColor();
        setDayColor(3);
        clearHourlyWeather();
        setHourlyWeather(3);
        nap = LocalDate.now().plusDays(3).toString();
    }

    /**
     * Sets the corresponding VBoxes color and clears the unselected VBoxes, writes out the corresponding hourly weather data.
     */
    public void  day5click() {
        clearDayColor();
        setDayColor(4);
        clearHourlyWeather();
        setHourlyWeather(4);
        nap = LocalDate.now().plusDays(4).toString();
    }

    /**
     * Sets the color of the chosen VBox containing the hourly weather information by css code.
     * @param whitchHour Integer that tells the function which VBoxes color needs to be set, of the VBoxes containing the hourly weathers information.
     */
    public void setHourColor(int whitchHour){
        String style = "-fx-background-color: rgba(255, 255, 255, 0.5);";
        switch (whitchHour){
            case 0:
                hour0box.setStyle(style);
                break;
            case 3:
                hour3box.setStyle(style);
                break;
            case 6:
                hour6box.setStyle(style);
                break;
            case 9:
                hour9box.setStyle(style);
                break;
            case 12:
                hour12box.setStyle(style);
                break;
            case 15:
                hour15box.setStyle(style);
                break;
            case 18:
                hour18box.setStyle(style);
                break;
            default:
                hour21box.setStyle(style);
        }
    }

    /**
     * Clears the color of the VBoxes containing the hourly weather forecast information, by clearing their css style.
     */
    public void clearHourColor(){
        hour0box.setStyle("");
        hour3box.setStyle("");
        hour6box.setStyle("");
        hour9box.setStyle("");
        hour12box.setStyle("");
        hour15box.setStyle("");
        hour18box.setStyle("");
        hour21box.setStyle("");
    }

    /**
     * Clears the existing information regarding the detailed hourly data from the Graphical User Interface.
     */
    public void hourClear(){
        hourlyWindSpeed.setText("");
        hourlyWindDeg.setText("");
        hourlyPressure.setText("");
        hourlyMin.setText("");
        hourlyMax.setText("");
        hourlyHumidity.setText("");
        hourlyClouds.setText("");
    }

    /**
     * Loads a detailed weather forecast data for the selected hour into the Graphical User Interface.
     * @param currentHour String that helps in identifying the selected hour for which we have to load the forecast data.
     */
    public void setDetailedHourlyWeather(String currentHour) {
        hourClear();
        for(int i = 0; i < 39; i++) {
            if(forecastWeatherData.getList()[i].getDt_txt().equals(currentHour)) {
                double maxKelvin = forecastWeatherData.getList()[i].getMain().getTemp_max();
                double minKelvin = forecastWeatherData.getList()[i].getMain().getTemp_min();
                double maxCelsius = maxKelvin - 273.15;
                double minCelsius = minKelvin - 273.15;
                log.info("talaltunk valamit");
                hourlyClouds.setText(Double.toString(forecastWeatherData.getList()[i].getClouds().getAll()) + "%");
                hourlyHumidity.setText(Integer.toString(forecastWeatherData.getList()[i].getMain().getHumidity()) + "%");
                hourlyMax.setText(String.format("%.1f",maxKelvin) + "K  " + String.format("%.1f", maxCelsius) + "℃");
                hourlyMin.setText(String.format("%.1f",minKelvin) + "K  " + String.format("%.1f", minCelsius) + "℃");
                hourlyPressure.setText(Double.toString(forecastWeatherData.getList()[i].getMain().getPressure()));
                hourlyWindDeg.setText(Double.toString(forecastWeatherData.getList()[i].getWind().getDeg()));
                hourlyWindSpeed.setText(Double.toString(forecastWeatherData.getList()[i].getWind().getSpeed()));
            }
        }

    }

    /**
     * Sets the corresponding VBoxes color and clears the unselected VBoxes, writes out the corresponding Detailed weather data.
     */
    public void  hour0click(){
        clearHourColor();
        setHourColor(0);
        String currentHour = nap + " 00:00:00";
        hourlyPane.setBackground(ImageHandler.getBackgroundImage(hourlyPane, Handler.getDescriptionByDate(forecastWeatherData, currentHour), currentHour));
        setDetailedHourlyWeather(currentHour);
    }

    /**
     * Sets the corresponding VBoxes color and clears the unselected VBoxes, writes out the corresponding Detailed weather data.
     */
    public void  hour3click(){
        clearHourColor();
        setHourColor(3);
        String currentHour = nap + " 03:00:00";
        hourlyPane.setBackground(ImageHandler.getBackgroundImage(hourlyPane, Handler.getDescriptionByDate(forecastWeatherData, currentHour), currentHour));
        setDetailedHourlyWeather(currentHour);

    }

    /**
     * Sets the corresponding VBoxes color and clears the unselected VBoxes, writes out the corresponding Detailed weather data.
     */
    public void  hour6click(){
        clearHourColor();
        setHourColor(6);
        String currentHour = nap + " 06:00:00";
        hourlyPane.setBackground(ImageHandler.getBackgroundImage(hourlyPane, Handler.getDescriptionByDate(forecastWeatherData, currentHour), currentHour));
        setDetailedHourlyWeather(currentHour);

    }

    /**
     * Sets the corresponding VBoxes color and clears the unselected VBoxes, writes out the corresponding Detailed weather data.
     */
    public void  hour9click(){
        clearHourColor();
        setHourColor(9);
        String currentHour = nap + " 09:00:00";
        hourlyPane.setBackground(ImageHandler.getBackgroundImage(hourlyPane, Handler.getDescriptionByDate(forecastWeatherData, currentHour), currentHour));
        setDetailedHourlyWeather(currentHour);

    }

    /**
     * Sets the corresponding VBoxes color and clears the unselected VBoxes, writes out the corresponding Detailed weather data.
     */
    public void  hour12click(){
        clearHourColor();
        setHourColor(12);
        String currentHour = nap + " 12:00:00";
        hourlyPane.setBackground(ImageHandler.getBackgroundImage(hourlyPane, Handler.getDescriptionByDate(forecastWeatherData, currentHour), currentHour));
        setDetailedHourlyWeather(currentHour);

    }

    /**
     * Sets the corresponding VBoxes color and clears the unselected VBoxes, writes out the corresponding Detailed weather data.
     */
    public void  hour15click(){
        clearHourColor();
        setHourColor(15);
        String currentHour = nap + " 15:00:00";
        hourlyPane.setBackground(ImageHandler.getBackgroundImage(hourlyPane, Handler.getDescriptionByDate(forecastWeatherData, currentHour), currentHour));
        setDetailedHourlyWeather(currentHour);

    }

    /**
     * Sets the corresponding VBoxes color and clears the unselected VBoxes, writes out the corresponding Detailed weather data.
     */
    public void  hour18click(){
        clearHourColor();
        setHourColor(18);
        String currentHour = nap + " 18:00:00";
        hourlyPane.setBackground(ImageHandler.getBackgroundImage(hourlyPane, Handler.getDescriptionByDate(forecastWeatherData, currentHour), currentHour));
        setDetailedHourlyWeather(currentHour);

    }

    /**
     * Sets the corresponding VBoxes color and clears the unselected VBoxes, writes out the corresponding Detailed weather data.
     */
    public void  hour21click(){
        clearHourColor();
        setHourColor(21);
        String currentHour = nap + " 21:00:00";
        hourlyPane.setBackground(ImageHandler.getBackgroundImage(hourlyPane, Handler.getDescriptionByDate(forecastWeatherData, currentHour), currentHour));
        setDetailedHourlyWeather(currentHour);
    }

}


