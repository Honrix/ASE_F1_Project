package dhbw.projects;


import dhbw.projects.data.race.Race;

import java.util.List;
import java.util.UUID;

public interface RaceRepository {

    void insert(Race race);
    List<Race> getAll();
    Race getById(UUID nationId);
}
