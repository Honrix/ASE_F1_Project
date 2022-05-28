package dhbw.projects.values;

import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.nation.Nation;
import dhbw.projects.data.team.Team;
import dhbw.projects.data.track.Track;

import java.util.Collections;
import java.util.Map;

public class ValuesAdapter {

    private final ValuesService valuesService;
    private final int width = 123;
    private final String endSeperator = ("\n" + String.join("", Collections.nCopies(width+1, "=")) + "\n");

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

    public ValuesService getValuesService() {
        return valuesService;
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

    public String sortedOutput(Map<String, String> strings, String outputName) {
        String output = getHeader(outputName);
        output = getBody(output, strings);
        output += endSeperator;
        return output;
    }

    private String getHeader(String headerTitle){
        StringBuilder header = new StringBuilder(headerTitle);
        while (header.length() < width) {
            header = new StringBuilder("=" + header + "=");
        }
        if (header.length() == width) {
            header.append("=");
        }
        return header +"\n";
    }

    private String getBody(String output, Map<String, String> strings){
        double value = (strings.size()) / 5.0;
        int maxColumn = (int) Math.floor(value) + 1;
        int endObj = strings.size() % 5;

        for (int i = 0; i < (Math.min(strings.size(), 5)); i++) {
            if (i == endObj) {
                maxColumn--;
            }
            for (int j = 0; j < maxColumn; j++) {
                output += String.format("%5s", "[" + (i + 1 + (5 * j)) + "] ");
                output += String.format("%-21s", strings.get(String.valueOf(i + 1 + (5 * j))));
            }
            if (i < (Math.min(strings.size(), 5) - 1)) {
                output += "\n";
            }
        }
        return output;
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
