package dhbw.projects;

import dhbw.projects.data.Date;
import dhbw.projects.data.track.Track;

import java.util.List;


public class RaceResult {

    private final Track trackName;
    private final List<DriverStats> leaderboard;
    private final int lengthTime;      //Int als Prozentzahl der Länge des Rennens
    private final Date date;           //YYYYMMDD

    //final RaceValues[] lengths = {FULL_LENGTH, HALF_LENGTH, FOURTH_LENGTH};

    public RaceResult(Track trackName, List<DriverStats> leaderboard, int lengthTime, Date date) throws Exception {
        /*if(!validateLengthTime(lengthTime)) {
            throw new IllegalArgumentException("Error by creating the result of a certain race");
        }*/
        this.trackName = trackName;
        this.leaderboard = leaderboard;
        this.lengthTime = lengthTime;
        this.date = date;

    }

    /*public boolean validateLengthTime(int length) {
        for(RaceValues value: lengths){
            if(length == value.getNumber()){
                return true;
            }
        }
        return false;
    }*/
}
