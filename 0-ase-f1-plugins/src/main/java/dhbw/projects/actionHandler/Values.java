package dhbw.projects.actionHandler;

import dhbw.projects.*;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.driver.DriverId;
import dhbw.projects.data.nation.Nation;
import dhbw.projects.data.team.Team;
import dhbw.projects.data.track.Track;
import dhbw.projects.driver.DriverRepositoryImpl;
import dhbw.projects.nation.NationRepositoryImpl;
import dhbw.projects.team.TeamRepositoryImpl;
import dhbw.projects.track.TrackRepositoryImpl;

import java.util.*;

public class Values {

    private final TrackRepository tracks;
    private final NationRepository nations;
    private final TeamRepository teams;
    private final DriverRepository drivers;

    private Map<String, String> trackNames = new HashMap<>();
    private Map<String, Track> allTracks = new HashMap<>();
    private Map<String, String> nationalities = new HashMap<>();
    private Map<String, Nation> allNations = new HashMap<>();
    private Map<String, String> teamNames = new HashMap<>();
    private Map<String, Team> allTeams = new HashMap<>();
    private Map<String, String> driverNames = new HashMap<>();
    private Map<String, Driver> allDrivers = new HashMap<>();

    private List<String> headers = new ArrayList<>();

    private final ValuesService valuesService;

    public Values() {
        this.tracks = loadTracks();
        this.nations = loadNations();
        this.teams = loadTeams();
        this.drivers = loadDrivers(teams, nations);

    }

    public void sortedOutput(Map<String, String> strings, String outputName){
        ObjectOutput objectOutput = new ObjectOutput(strings, outputName);
        System.out.print(objectOutput.getOutput());
    }

    public Map<String, String> getTrackNames() {
        return trackNames;
    }

    public Map<String, Track> getAllTracks() {
        return allTracks;
    }

    private TrackRepository loadTracks() {

        TrackRepository repository = new TrackRepositoryImpl();

        String[] trackNamesStr = {"Bahrain", "Imola", "Portugal", "Spain", "Monaco", "Azerbaijan", "Canada", "France",
                "Austria", "Great Britain", "Hungary", "Belgium", "Netherlands", "Italy", "Russia", "Singapore", "Japan",
                "USA", "Mexico", "Brazil", "Australia", "Saudi Arabia", "Abu Dhabi", "China"};

        for (int i = 0; i < trackNamesStr.length; i++) {
            repository.insert(new Track(UUID.randomUUID(), trackNamesStr[i]));
        }

        Map<String, String> trackNames = new HashMap<>();
        Map<String, Track> allTracks = new HashMap<>();

        for (int i = 0; i < repository.getAll().size(); i++) {
            trackNames.put(String.valueOf(i), repository.getAll().get(i).toString());
            allTracks.put(String.valueOf(i), repository.getAll().get(i));
        }

        this.trackNames = trackNames;
        this.allTracks = allTracks;
        return repository;
    }

    private NationRepository loadNations() {

        NationRepository repository = new NationRepositoryImpl();

        String[][] nationalitiesStr = {
                {"AUS", "Australia"},
                {"CAN", "Canada"},
                {"ESP", "Spain"},
                {"FIN", "Finland"},
                {"FRA", "France"},
                {"GBR", "Great Britain"},
                {"GER", "Germany"},
                {"ITA", "Italy"},
                {"JPN", "Japan"},
                {"MEX", "Mexico"},
                {"MON", "Monaco"},
                {"NED", "Netherlands"},
                {"RUS", "Russia"}};

        for (String[] strings : nationalitiesStr) {
            repository.insert(new Nation(UUID.randomUUID(), strings[0], strings[1]));
        }

        Map<String, String> nationalities = new HashMap<>();
        Map<String, Nation> allNations = new HashMap<>();

        for (int i = 0; i < repository.getAll().size(); i++) {
            nationalities.put(String.valueOf(i), repository.getAll().get(i).getShortName() + " (" + repository.getAll().get(i).getFullName() +")");
            allNations.put(String.valueOf(i), repository.getAll().get(i));
        }


        this.nationalities = nationalities;
        this.allNations = allNations;
        return repository;
    }

