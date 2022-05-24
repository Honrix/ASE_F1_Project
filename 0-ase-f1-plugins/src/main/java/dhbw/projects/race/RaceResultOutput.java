package dhbw.projects.race;

import dhbw.projects.Driver.DriverStats;
import dhbw.projects.data.Date;
import dhbw.projects.data.track.Track;

import java.util.List;
import java.util.UUID;

public class RaceResultOutput {

    private final Track trackName;
    private final List<DriverStats> leaderboard;
    private final int lengthTime;
    private final Date date;


    public RaceResultOutput(RaceResultResource raceResultResource){
        this.trackName = raceResultResource.getRaceResult().getTrackName();
        this.leaderboard = raceResultResource.getRaceResult().getLeaderboard();
        this.lengthTime = raceResultResource.getRaceResult().getLengthTime();
        this.date = raceResultResource.getRaceResult().getDate();

    }

    public String toString(){
        String output = "######################################################\n";
        output += date.toString() + ", " + lengthTime + "% " + trackName + ": ";
        for (DriverStats driverStat: leaderboard) {
            output += "\n    " + driverStat.getFinalPosition() + ". " + driverStat.getName();
        }
        output += "\n######################################################";
        return output;
    }

}
