package dhbw.projects.newRace;

import dhbw.projects.Driver.DriverStats;
import dhbw.projects.data.Date;
import dhbw.projects.data.track.Track;

import java.util.List;
import java.util.UUID;


public class RaceResult {

    private final Track trackName;
    private final List<DriverStats> leaderboard;
    private final int lengthTime;      //Länge als Prozentzahl der Länge des Rennens (z.B. 25 = 25%)
    private final Date date;           //YYYYMMDD
    private final UUID raceId;

    public RaceResult(Track trackName, List<DriverStats> leaderboard, int lengthTime, Date date, UUID uuid) throws Exception {
        if(!validateLengthTime(lengthTime)) {
            throw new IllegalArgumentException("Error by creating the result of a certain race");
        }
        this.trackName = trackName;
        this.leaderboard = leaderboard;
        this.lengthTime = lengthTime;
        this.date = date;
        this.raceId = uuid;

    }

    public boolean validateLengthTime(int length) {
        if(length != 25 && length != 50 && length != 100){
            return false;
        }
        return true;
    }

    public Track getTrackName() {
        return trackName;
    }

    public List<DriverStats> getLeaderboard() {
        return leaderboard;
    }

    public int getLengthTime() {
        return lengthTime;
    }

    public Date getDate() {
        return date;
    }
}
