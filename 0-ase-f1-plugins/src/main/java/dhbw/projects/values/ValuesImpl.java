package dhbw.projects.values;

import dhbw.projects.*;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.driver.DriverId;
import dhbw.projects.data.nation.Nation;
import dhbw.projects.data.team.Team;
import dhbw.projects.data.track.Track;
import dhbw.projects.driver.DriverRepositoryImpl;
import dhbw.projects.nation.NationRepositoryImpl;
import dhbw.projects.track.TrackRepositoryImpl;

import java.util.*;

public class ValuesImpl implements ValuesRepository {

    private final ValuesAdapter valuesAdapter;

    public ValuesImpl() {
        this.valuesAdapter = new ValuesAdapter();
        setTracks();
        setNations();
        setTeams();
        setDrivers();
    }

    public ValuesAdapter getValuesAdapter() {
        return valuesAdapter;
    }

    @Override
    public void setTracks() {
        String[] tracks = {"Bahrain", "Imola", "Portugal", "Spain", "Monaco", "Azerbaijan", "Canada", "France",
                "Austria", "Great Britain", "Hungary", "Belgium", "Netherlands", "Italy", "Russia", "Singapore", "Japan",
                "USA", "Mexico", "Brazil", "Australia", "Saudi Arabia", "Abu Dhabi", "China"};
        for (String track : tracks) {
            this.valuesAdapter.insertTrack(track);
        }
    }

    @Override
    public Map<String, Track> getTracks() {
        return this.valuesAdapter.getTracks();
    }

    public Map<String, String> getTrackNames(){
        return this.valuesAdapter.getTrackNames();
    }

    @Override
    public void setNations() {
        String[] nations = {"Australia", "Canada", "Spain", "Finland", "France", "Great Britain", "Germany", "Italy",
                "Japan", "Mexico", "Monaco", "Netherlands", "Russia"};
        for (String nation : nations) {
            this.valuesAdapter.insertNation(nation);
        }
    }

    @Override
    public Map<String, Nation> getNations() {
        return this.valuesAdapter.getNations();
    }

    @Override
    public void setTeams() {
        String[] teams = {
                "Mercedes-AMG Petronas",
                "Ferrari",
                "Red Bull Racing",
                "McLaren",
                "Alpine",
                "AlphaTauri",
                "Aston Martin",
                "Alfa Romeo Racing",
                "Haas",
                "Williams"};
        for (String team : teams) {
            this.valuesAdapter.insertTeam(team);
        }

    }

    @Override
    public Map<String, Team> getTeams() {
        return this.valuesAdapter.getTeams();
    }

    @Override
    public void setDrivers() {
        int[] driverIds = {33, 44, 77, 14, 5, 16, 4, 55, 3, 31, 10, 22, 11, 18, 7, 99, 9, 47, 63, 6};
        String[] driverNames = {"Max Verstappen", "Lewis Hamilton", "Valtteri Bottas", "Fernando Alonso",
                "Sebastian Vettel", "Charles Leclerc", "Lando Norris", "Carlos Sainz", "Daniel Ricciardo",
                "Esteban Ocon", "Pierre Gasly", "Yuki Tsunoda", "Sergio Perez", "Lance Stroll", "Kimi Raikkonen",
                "Antonio Giovinazzi", "Nikita Mazepin", "Mick Schumacher", "George Russell", "Nicholas Latifi"};
        String[] driverNations = {
                "Netherlands",
                "Great Britain",
                "Finland",
                "Spain",
                "Germany",
                "Monaco",
                "Great Britain",
                "Spain",
                "Australia",
                "France",
                "France",
                "Japan",
                "Mexico",
                "Canada",
                "Finland",
                "Italy",
                "Russia",
                "Germany",
                "Great Britain",
                "Canada"};
        String[] driverTeams = {
                "Red Bull Racing",
                "Mercedes-AMG Petronas",
                "Mercedes-AMG Petronas",
                "Alpine",
                "Aston Martin",
                "Ferrari",
                "McLaren",
                "Ferrari",
                "McLaren",
                "Alpine",
                "AlphaTauri",
                "AlphaTauri",
                "Red Bull Racing",
                "Aston Martin",
                "Alfa Romeo Racing",
                "Alfa Romeo Racing",
                "Haas",
                "Haas",
                "Williams",
                "Williams"};
        for (int i = 0; i < driverNames.length; i++) {
            this.valuesAdapter.insertDriver(driverIds[i], driverNames[i], driverNations[i], driverTeams[i]);
        }

    }

    @Override
    public Map<String, Driver> getDrivers() {
        return this.valuesAdapter.getDrivers();
    }

    public Map<String, String> getNationalities() {
        return this.valuesAdapter.getNationalities();
    }

    public Map<String, String> getTeamNames() {
        return this.valuesAdapter.getTeamNames();
    }

    public Map<String, String> getDriverNames() {
        return this.valuesAdapter.getDriverNames();
    }
}


