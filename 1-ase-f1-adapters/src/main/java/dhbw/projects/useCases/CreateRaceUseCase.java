package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.race.Race;

public class CreateRaceUseCase {

    private final RaceRepository raceRepository;

    public CreateRaceUseCase(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public void insert(Race race){
        this.raceRepository.insert(race);
    }
}
