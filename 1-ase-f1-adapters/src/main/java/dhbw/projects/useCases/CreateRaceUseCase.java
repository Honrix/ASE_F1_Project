package dhbw.projects.useCases;

import dhbw.projects.InputValidator;
import dhbw.projects.RaceRepository;
import dhbw.projects.data.race.Race;

public class CreateRaceUseCase {

    private final CreateRaceService createRaceService;
    private final InputValidator inputValidator = new InputValidator();

    public CreateRaceUseCase(RaceRepository raceRepository) {
        this.createRaceService = new CreateRaceService(raceRepository);
    }

    public void insert(Race race){
        this.createRaceService.insert(race);
    }

    public InputValidator getInputValidator() {
        return inputValidator;
    }
}
