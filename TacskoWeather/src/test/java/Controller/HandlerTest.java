package Controller;

import Model.Handler.Handler;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class HandlerTest {



    @Test
    void ReadFromAPI() {
        String location = "Debrecen";
        String zip = "4444";
        String tag = "HU";
        log.debug(Handler.readFromAPI(location, false));
        log.debug(Handler.readFromAPI(location, true));
        log.debug(Handler.readFromAPI(zip, tag, false));
        log.debug(Handler.readFromAPI(zip, tag, true));
    }

    @Test
    void readCities() {
    }

    @Test
    void createMapOfCities() {
    }

    @Test
    void getCountries() {
    }

    @Test
    void stringLike() {
    }

    @Test
    void getCurrentWeatherData() {
    }

    @Test
    void getForecastWeatherData() {
    }

    @Test
    void testGetCurrentWeatherData() {
    }

    @Test
    void testGetForecastWeatherData() {
    }
}