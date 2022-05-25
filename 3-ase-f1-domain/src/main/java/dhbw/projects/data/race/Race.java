package dhbw.projects.data.race;

import dhbw.projects.data.Date;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.track.Track;

import java.util.List;
import java.util.UUID;

public class Race {

    private final Track trackName;
    private final List<DriverInformations> scoreboard;
    private final int lengthTime;      //Länge als Prozentzahl der Länge des Rennens (z.B. 25 = 25%)
    private final Date date;           //YYYYMMDD
    private final UUID raceId;

    public Race(Track trackName, List<DriverInformations> scoreboard, int lengthTime, Date date, UUID uuid) {
        this.trackName = trackName;
        this.scoreboard = scoreboard;
        this.lengthTime = lengthTime;
        this.date = date;
        this.raceId = uuid;
    }

    public UUID getRaceId() {
        return this.raceId;
    }
}
