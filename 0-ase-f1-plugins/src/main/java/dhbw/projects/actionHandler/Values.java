package dhbw.projects.actionHandler;

import dhbw.projects.DriverRepository;
import dhbw.projects.NationRepository;
import dhbw.projects.TeamRepository;
import dhbw.projects.TrackRepository;
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

    private List<String> trackNames = new ArrayList<>();
    private List<String> nationalities = new ArrayList<>();
    private List<String> teamNames = new ArrayList<>();
    private List<String> driverNames = new ArrayList<>();

    private List<List<String>> allValues = new ArrayList<>();
    private List<String> headers = new ArrayList<>();

    public Values(){
        this.tracks = loadTracks();
        this.nations = loadNations();
        this.teams = loadTeams();
        this.drivers = loadDrivers(teams, nations);

        headers.add("Alle Strecken");
        headers.add("Alle Nationalitäten");
        headers.add("Alle Teams");
        headers.add("Alle Fahrer");

        allValues.add(trackNames);
        allValues.add(nationalities);
        allValues.add(teamNames);
        allValues.add(driverNames);

    }

    public List<List<String>> getAllValues() {
        return allValues;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public TrackRepository getTracks() {
        return tracks;
    }

    public List<Driver> getDrivers() {
        return drivers.getAll();
    }

    public void sortedOutput(List<String> strings, String outputName) {
        StringBuilder header = new StringBuilder(outputName);
        while (header.length() < 123) {
            header = new StringBuilder("=" + header + "=");
        }
        if (header.length() == 123) {
            header.append("=");
        }
        System.out.println(header);

        double value = (strings.size()) / 5.0;
        int maxColumn = (int) Math.floor(value) + 1;
        int endObj = strings.size() % 5;

        for (int i = 0; i < (Math.min(strings.size(), 5)); i++) {
            if(i == endObj){
                maxColumn--;
            }
            for (int j = 0; j < maxColumn; j++) {
                System.out.printf("%5s", "[" + (i + 1 + (5 * j)) + "] ");
                System.out.printf("%-21s", strings.get(i + (5 * j)));
            }
            if (i < (Math.min(strings.size(), 5) - 1)) {
                System.out.println("");
            }
        }
        System.out.println("\n" + String.join("", Collections.nCopies(124, "=")));
    }


    private TrackRepository loadTracks(){

        TrackRepository repository = new TrackRepositoryImpl();

        String[] trackNamesStr = {"Bahrain", "Imola", "Portugal", "Spain", "Monaco", "Azerbaijan", "Canada", "France",
            "Austria", "Great Britain", "Hungary", "Belgium", "Netherlands", "Italy", "Russia", "Singapore", "Japan",
                "USA", "Mexico", "Brazil", "Australia", "Saudi Arabia", "Abu Dhabi", "China"};

        for(int i = 0; i < trackNamesStr.length; i++){
            repository.insert(new Track(UUID.randomUUID(), trackNamesStr[i]));
        }

        List<String> trackNames = new ArrayList<>();

        for (Track track: repository.getAll()) {
            trackNames.add(track.toString());
        }

        this.trackNames = trackNames;
        return repository;
    }

    private NationRepository loadNations(){

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

        for(int i = 0; i < nationalitiesStr.length; i++){
            repository.insert(new Nation(UUID.randomUUID(), nationalitiesStr[i][0], nationalitiesStr[i][1]));
        }

        List<String> nationalities = new ArrayList<>();

        for (Nation nation: repository.getAll()) {
            nationalities.add(nation.getShortName() + " (" + nation.getFullName() + ")");
        }

        this.nationalities = nationalities;
        return repository;
    }

    private TeamRepository loadTeams(){

        TeamRepository repository = new TeamRepositoryImpl();

        String[] teamNamesStr = {"Mercedes-AMG Petronas", "Ferrari", "Red Bull Racing", "McLaren", "Alpine",
                "AlphaTauri", "Aston Martin", "Alfa Romeo Racing", "Haas", "Williams"};

        for(int i = 0; i < teamNamesStr.length; i++){
            repository.insert(new Team(UUID.randomUUID(), teamNamesStr[i]));
        }

        List<String> teamNames = new ArrayList<>();

        for (Team team: repository.getAll()) {
            teamNames.add(team.toString());
        }

        this.teamNames = teamNames;
        return repository;
    }

    private DriverRepository loadDrivers(TeamRepository teams, NationRepository nations){
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

        for (Driver driver: driverInfos){
            repository.insert(driver);
        }

        List<String> driverNames = new ArrayList<>();

        for (Driver driver: repository.getAll()) {
            driverNames.add(driver.getName());
        }

        this.driverNames = driverNames;

        return repository;

    }


}
