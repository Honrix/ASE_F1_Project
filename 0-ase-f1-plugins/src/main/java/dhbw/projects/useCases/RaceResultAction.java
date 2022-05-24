package dhbw.projects.useCases;

import dhbw.projects.race.RaceResultOutput;
import dhbw.projects.race.RaceResultResource;

public class RaceResultAction {

    public RaceResultAction(RaceResultResource raceResultResource){
        RaceResultOutput output = new RaceResultOutput(raceResultResource);
    }

}
