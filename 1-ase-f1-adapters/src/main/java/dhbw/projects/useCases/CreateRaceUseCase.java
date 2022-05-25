package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.Date;
import dhbw.projects.data.race.Race;

public class CreateRaceUseCase {

    private final RaceRepository raceRepository;

    public CreateRaceUseCase(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public void insert(Race race){
        this.raceRepository.insert(race);
    }

    public boolean validateDate(String date){
        return date.matches("^\\d{8}$");
    }

    public boolean validateLaptime(String date){
        return date.matches("^\\d{1,3}[.]\\d{3}$");
    }

    public boolean validateSelection(String input, int maxValue){
        if(input.matches("^\\d+$")) {
            return (0 < Integer.parseInt(input) && Integer.parseInt(input) <= maxValue);
        } else {
            return false;
        }
    }
}
