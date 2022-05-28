package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.date.Date;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.race.Race;
import dhbw.projects.data.track.Track;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

public class CreateRaceServiceTest {

    @Test
    public void insertRaceTest(){
        RaceRepository raceRepository = mock(RaceRepository.class);
        CreateRaceService createRaceService = new CreateRaceService(raceRepository);
        Track track = mock(Track.class);
        List<DriverInformations> scoreboard = new ArrayList<>();
        DriverInformations driverInformations = mock(DriverInformations.class);
        DriverInformations driverInformations1 = mock(DriverInformations.class);
        DriverInformations driverInformations2 = mock(DriverInformations.class);
        scoreboard.add(driverInformations);
        scoreboard.add(driverInformations1);
        scoreboard.add(driverInformations2);
        int length = 50;
        Date date = mock(Date.class);
        createRaceService.insert(track, scoreboard, length, date);
        verify(raceRepository).insert(any());
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
