package dhbw.projects.race;

import dhbw.projects.Driver.DriverStats;
import dhbw.projects.data.Date;
import dhbw.projects.data.track.Track;
import dhbw.projects.newRace.RaceResult;

import java.util.List;

public class RaceResultResource {

    private final RaceResult raceResult;

    public RaceResultResource(RaceResult raceResult){
        this.raceResult = raceResult;
    }

    public RaceResult getRaceResult(){
        return raceResult;
    }

}
