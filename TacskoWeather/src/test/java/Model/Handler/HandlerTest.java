package Model.Handler;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import Model.Error.InvalidLocationError;
import Model.Error.InvalidZipCodeError;
import Model.Error.InvalidCoordinatesError;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class HandlerTest {

    @Test
    void readFromAPI() {
        assertThrows(InvalidLocationError.class, () -> Handler.readFromAPI("Nincsilyenhelyszín", true));
        assertThrows(InvalidLocationError.class, () -> Handler.readFromAPI("Nincsilyenhelyszín", false));
        assertDoesNotThrow(() -> Handler.readFromAPI("Debrecen", true));
        assertDoesNotThrow(() -> Handler.readFromAPI("Debrecen", false));
    }

    @Test
    void testReadFromAPI() {
        assertThrows(InvalidZipCodeError.class, () -> Handler.readFromAPI("4123", "RosszOrszág",  true));
        assertThrows(InvalidZipCodeError.class, () -> Handler.readFromAPI("4123", "RosszOrszág",  false));
        assertDoesNotThrow(() -> Handler.readFromAPI("4400", "HU", true));
        assertDoesNotThrow(() -> Handler.readFromAPI("4400", "HU", false));
    }

    @Test
    void testReadFromAPI1() {
        assertThrows(InvalidCoordinatesError.class, () -> Handler.readFromAPI(100000, 100000, true));
        assertThrows(InvalidCoordinatesError.class, () -> Handler.readFromAPI(100000, 100000, false));
        assertDoesNotThrow(() -> Handler.readFromAPI(40, 40, true));
        assertDoesNotThrow(() -> Handler.readFromAPI(40, 40, false));
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