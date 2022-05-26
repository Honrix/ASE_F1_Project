package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.race.Race;

import java.util.List;


public class CreateRaceService {

    private final RaceRepository raceRepository;

    public CreateRaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<Race> getAllRaces() {
        return this.raceRepository.getAll();
    }

    public void insert(Race race) {
        this.raceRepository.insert(race);
    }
}
