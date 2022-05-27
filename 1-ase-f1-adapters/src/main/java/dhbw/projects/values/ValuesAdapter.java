package dhbw.projects.values;

import dhbw.projects.ObjectOutput;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.nation.Nation;
import dhbw.projects.data.team.Team;
import dhbw.projects.data.track.Track;

import java.util.Map;

public class ValuesAdapter {

    private final ValuesService valuesService;

    public ValuesAdapter() {
        this.valuesService = new ValuesService();
    }

    public void insertDriver(int driverId, String driverName, String driverNation, String driverTeam){
        if(!validateDriverId(driverId) || !validateString(driverName) ||
                !validateString(driverNation) || !validateString(driverTeam)){
            throw new IllegalArgumentException();
        }
        this.valuesService.insertDriver(driverId, driverName, driverNation, driverTeam);
    }

    public String sortedOutput(Map<String, String> strings, String outputName){
        ObjectOutput objectOutput = new ObjectOutput(strings, outputName);
        return objectOutput.getOutput();
    }

    private boolean validateDriverId(int id){
        if (id < 1 || id > 99) {
            return false;
        }
        return true;
    }

    private boolean validateString(String string){
        return string.length() > 0;
    }

    public void insertTeam(String team) {
        if(!validateString(team)){
            throw new IllegalArgumentException();
        }
        this.valuesService.insertTeam(team);
    }

    public Map<String, Team> getTeams() {
        return this.valuesService.getTeams();
    }

    public void insertNation(String nation) {
        if(!validateString(nation)){
            throw new IllegalArgumentException();
        }
        this.valuesService.insertNation(nation);
    }

    public Map<String, Nation> getNations() {
        return this.valuesService.getNations();
    }

    public void insertTrack(String track) {
        if(!validateString(track)){
            throw new IllegalArgumentException();
        }
        this.valuesService.insertTrack(track);
    }

    public Map<String, Track> getTracks(){
        return this.valuesService.getTracks();
    }

    public Map<String, Driver> getDrivers() {
        return this.valuesService.getDrivers();
    }

    public Map<String, String> getTrackNames() {
        return this.valuesService.getTrackNames();
    }

    public Map<String, String>  getNationalities() {
        return this.valuesService.getNationalities();
    }

    public Map<String, String>  getTeamNames() {
        return this.valuesService.getTeamNames();
    }

    public Map<String, String>  getDriverNames() {
        return this.valuesService.getDriverNames();
    }
}
