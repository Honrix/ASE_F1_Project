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


}
