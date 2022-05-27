package dhbw.projects.data.nation;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class NationTest {

    @Test
    public void assignAttributesOfNation(){
        UUID uuid = UUID.randomUUID();
        String name = "Germany";
        Nation nation = new Nation(uuid, name);
        assertEquals(nation.getNationId(), uuid);
        assertEquals(nation.getName(), name);
    }

}