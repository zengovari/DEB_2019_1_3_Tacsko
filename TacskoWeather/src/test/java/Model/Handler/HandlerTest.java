package Model.Handler;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class HandlerTest {

    @Test
    void readFromAPI() {
        String location = "Debrecen";
        String zip = "4444";
        String tag = "HU";
        log.debug(Handler.readFromAPI("Debrecen", false));
        log.debug(Handler.readFromAPI("Debrecen", true));
    }

    @Test
    void testReadFromAPI() {
        log.debug(Handler.readFromAPI("4444", "HU", false));
        log.debug(Handler.readFromAPI("4444", "HU", true));
    }

    @Test
    void testReadFromAPI1() {
        log.debug(Handler.readFromAPI(26.50, 30.26, true));
        log.debug(Handler.readFromAPI(26.50, 30.26, true));
    }

    @Test
    void createMapOfCities() {
    }

    @Test
    void stringLike() {
    }

    @Test
    void setImageViewByDate() {
    }
}