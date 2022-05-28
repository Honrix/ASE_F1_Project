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

    private final Map<String, Driver> drivers;
    private final Map<String, Track> tracks;
    private final Map<String, Team> teams;
    private final Map<String, Nation> nations;

    public ValuesService(){
        this.drivers = new HashMap<>();
        this.tracks = new HashMap<>();
        this.teams = new HashMap<>();
        this.nations = new HashMap<>();
    }


    public void insertDriver(int driverId, String driverName, String driverNation, String driverTeam) {
        DriverId newDriverId = new DriverId(driverId);
        Nation nation = getNationByName(driverNation);
        Team team = getTeamByName(driverTeam);
        if(this.drivers.isEmpty()) {
            this.drivers.put("1", new Driver(newDriverId, driverName, nation, team));
        } else {
            this.drivers.put(String.valueOf(this.drivers.size()+1), new Driver(newDriverId, driverName, nation, team));
        }

    }

    public void insertTeam(String teamName){
        if(teams.isEmpty()) {
            this.teams.put("1", new Team(UUID.randomUUID(), teamName));
        } else {
            this.teams.put(String.valueOf(teams.size()+1), new Team(UUID.randomUUID(), teamName));

        }
    }

    public void insertNation(String nationName) {
        if(nations.isEmpty()){
            this.nations.put("1", new Nation(UUID.randomUUID(), nationName));
        } else {
            this.nations.put(String.valueOf(nations.size()+1), new Nation(UUID.randomUUID(), nationName));
        }
    }

    public void insertTrack(String trackName) {
        if(tracks.isEmpty()){
            this.tracks.put("1", new Track(UUID.randomUUID(), trackName));
        } else {
            this.tracks.put(String.valueOf(tracks.size()+1), new Track(UUID.randomUUID(), trackName));
        }
    }

    public Nation getNationByName(String nationName){
        for (int i = 0; i < this.nations.size(); i++) {
            if(this.nations.get(String.valueOf(i+1)).getName().equals(nationName)){
                return this.nations.get(String.valueOf(i+1));
            }
        }
        return null;
    }

    public Track getTrackById(String trackName){
        if(this.tracks.containsKey(trackName)){
            return this.tracks.get(trackName);
        }
        return null;
    }

    public Team getTeamByName(String teamName){
        for (int i = 0; i < this.teams.size(); i++) {
            if(this.teams.get(String.valueOf(i+1)).toString().equals(teamName)){
                return this.teams.get(String.valueOf(i+1));
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
            trackNames.put(String.valueOf(i + 1), this.tracks.get(String.valueOf(i + 1)).toString());
        }
        return trackNames;
    }

    public Map<String, String> getNationalities() {
        Map<String, String> nationalities = new HashMap<>();
        for (int i = 0; i < this.nations.size(); i++) {
            nationalities.put(String.valueOf(i + 1), this.nations.get(String.valueOf(i + 1)).getName());
        }
        return nationalities;
    }

    public Map<String, String> getTeamNames() {
        Map<String, String> teamNames = new HashMap<>();
        for (int i = 0; i < this.teams.size(); i++) {
            teamNames.put(String.valueOf(i + 1), this.teams.get(String.valueOf(i + 1)).toString());
        }
        return teamNames;
    }

    public Map<String, String> getDriverNames() {
        Map<String, String> driverNames = new HashMap<>();
        for (int i = 0; i < this.drivers.size(); i++) {
            driverNames.put(String.valueOf(i + 1), this.drivers.get(String.valueOf(i + 1)).getName());
        }
        return driverNames;
    }
}
