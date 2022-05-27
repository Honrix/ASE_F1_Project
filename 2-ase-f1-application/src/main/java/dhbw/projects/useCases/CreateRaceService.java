package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.date.Date;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.race.Race;
import dhbw.projects.data.track.Track;

import java.util.List;
import java.util.UUID;


public class CreateRaceService {

    private final RaceRepository raceRepository;

    public CreateRaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<Race> getAllRaces() {
        return this.raceRepository.getAll();
    }

    public void insert(Track track, List<DriverInformations> scoreboard, int length, Date date) {
        Race race = new Race(track, scoreboard, length, date, UUID.randomUUID());
        this.raceRepository.insert(race);
    }
}
