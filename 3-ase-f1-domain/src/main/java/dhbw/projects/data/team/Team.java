package dhbw.projects.data.team;

import java.util.UUID;

public class Team {

    private String name;
    private UUID teamId;

    public Team(UUID uuid, String name) {
        this.teamId = uuid;
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public UUID getTeamId() {
        return teamId;
    }
}
