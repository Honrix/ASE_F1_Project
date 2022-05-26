package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.race.Race;

import java.util.List;

public class ShowRaceService {

    private final RaceRepository raceRepository;

    public ShowRaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public RaceRepository getRaceRepository() {
        return raceRepository;
    }

    public List<Race> getExistingRaces(){
        return raceRepository.getAll();
    }

}
