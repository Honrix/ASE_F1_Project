package dhbw.projects.data.driver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DriverIdTest {

    @Test
    public void getCorrectId(){
        DriverId driverId = new DriverId(50);
        assertThrows(IllegalArgumentException.class, () -> new DriverId(100));
        assertThrows(IllegalArgumentException.class, () -> new DriverId(0));
        assertEquals(driverId.getId(), 50);
    }

}
