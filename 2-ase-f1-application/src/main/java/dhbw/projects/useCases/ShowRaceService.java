package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.race.Race;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowRaceService {

    private final RaceRepository raceRepository;

    public ShowRaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public RaceRepository getRaceRepository() {
        return raceRepository;
    }

    public List<Race> loadRaces(){
        return raceRepository.getAll();
    }

    public int getDecimalDigits(double number){
        int decimalDigits;
        decimalDigits = (int)((number - Math.floor(number))*1000);
        if(decimalDigits < 100) {
            if (decimalDigits < 10) {
                decimalDigits *= 100;
            } else {
                decimalDigits *= 10;
            }
        }
        return decimalDigits;
    }

    public Map<Integer, Race> getExistingRaces(){
        List<Race> races = loadRaces();
        Map<Integer, Race> allRaces = new HashMap<>();
        for (int i = 0; i < races.size(); i++) {
            allRaces.put(i, races.get(i));
        }
        return allRaces;
    }

}
