package dhbw.projects.race;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.race.Race;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RaceRepositoryImpl implements RaceRepository {

    private final List<Race> races = new ArrayList<>();

    @Override
    public void insert(Race race) {
        races.add(race);
    }

    @Override
    public List<Race> getAll() {
        return races;
    }

    @Override
    public Race getById(UUID raceId) {
        return races.stream().filter(race -> race.getRaceId() == raceId).toList().get(0);
    }
}
