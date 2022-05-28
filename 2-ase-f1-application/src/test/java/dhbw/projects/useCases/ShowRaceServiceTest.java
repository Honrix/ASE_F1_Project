package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.race.Race;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShowRaceServiceTest {

    @Test
    void getRaceRepository() {
        RaceRepository raceRepository = mock(RaceRepository.class);
        ShowRaceService showRaceService = new ShowRaceService(raceRepository);
        assertEquals(showRaceService.getRaceRepository(), raceRepository);
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
        ShowRaceService showRaceService = new ShowRaceService(raceRepository);
        when(raceRepository.getAll()).thenReturn(races);
        List<Race> output = showRaceService.loadRaces();
        verify(raceRepository).getAll();
        assertEquals(output.size(), races.size());

    }

    @Test
    void getDecimalDigits() {
        RaceRepository raceRepository = mock(RaceRepository.class);
        ShowRaceService showRaceService = new ShowRaceService(raceRepository);
        double test1 = 0;
        double test2 = 0.001;
        double test3 = 0.010;
        double test4 = 0.123;
        double test5 = 1.234;
        assertEquals(0, showRaceService.getDecimalDigits(test1));
        assertEquals(100, showRaceService.getDecimalDigits(test2));
        assertEquals(100, showRaceService.getDecimalDigits(test3));
        assertEquals(123, showRaceService.getDecimalDigits(test4));
        assertEquals(234, showRaceService.getDecimalDigits(test5));

    }

    @Test
    void getExistingRaces() {
        List<Race> races = new ArrayList<>();
        Race race = mock(Race.class);
        Race race1 = mock(Race.class);
        Race race2 = mock(Race.class);
        races.add(race);
        races.add(race1);
        races.add(race2);
        RaceRepository raceRepository = mock(RaceRepository.class);
        ShowRaceService showRaceService = new ShowRaceService(raceRepository);
        when(showRaceService.loadRaces()).thenReturn(races);
        Map<Integer, Race> output = showRaceService.getExistingRaces();
        assertEquals(output.size(), races.size());
        assertEquals(output.get(0), race);

    }
}