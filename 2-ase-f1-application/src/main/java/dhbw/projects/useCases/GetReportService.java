package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.race.Race;

import java.util.List;

public class GetReportService {

    private final RaceRepository raceRepository;

    public GetReportService(RaceRepository raceRepository){
        this.raceRepository = raceRepository;
    }

    public List<Race> getAllRaces() {
        return this.raceRepository.getAll();
    }
}
