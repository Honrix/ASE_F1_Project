package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.race.Race;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CreateRaceServiceTest {

    @Test
    public void insertRaceTest(){
        RaceRepository raceRepository = mock(RaceRepository.class);
        CreateRaceService createRaceService = new CreateRaceService(raceRepository);
        Race race= mock(Race.class);
        createRaceService.insert(race);
        verify(raceRepository).insert(race);
    }

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

}
