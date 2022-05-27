package dhbw.projects.data.race;

import dhbw.projects.data.date.Date;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.track.Track;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class RaceTest {

    @Test
    void assignAttributesOfRace() {
        Track track = mock(Track.class);
        DriverInformations driverInformations = mock(DriverInformations.class);
        List<DriverInformations> scoreboard = new ArrayList<>();
        scoreboard.add(driverInformations);
        int lengthTime = 50;
        Date date = mock(Date.class);
        UUID uuid = UUID.randomUUID();
        Race race = new Race(track, scoreboard, lengthTime, date, uuid);
        assertEquals(race.getTrack(), track);
        assertEquals(race.getScoreboard(), scoreboard);
        assertEquals(race.getLengthTime(), 50);
        assertEquals(race.getDate(), date);
        assertEquals(race.getRaceId(), uuid);

    }
}
