package dhbw.projects.values;

import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.driver.DriverId;
import dhbw.projects.data.nation.Nation;
import dhbw.projects.data.team.Team;
import dhbw.projects.data.track.Track;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ValuesService {

    private final Map<String, Driver> drivers  = new HashMap<>();
    private final Map<String, Track> tracks  = new HashMap<>();
    private final Map<String, Team> teams  = new HashMap<>();
    private final Map<String, Nation> nations  = new HashMap<>();

    public ValuesService(){

    }


    public void insertDriver(int driverId, String driverName, String driverNation, String driverTeam) {
        DriverId newDriverId = new DriverId(driverId);
        Nation nation = getNationByName(driverNation);
        Team team = getTeamByName(driverTeam);
        this.drivers.put(String.valueOf(this.drivers.size()), new Driver(newDriverId, driverName, nation, team));

    }

    public void insertTeam(String teamName){
        this.teams.put(String.valueOf(teams.size()), new Team(UUID.randomUUID(), teamName));
    }

    public void insertNation(String nationName) {
        this.nations.put(String.valueOf(nations.size()), new Nation(UUID.randomUUID(), nationName));
    }

    public void insertTrack(String trackName) {
        this.tracks.put(String.valueOf(tracks.size()), new Track(UUID.randomUUID(), trackName));
    }

    private Nation getNationByName(String nationName){
        for (int i = 0; i < this.nations.size(); i++) {
            if(this.nations.get(String.valueOf(i)).getName().equals(nationName)){
                return this.nations.get(String.valueOf(i));
            }
        }
        return null;
    }

    private Team getTeamByName(String teamName){
        for (int i = 0; i < this.teams.size(); i++) {
            if(this.teams.get(String.valueOf(i)).toString().equals(teamName)){
                return this.teams.get(String.valueOf(i));
            }
        }
        return null;
    }

    public Map<String, Team> getTeams() {
        return this.teams;
    }

    public Map<String, Nation> getNations() {
        return this.nations;
    }

    public Map<String, Driver> getDrivers() {
        return drivers;
    }

    public Map<String, Track> getTracks() {
        return tracks;
    }

    public Map<String, String> getTrackNames() {
        Map<String, String> trackNames = new HashMap<>();
        for (int i = 0; i < this.tracks.size(); i++) {
            trackNames.put(String.valueOf(i), this.tracks.get(String.valueOf(i)).toString());
        }
        return trackNames;
    }

    public Map<String, String> getNationalities() {
        Map<String, String> nationalities = new HashMap<>();
        for (int i = 0; i < this.nations.size(); i++) {
            nationalities.put(String.valueOf(i), this.nations.get(String.valueOf(i)).getName());
        }
        return nationalities;
    }

    public Map<String, String> getTeamNames() {
        Map<String, String> teamNames = new HashMap<>();
        for (int i = 0; i < this.teams.size(); i++) {
            teamNames.put(String.valueOf(i), this.teams.get(String.valueOf(i)).toString());
        }
        return teamNames;
    }

    public Map<String, String> getDriverNames() {
        Map<String, String> driverNames = new HashMap<>();
        for (int i = 0; i < this.drivers.size(); i++) {
            driverNames.put(String.valueOf(i), this.drivers.get(String.valueOf(i)).getName());
        }
        return driverNames;
    }
}
