package dhbw.projects;

import dhbw.projects.data.team.Team;

import java.util.List;
import java.util.UUID;

public interface TeamRepository {
    void insert(Team team);
    List<Team> getAll();
    Team getById(UUID teamId);
}
