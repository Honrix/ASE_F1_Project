package dhbw.projects.data.driver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DriverInformationsTest {

    @Test
    public void assignAttributesOfDriverInformations() {
        Driver driver = mock(Driver.class);
        int startPosition = 1;
        int finalPosition = 2;
        double fastestLap = 90.039;
        DriverInformations driverInformations = new DriverInformations(
                driver, startPosition, finalPosition, fastestLap);
        assertEquals(driverInformations.getDriver(), driver);
        assertEquals(driverInformations.getStartPosition(), startPosition);
        assertEquals(driverInformations.getFinalPosition(), finalPosition);
        assertEquals(driverInformations.getFastestLap(), fastestLap);
    }
}