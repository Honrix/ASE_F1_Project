package dhbw.projects.team;

import dhbw.projects.TeamRepository;
import dhbw.projects.data.team.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TeamRepositoryImpl implements TeamRepository {

    private final List<Team> teams = new ArrayList<>();

    @Override
    public void insert(Team team) {
        teams.add(team);
    }

    @Override
    public List<Team> getAll() {
        return teams;
    }

    @Override
    public Team getById(UUID teamId) {
        return teams.stream().filter(team -> team.getTeamId() == teamId).toList().get(0);
    }
}
