package dhbw.projects.values;

import dhbw.projects.ValuesRepository;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.nation.Nation;
import dhbw.projects.data.team.Team;
import dhbw.projects.data.track.Track;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class ValuesServiceTest {

    @Test
    public void insertObjectsTest(){
        ValuesRepository valuesRepository = mock(ValuesRepository.class);
        String driverName = "TestDriver";
        int driverId = 10;
        String nation = "TestNation";
        String team = "TestTeam";
        String track = "TestTrack";
        valuesRepository.insertTrack(track);
        valuesRepository.insertTeam(team);
        valuesRepository.insertNation(nation);
        valuesRepository.insertDriver(driverId, driverName, nation, team);
        verify(valuesRepository).insertDriver(driverId, driverName, nation, team);
        verify(valuesRepository).insertTrack(track);
        verify(valuesRepository).insertTeam(team);
        verify(valuesRepository).insertNation(nation);

    }

    @Test
    public void getDriversTest(){
        ValuesService valuesService = new ValuesService();
        Map<String, Driver> drivers = new HashMap<>();
        Map<String, String> driverNames = new HashMap<>();
        drivers.put("0", mock(Driver.class));
        drivers.put("1", mock(Driver.class));
        driverNames.put("0", "Test1");
        driverNames.put("1", "Test2");
        valuesService.insertDriver(0, "Test1", "Test1", "Test1");
        valuesService.insertDriver(1, "Test2", "Test2", "Test2");
        assertEquals(drivers.size(), valuesService.getDrivers().size());
        assertEquals(driverNames.getClass(), valuesService.getDriverNames().getClass());
        assertEquals(drivers.size(), valuesService.getDrivers().size());
        assertEquals(driverNames.getClass(), valuesService.getDriverNames().getClass());
    }

    @Test
    public void getNationByName(){
        ValuesService valuesService = new ValuesService();
        Nation nation1 = mock(Nation.class);
        Nation nation2 = mock(Nation.class);
        when(nation1.getName()).thenReturn("Test1");
        when(nation1.getName()).thenReturn("Test3");
        valuesService.insertNation("Test1");
        valuesService.insertNation("Test2");
        assertEquals("Test1", valuesService.getNationByName("Test1").getName());
        assertNull(valuesService.getNationByName("TestX"));
    }

    @Test
    public void getTeamByName(){
        ValuesService valuesService = new ValuesService();
        Team team1 = mock(Team.class);
        Team team2 = mock(Team.class);
        when(team1.toString()).thenReturn("Test1");
        when(team2.toString()).thenReturn("Test3");
        valuesService.insertTeam("Test1");
        valuesService.insertTeam("Test2");
        assertEquals("Test1", valuesService.getTeamByName("Test1").toString());
        assertNull(valuesService.getNationByName("TestX"));
    }

    @Test
    public void getTrackById(){
        ValuesService valuesService = new ValuesService();
        Track track1 = mock(Track.class);
        Track track2 = mock(Track.class);
        valuesService.insertTrack("Test1");
        valuesService.insertTrack("Test2");
        assertEquals("Test1", valuesService.getTrackById("1").toString());
        assertNull(valuesService.getTrackById("Test3"));

    }

    @Test
    public void getTeamsTest(){
        ValuesService valuesService = new ValuesService();
        Map<String, Team> teams = new HashMap<>();
        Map<String, String> teamNames = new HashMap<>();
        teams.put("0", mock(Team.class));
        teams.put("1", mock(Team.class));
        teamNames.put("0", "test1");
        teamNames.put("1", "test2");
        valuesService.insertTeam("test1");
        valuesService.insertTeam("test2");
        assertEquals(teams.size(), valuesService.getTeams().size());
        assertEquals(teamNames.size(), valuesService.getTeamNames().size());
        assertEquals(teams.getClass(), valuesService.getTeams().getClass());
        assertEquals(teamNames.getClass(), valuesService.getTeamNames().getClass());
    }

    @Test
    public void getNationsTest(){
        ValuesService valuesService = new ValuesService();
        Map<String, Nation> nations = new HashMap<>();
        Map<String, String> nationalities = new HashMap<>();
        nations.put("0", mock(Nation.class));
        nations.put("1", mock(Nation.class));
        nationalities.put("0", "test1");
        nationalities.put("1", "test2");
        valuesService.insertNation("test1");
        valuesService.insertNation("test2");
        assertEquals(nations.size(), valuesService.getNations().size());
        assertEquals(nationalities.getClass(), valuesService.getNationalities().getClass());
        assertEquals(nations.size(), valuesService.getNations().size());
        assertEquals(nationalities.getClass(), valuesService.getNationalities().getClass());
    }

    @Test
    public void getTracksTest(){
        ValuesService valuesService = new ValuesService();
        Map<String, Track> tracks = new HashMap<>();
        Map<String, Track> trackNames = new HashMap<>();
        tracks.put("0", mock(Track.class));
        tracks.put("1", mock(Track.class));
        trackNames.put("0", mock(Track.class));
        trackNames.put("1", mock(Track.class));
        valuesService.insertTrack("test1");
        valuesService.insertTrack("test2");
        assertEquals(tracks.size(), valuesService.getTracks().size());
        assertEquals(trackNames.getClass(), valuesService.getTrackNames().getClass());
        assertEquals(tracks.size(), valuesService.getTracks().size());
        assertEquals(trackNames.getClass(), valuesService.getTrackNames().getClass());
    }

}