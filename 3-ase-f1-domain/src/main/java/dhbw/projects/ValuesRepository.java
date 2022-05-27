package dhbw.projects;

import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.nation.Nation;
import dhbw.projects.data.team.Team;
import dhbw.projects.data.track.Track;

import java.util.Map;

public interface ValuesRepository {

    void setTracks();
    Map<String, Track> getTracks();

    void setTeams();
    Map<String, Team> getTeams();

    void setNations();
    Map<String, Nation> getNations();

    void setDrivers();
    Map<String, Driver> getDrivers();

    void insertDriver(int driverId, String driverName, String nation, String team);

    void insertTeam(String team);

    void insertNation(String nation);

    void insertTrack(String track);
}
