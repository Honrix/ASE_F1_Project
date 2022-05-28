package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.driver.DriverId;
import dhbw.projects.data.race.Race;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetReportServiceTest {

    @Test
    public void getRacesTest(){
        RaceRepository raceRepository = mock(RaceRepository.class);
        List<Race> raceList = new ArrayList<>();
        raceList.add(mock(Race.class));
        raceList.add(mock(Race.class));
        raceList.add(mock(Race.class));
        when(raceRepository.getAll()).thenReturn(raceList);

        CreateRaceService createRaceService = new CreateRaceService(raceRepository);
        List<Race> allRaces = createRaceService.getAllRaces();
        verify(raceRepository).getAll();
        Assertions.assertEquals(allRaces.size(), raceList.size());

    }

    @Test
    void loadRaces() {
        List<Race> races = new ArrayList<>();
        Race race = mock(Race.class);
        Race race1 = mock(Race.class);
        Race race2 = mock(Race.class);
        races.add(race);
        races.add(race1);
        races.add(race2);
        RaceRepository raceRepository = mock(RaceRepository.class);
        GetReportService getReportService = new GetReportService(raceRepository);
        when(raceRepository.getAll()).thenReturn(races);
        List<Race> output = getReportService.getAllRaces();
        verify(raceRepository).getAll();
        assertEquals(output.size(), races.size());

    }

    @Test
    public void getCorrectPointsOfPosition(){
        RaceRepository raceRepository = mock(RaceRepository.class);
        GetReportService reportService = new GetReportService(raceRepository);
        int[] points = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        for (int i = 0; i < points.length; i++){
            assertEquals(reportService.getPointsOfPosition(i+1), points[i]);
        }
    }

    @Test
    public void findDriver(){
        RaceRepository raceRepository = mock(RaceRepository.class);
        GetReportService getReportService = new GetReportService(raceRepository);
        List<Driver> drivers = new ArrayList<>();
        Driver driver1 = mock(Driver.class);
        Driver driver2 = mock(Driver.class);
        Driver driver3 = mock(Driver.class);
        Driver driver4 = mock(Driver.class);
        Driver wrongDriver = mock(Driver.class);
        drivers.add(driver1);
        drivers.add(driver2);
        drivers.add(driver3);
        when(driver1.getDriverId()).thenReturn(new DriverId(1));
        when(driver2.getDriverId()).thenReturn(new DriverId(2));
        when(driver3.getDriverId()).thenReturn(new DriverId(3));
        assertTrue(getReportService.containsDriver(drivers, driver2));
        assertFalse(getReportService.containsDriver(drivers, wrongDriver));
        assertEquals(getReportService.getDriverPositionInList(drivers, driver2), 1);
        assertEquals(getReportService.getDriverPositionInList(drivers, driver4), 0);

    }
}