    private TeamRepository loadTeams() {

        TeamRepository repository = new TeamRepositoryImpl();

        String[] teamNamesStr = {
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

        for (int i = 0; i < teamNamesStr.length; i++) {
            repository.insert(new Team(UUID.randomUUID(), teamNamesStr[i]));
        }

        HashMap<String, String> teamNames = new HashMap<>();
        HashMap<String, Team> allTeams = new HashMap<>();

        for (int i = 0; i < repository.getAll().size(); i++) {
            teamNames.put(String.valueOf(i), repository.getAll().get(i).toString());
            allTeams.put(String.valueOf(i), repository.getAll().get(i));
        }

        this.teamNames = teamNames;
        this.allTeams = allTeams;
        return repository;
    }

    private DriverRepository loadDrivers(TeamRepository teams, NationRepository nations) {
        DriverRepository repository = new DriverRepositoryImpl();
        List<Team> allTeams = teams.getAll();
        List<Nation> allNations = nations.getAll();

        Driver[] driverInfos = {
                new Driver(new DriverId(33), "Max Verstappen", allNations.get(11), allTeams.get(2)),
                new Driver(new DriverId(44), "Lewis Hamilton", allNations.get(5), allTeams.get(0)),
                new Driver(new DriverId(77), "Valtteri Bottas", allNations.get(3), allTeams.get(0)),
                new Driver(new DriverId(14), "Fernando Alonso", allNations.get(2), allTeams.get(4)),
                new Driver(new DriverId(5), "Sebastian Vettel", allNations.get(6), allTeams.get(6)),
                new Driver(new DriverId(16), "Charles Leclerc", allNations.get(10), allTeams.get(1)),
                new Driver(new DriverId(4), "Lando Norris", allNations.get(5), allTeams.get(3)),
                new Driver(new DriverId(55), "Carlos Sainz", allNations.get(2), allTeams.get(1)),
                new Driver(new DriverId(3), "Daniel Ricciardo", allNations.get(0), allTeams.get(3)),
                new Driver(new DriverId(31), "Esteban Ocon", allNations.get(4), allTeams.get(4)),
                new Driver(new DriverId(10), "Pierre Gasly", allNations.get(4), allTeams.get(5)),
                new Driver(new DriverId(22), "Yuki Tsunoda", allNations.get(8), allTeams.get(5)),
                new Driver(new DriverId(11), "Sergio Perez", allNations.get(9), allTeams.get(2)),
                new Driver(new DriverId(18), "Lance Stroll", allNations.get(1), allTeams.get(6)),
                new Driver(new DriverId(7), "Kimi Raikkonen", allNations.get(3), allTeams.get(7)),
                new Driver(new DriverId(99), "Antonio Giovinazzi", allNations.get(7), allTeams.get(7)),
                new Driver(new DriverId(9), "Nikita Mazepin", allNations.get(12), allTeams.get(8)),
                new Driver(new DriverId(47), "Mick Schumacher", allNations.get(6), allTeams.get(8)),
                new Driver(new DriverId(63), "George Russell", allNations.get(5), allTeams.get(9)),
                new Driver(new DriverId(6), "Nicholas Latifi", allNations.get(1), allTeams.get(9))};

        for (Driver driver : driverInfos) {
            repository.insert(driver);
        }

        HashMap<String, String> driverNames = new HashMap<>();
        HashMap<String, Driver> allDrivers = new HashMap<>();

        for (int i = 0; i < repository.getAll().size(); i++) {
            driverNames.put(String.valueOf(i), repository.getAll().get(i).getName());
            allDrivers.put(String.valueOf(i), repository.getAll().get(i));
        }

        this.driverNames = driverNames;
        this.allDrivers = allDrivers;

        return repository;

    }

    public Map<String, String> getNationalities() {
        return nationalities;
    }

    public Map<String, String> getTeamNames() {
        return teamNames;
    }

    public Map<String, String> getDriverNames() {
        return driverNames;
    }

    public Map<String, Driver> getAllDrivers() {
        return allDrivers;
    }
}


