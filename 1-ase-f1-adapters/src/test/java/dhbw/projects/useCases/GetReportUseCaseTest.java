package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.driver.Driver;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class GetReportUseCaseTest {

    @Test
    void getTotalPoints() {
        RaceRepository raceRepository = mock(RaceRepository.class);
        Map<String, Driver> drivers = new HashMap<>();
        Driver driver = mock(Driver.class);
        Driver driver1 = mock(Driver.class);
        drivers.put("1", driver);
        drivers.put("2", driver1);
        GetReportUseCase getReportUseCase = new GetReportUseCase(raceRepository, drivers);
        List<Integer> list = new ArrayList<>();
        List<Driver> list2 = new ArrayList<>();
        assertEquals(Object[].class, getReportUseCase.listOfTotalPoints().getClass());
        assertEquals(0, getReportUseCase.listOfTotalPoints().length);
        assertEquals(list.getClass(), getReportUseCase.getTotalPoints().getClass());
        assertEquals(list2.getClass(), getReportUseCase.getDriverWithPoints().getClass());
        assertEquals(getReportUseCase.getDriverWithPoints().size(), getReportUseCase.getTotalPoints().size());

    }
}