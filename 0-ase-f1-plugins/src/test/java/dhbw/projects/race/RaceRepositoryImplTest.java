package dhbw.projects.race;

import dhbw.projects.data.date.Date;
import dhbw.projects.data.driver.DriverId;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.nation.Nation;
import dhbw.projects.data.race.Race;
import dhbw.projects.data.team.Team;
import dhbw.projects.data.track.Track;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class RaceRepositoryImplTest {

    @Test
    void getRace() {
        RaceRepositoryImpl raceRepository = new RaceRepositoryImpl();
        List<Race> races = new ArrayList<>();
        List<DriverInformations> driverInformations = new ArrayList<>();
        DriverId driverId = mock(DriverId.class);
        Date date = mock(Date.class);
        Track track = mock(Track.class);
        DriverInformations driverInformations1 = mock(DriverInformations.class);
        DriverInformations driverInformations2 = mock(DriverInformations.class);
        driverInformations.add(driverInformations1);
        driverInformations.add(driverInformations2);
        UUID uuid = UUID.randomUUID();
        Race race = new Race(track, driverInformations, 25, date, uuid);
        Race race2 = new Race(track, driverInformations, 25, date, UUID.randomUUID());
        races.add(race);
        raceRepository.insert(race);
        assertEquals(race, raceRepository.getAll().get(0));
        assertNotEquals(race2, raceRepository.getAll().get(0));
        raceRepository.insertRaceList(races);
        assertEquals(races, raceRepository.getAll());
        assertEquals(race, raceRepository.getById(uuid));

    }
}