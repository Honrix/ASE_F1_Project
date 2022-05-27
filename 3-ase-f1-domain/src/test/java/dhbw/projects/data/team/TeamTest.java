package dhbw.projects.data.team;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void testToString() {
        UUID uuid = UUID.randomUUID();
        Team team = new Team(uuid, "Test");
        assertEquals(team.toString(), "Test");
        assertEquals(team.getTeamId(), uuid);

    }

}