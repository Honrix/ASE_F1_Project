package dhbw.projects.data.nation;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class NationTest {

    @Test
    public void assignAttributesOfNation(){
        UUID uuid = UUID.randomUUID();
        String shortName = "GER";
        String fullName = "Germany";
        Nation nation = new Nation(uuid, shortName, fullName);
        assertEquals(nation.getNationId(), uuid);
        assertEquals(nation.getFullName(), fullName);
        assertEquals(nation.getShortName(), shortName);
    }

}