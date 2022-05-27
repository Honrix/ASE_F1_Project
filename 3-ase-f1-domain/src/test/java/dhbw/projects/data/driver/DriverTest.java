package dhbw.projects.data.driver;

import dhbw.projects.data.nation.Nation;
import dhbw.projects.data.team.Team;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DriverTest {

    @Test
    public void assignAttributesOfDriver() {
        String name = "Testfahrer";
        Nation nation = mock(Nation.class);
        Team team = mock(Team.class);
        DriverId driverId = mock(DriverId.class);
        Driver driver = new Driver(driverId, name, nation, team);
        assertEquals(driver.getName(), name);
        assertEquals(driver.getDriverId(), driverId);

    }
}