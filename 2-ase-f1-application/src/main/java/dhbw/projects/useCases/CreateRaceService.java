package dhbw.projects.useCases;

import dhbw.projects.data.Date;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.race.Race;
import dhbw.projects.data.track.Track;

import java.util.List;
import java.util.UUID;


public class CreateRaceService {

    private final Race race;

    public CreateRaceService(Track trackName, List<DriverInformations> scoreboard, int lengthTime, Date date, UUID uuid) throws Exception {
        if(!validateLengthTime(lengthTime)) {
            throw new IllegalArgumentException("Error by creating the result of a certain race");
        }
        this.race = new Race(trackName, scoreboard, lengthTime, date, uuid);

    }

    public Race getRace() {
        return race;
    }

    public boolean validateLengthTime(int length) {
        if(length != 25 && length != 50 && length != 100){
            return false;
        }
        return true;
    }
}
