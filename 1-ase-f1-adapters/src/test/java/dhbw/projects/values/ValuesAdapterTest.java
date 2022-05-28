package dhbw.projects.values;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ValuesAdapterTest {


    @Test
    void getValuesService() {
        ValuesAdapter valuesAdapter = new ValuesAdapter();
        assertEquals(ValuesService.class, valuesAdapter.getValuesService().getClass());
    }

    @Test
    void insertDriver() {
        ValuesAdapter valuesAdapter = new ValuesAdapter();
        assertThrows(IllegalArgumentException.class, () -> valuesAdapter.insertDriver(
                1, "", "Test", "Test"));
        assertThrows(IllegalArgumentException.class, () -> valuesAdapter.insertDriver(
                1, "Test", "", "Test"));
        assertThrows(IllegalArgumentException.class, () -> valuesAdapter.insertDriver(
                1, "Test", "Test", ""));
        assertThrows(IllegalArgumentException.class, () -> valuesAdapter.insertDriver(
                100, "Test", "Test", "Test"));
        assertDoesNotThrow(() -> valuesAdapter.insertDriver(
                1, "Test", "Test", "Test"));
    }

    @Test
    void insertTeam() {
        ValuesAdapter valuesAdapter = new ValuesAdapter();
        assertThrows(IllegalArgumentException.class, () -> valuesAdapter.insertTeam(""));
        assertDoesNotThrow(() -> valuesAdapter.insertTeam("Test"));
    }

    @Test
    void insertNation() {
        ValuesAdapter valuesAdapter = new ValuesAdapter();
        assertThrows(IllegalArgumentException.class, () -> valuesAdapter.insertNation(""));
        assertDoesNotThrow(() -> valuesAdapter.insertNation("Test"));
    }

    @Test
    void insertTrack() {
        ValuesAdapter valuesAdapter = new ValuesAdapter();
        assertThrows(IllegalArgumentException.class, () -> valuesAdapter.insertTrack(""));
        assertDoesNotThrow(() -> valuesAdapter.insertTrack("Test"));
    }

    @Test
    void getTeams() {
        ValuesAdapter valuesAdapter = new ValuesAdapter();
        valuesAdapter.insertTeam("Test");
        valuesAdapter.insertTeam("Test1");
        assertEquals(valuesAdapter.getTeams().size(), 2);
        assertEquals(valuesAdapter.getTeams().getClass(), HashMap.class);

    }

    @Test
    void getNations() {
        ValuesAdapter valuesAdapter = new ValuesAdapter();
        valuesAdapter.insertNation("Test");
        valuesAdapter.insertNation("Test1");
        assertEquals(valuesAdapter.getNations().size(), 2);
        assertEquals(valuesAdapter.getNations().getClass(), HashMap.class);

    }

    @Test
    void getDrivers() {
        ValuesAdapter valuesAdapter = new ValuesAdapter();
        valuesAdapter.insertDriver(1, "Test", "Test", "Test");
        valuesAdapter.insertDriver(2, "Test", "Test", "Test");
        assertEquals(valuesAdapter.getDrivers().size(), 2);
        assertEquals(valuesAdapter.getDrivers().getClass(), HashMap.class);

    }

    @Test
    void getTracks() {
        ValuesAdapter valuesAdapter = new ValuesAdapter();
        valuesAdapter.insertTrack("Test");
        valuesAdapter.insertTrack("Test1");
        assertEquals(valuesAdapter.getTracks().size(), 2);
        assertEquals(valuesAdapter.getTracks().getClass(), HashMap.class);

    }

    @Test
    void getTrackNames() {
        ValuesAdapter valuesAdapter = new ValuesAdapter();
        valuesAdapter.insertTrack("Test");
        valuesAdapter.insertTrack("Test1");
        assertEquals(valuesAdapter.getTrackNames().size(), 2);
        assertEquals(valuesAdapter.getTrackNames().getClass(), HashMap.class);

    }

    @Test
    void getNationalities() {
        ValuesAdapter valuesAdapter = new ValuesAdapter();
        valuesAdapter.insertNation("Test");
        valuesAdapter.insertNation("Test1");
        assertEquals(valuesAdapter.getNationalities().size(), 2);
        assertEquals(valuesAdapter.getNationalities().getClass(), HashMap.class);

    }

    @Test
    void getTeamNames() {
        ValuesAdapter valuesAdapter = new ValuesAdapter();
        valuesAdapter.insertTeam("Test");
        valuesAdapter.insertTeam("Test1");
        assertEquals(valuesAdapter.getTeamNames().size(), 2);
        assertEquals(valuesAdapter.getTeamNames().getClass(), HashMap.class);

    }

    @Test
    void getDriverNames() {
        ValuesAdapter valuesAdapter = new ValuesAdapter();
        valuesAdapter.insertDriver(1, "Test", "Test", "Test");
        valuesAdapter.insertDriver(2, "Test", "Test", "Test");
        assertEquals(valuesAdapter.getDriverNames().size(), 2);
        assertEquals(valuesAdapter.getDriverNames().getClass(), HashMap.class);

    }

    @Test
    void getSortedOutput(){
        ValuesAdapter valuesAdapter = new ValuesAdapter();
        Map<String, String> strings = new HashMap<>();
        strings.put("1", "Test1");
        strings.put("2", "Test2");
        strings.put("3", "Test3");
        String testTitle = "TestTitle";
        assertEquals(
                "=========================================================TestTitle==========================================================\n" +
                        " [1] Test1                \n" +
                        " [2] Test2                \n" +
                        " [3] Test3                \n" +
                        "============================================================================================================================\n",
                valuesAdapter.sortedOutput(strings, testTitle));
    }
}