package dhbw.projects.data.race;

import dhbw.projects.data.date.Date;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.track.Track;

import java.util.List;
import java.util.UUID;

public class Race {

    private final Track trackName;
    private final List<DriverInformations> scoreboard;
    private final int lengthTime;
    private final Date date;
    private final UUID raceId;

    public Race(Track trackName, List<DriverInformations> scoreboard, int lengthTime, Date date, UUID uuid) {
        this.trackName = trackName;
        this.scoreboard = scoreboard;
        this.lengthTime = lengthTime;
        this.date = date;
        this.raceId = uuid;
    }

    public Track getTrackName() {
        return trackName;
    }

    public List<DriverInformations> getScoreboard() {
        return scoreboard;
    }

    public int getLengthTime() {
        return lengthTime;
    }

    public Date getDate() {
        return date;
    }

    public UUID getRaceId() {
        return this.raceId;
    }
}
