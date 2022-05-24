package dhbw.projects;

import dhbw.projects.Driver.DriverStats;
import dhbw.projects.Driver.DriverStatsService;
import dhbw.projects.data.Date;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.driver.DriverId;
import dhbw.projects.data.nation.Nation;
import dhbw.projects.data.team.Team;
import dhbw.projects.data.track.Track;
import dhbw.projects.driver.DriverRepositoryImpl;
import dhbw.projects.nation.NationRepositoryImpl;
import dhbw.projects.newRace.RaceResult;
import dhbw.projects.race.RaceResultOutput;
import dhbw.projects.race.RaceResultResource;
import dhbw.projects.team.TeamRepositoryImpl;
import dhbw.projects.track.TrackRepositoryImpl;
import dhbw.projects.user.IOController;
import dhbw.projects.data.inputOutput.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


public class Main {

    public static void main(String[] args) throws Exception {

        TrackRepository tracks = new TrackRepositoryImpl();
        tracks = loadTracks();

        NationRepository nations = new NationRepositoryImpl();
        nations = loadNations();

        TeamRepository teams = new TeamRepositoryImpl();
        teams = loadTeams();

        DriverRepository drivers = loadDrivers(teams, nations);

        List<String> trackNames = new ArrayList<>();
        for (Track track: tracks.getAll()){
            trackNames.add(track.toString());
        }
        List<String> teamNames = new ArrayList<>();
        for (Team team: teams.getAll()){
            teamNames.add(team.toString());
        }
        List<String> driverNames = new ArrayList<>();
        for (Driver driver: drivers.getAll()){
            driverNames.add(driver.getName());
        }

        System.out.println("");

        DriverStats driverStats1 = new DriverStats(drivers.getById(new DriverId(33)), 3, 1, 90.000);
        DriverStats driverStats2 = new DriverStats(drivers.getById(new DriverId(44)), 1, 3, 95.333);
        DriverStats driverStats3 = new DriverStats(drivers.getById(new DriverId(5)), 5, 4, 95.323);
        DriverStats driverStats4 = new DriverStats(drivers.getById(new DriverId(16)), 4, 2, 91.335);

        List<DriverStats> stats = new ArrayList<>();
        stats.add(driverStats1);
        stats.add(driverStats2);
        stats.add(driverStats3);
        stats.add(driverStats4);

        DriverStatsService service = new DriverStatsService(stats);

        RaceResult race1 = new RaceResult(
                tracks.getAll().get(0),
                service.getDriverStats(),
                50,
                new Date("20220524"),
                UUID.randomUUID()
        );
        RaceResultResource raceResultResource = new RaceResultResource(race1);
        RaceResultOutput raceResultOutput = new RaceResultOutput(raceResultResource);

        IOController newDialogue = new IOController(UUID.randomUUID());
        Message helloMessage = new Message("Willkommen zu diesem Test", UUID.randomUUID());
        newDialogue.createNewMessage(helloMessage);
        Message auswahl = new Message("Was willst du machen? \n" + "[1] Neues Rennen anlegen  [2] Bestehendes Rennen anschauen", UUID.randomUUID());
                newDialogue.createNewMessage(auswahl);
        newDialogue.newInput();
        System.out.println(newDialogue.getLastMessage().getMessageText());

        if(newDialogue.getLastMessage().getMessageText().equals("1")){
            sortedOutput(trackNames, "Alle Tracks");
            sortedOutput(teamNames, "Alle Teams");
            sortedOutput(driverNames, "Alle Fahrer");

        } else if (newDialogue.getLastMessage().getMessageText().equals("2")){
            newDialogue.createNewMessage(new Message(raceResultOutput.toString(), UUID.randomUUID()));
        } else {
            System.out.println("Falsche Eingabe!");
        }

    }

    public static void sortedOutput(List<String> strings, String outputName){
        int x = 0;
        int y = 0;
        StringBuilder header = new StringBuilder(outputName);
        while (header.length() < 123){
            header = new StringBuilder("_" + header + "_");
        }
        if(header.length() == 123){
            header.append("_");
        }
        System.out.println(header);

        int maxColumn = Math.round((strings.size()-1)/5)+1;

        for (int i = 0; i < strings.size(); i++) {
            if(i>0 && i % maxColumn == 0){
                x = 0;
                y++;
                System.out.println("");
            }
            System.out.printf("%-25s", "[" + (y+1+(5*x)) + "] " + strings.get(y+(5*x)));
            x++;
        }
        System.out.println("\n" + String.join("", Collections.nCopies(124, "-")));

    }

    public static TrackRepository loadTracks(){

        TrackRepository repository = new TrackRepositoryImpl();

        Track bahrain = new Track(UUID.randomUUID(), "Bahrain");
        Track imola = new Track(UUID.randomUUID(), "Imola");
        Track portugal = new Track(UUID.randomUUID(), "Portugal");
        Track spain = new Track(UUID.randomUUID(), "Spain");
        Track monaco = new Track(UUID.randomUUID(), "Monaco");
        Track azerbaijan = new Track(UUID.randomUUID(), "Azerbaijan");
        Track france = new Track(UUID.randomUUID(), "France");
        Track austria = new Track(UUID.randomUUID(), "Austria");
        Track greatBritain = new Track(UUID.randomUUID(), "Great Britain");
        Track hungary = new Track(UUID.randomUUID(), "Hungary");
        Track belgium = new Track(UUID.randomUUID(), "Belgium");
        Track netherlands = new Track(UUID.randomUUID(), "Netherlands");
        Track italy = new Track(UUID.randomUUID(), "Italy");
        Track russia = new Track(UUID.randomUUID(), "Russia");
        Track japan = new Track(UUID.randomUUID(), "Japan");
        Track usa = new Track(UUID.randomUUID(), "USA");
        Track mexico = new Track(UUID.randomUUID(), "Mexico");
        Track brazil = new Track(UUID.randomUUID(), "Brazil");
        Track australia = new Track(UUID.randomUUID(), "Australia");
        Track saudiarabia = new Track(UUID.randomUUID(), "Saudiarabia");
        Track abuDhabi = new Track(UUID.randomUUID(), "Abu Dhabi");
        Track canada = new Track(UUID.randomUUID(), "Canada");
        Track china = new Track(UUID.randomUUID(), "China");
        Track singapore = new Track(UUID.randomUUID(), "Singapore");

        repository.insert(bahrain);
        repository.insert(imola);
        repository.insert(portugal);
        repository.insert(spain);
        repository.insert(monaco);
        repository.insert(azerbaijan);
        repository.insert(france);
        repository.insert(austria);
        repository.insert(greatBritain);
        repository.insert(hungary);
        repository.insert(belgium);
        repository.insert(netherlands);
        repository.insert(italy);
        repository.insert(russia);
        repository.insert(japan);
        repository.insert(usa);
        repository.insert(mexico);
        repository.insert(brazil);
        repository.insert(australia);
        repository.insert(saudiarabia);
        repository.insert(abuDhabi);
        repository.insert(canada);
        repository.insert(china);
        repository.insert(singapore);

        return repository;
    }

    public static NationRepository loadNations(){

        NationRepository repository = new NationRepositoryImpl();

        Nation aus = new Nation(UUID.randomUUID(), "AUS", "Australia");
        Nation can = new Nation(UUID.randomUUID(), "CAN", "Canada");
        Nation esp = new Nation(UUID.randomUUID(), "ESP", "Spain");
        Nation fin = new Nation(UUID.randomUUID(), "FIN", "Finland");
        Nation fra = new Nation(UUID.randomUUID(), "FRA", "France");
        Nation gbr = new Nation(UUID.randomUUID(), "GBR", "Great Britain");
        Nation ger = new Nation(UUID.randomUUID(), "GER", "Germany");
        Nation ita = new Nation(UUID.randomUUID(), "ITA", "Italy");
        Nation jpn = new Nation(UUID.randomUUID(), "JPN", "Japan");
        Nation mex = new Nation(UUID.randomUUID(), "MEX", "Mexico");
        Nation mon = new Nation(UUID.randomUUID(), "MON", "Monaco");
        Nation ned = new Nation(UUID.randomUUID(), "NED", "Netherlands");
        Nation rus = new Nation(UUID.randomUUID(), "RUS", "Russia");

        repository.insert(aus);     // 0
        repository.insert(can);     //
        repository.insert(esp);     // 2
        repository.insert(fin);     //
        repository.insert(fra);     // 4
        repository.insert(gbr);     //
        repository.insert(ger);     // 6
        repository.insert(ita);     //
        repository.insert(jpn);     // 8
        repository.insert(mex);     //
        repository.insert(mon);     // 10
        repository.insert(ned);     //
        repository.insert(rus);     // 12

        return repository;
    }

    public static TeamRepository loadTeams(){

        TeamRepository repository = new TeamRepositoryImpl();

        Team MERCEDES = new Team(UUID.randomUUID(), "Mercedes-AMG Petronas");
        Team FERRARI = new Team(UUID.randomUUID(), "Ferrari");
        Team RED_BULL = new Team(UUID.randomUUID(), "Red Bull Racing");
        Team MCLAREN = new Team(UUID.randomUUID(), "McLaren");
        Team ALPINE = new Team(UUID.randomUUID(), "Alpine");
        Team ALPHATAURI = new Team(UUID.randomUUID(), "AlphaTauri");
        Team ASTON_MARTIN = new Team(UUID.randomUUID(), "Aston Martin");
        Team ALFA_ROMEO = new Team(UUID.randomUUID(), "Alfa Romeo Racing");
        Team HAAS = new Team(UUID.randomUUID(), "Haas");
        Team WILLIAMS = new Team(UUID.randomUUID(), "Williams");

        repository.insert(MERCEDES);        // 0
        repository.insert(FERRARI);         //
        repository.insert(RED_BULL);        // 2
        repository.insert(MCLAREN);         //
        repository.insert(ALPINE);          // 4
        repository.insert(ALPHATAURI);      //
        repository.insert(ASTON_MARTIN);    // 6
        repository.insert(ALFA_ROMEO);      //
        repository.insert(HAAS);            // 8
        repository.insert(WILLIAMS);        //

        return repository;
    }

    public static DriverRepository loadDrivers(TeamRepository teams, NationRepository nations){
        DriverRepository repository = new DriverRepositoryImpl();
        List<Team> allTeams = teams.getAll();
        List<Nation> allNations = nations.getAll();

        Driver verstappen = new Driver(new DriverId(33), "Max Verstappen", allNations.get(11), allTeams.get(2));
        Driver hamilton = new Driver(new DriverId(44), "Lewis Hamilton", allNations.get(5), allTeams.get(0));
        Driver bottas = new Driver(new DriverId(77), "Valtteri Bottas", allNations.get(3), allTeams.get(0));
        Driver alonso = new Driver(new DriverId(14), "Fernando Alonso", allNations.get(2), allTeams.get(4));
        Driver vettel = new Driver(new DriverId(5), "Sebastian Vettel", allNations.get(6), allTeams.get(6));
        Driver leclerc = new Driver(new DriverId(16), "Charles Leclerc", allNations.get(10), allTeams.get(1));
        Driver norris = new Driver(new DriverId(4), "Lando Norris", allNations.get(5), allTeams.get(3));
        Driver sainz = new Driver(new DriverId(55), "Carlos Sainz", allNations.get(2), allTeams.get(1));
        Driver ricciardo = new Driver(new DriverId(3), "Daniel Ricciardo", allNations.get(0), allTeams.get(3));
        Driver ocon = new Driver(new DriverId(31), "Esteban Ocon", allNations.get(4), allTeams.get(4));
        Driver gasly = new Driver(new DriverId(10), "Pierre Gasly", allNations.get(4), allTeams.get(5));
        Driver tsunoda = new Driver(new DriverId(22), "Yuki Tsunoda", allNations.get(8), allTeams.get(5));
        Driver perez = new Driver(new DriverId(11), "Sergio Perez", allNations.get(9), allTeams.get(2));
        Driver stroll = new Driver(new DriverId(18), "Lance Stroll", allNations.get(1), allTeams.get(6));
        Driver raikkonen = new Driver(new DriverId(7), "Kimi Raikkonen", allNations.get(3), allTeams.get(7));
        Driver giovinazzi = new Driver(new DriverId(99), "Antonio Giovinazzi", allNations.get(7), allTeams.get(7));
        Driver mazepin = new Driver(new DriverId(9), "Nikita Mazepin", allNations.get(12), allTeams.get(8));
        Driver schumacher = new Driver(new DriverId(47), "Mick Schumacher", allNations.get(6), allTeams.get(8));
        Driver russell = new Driver(new DriverId(63), "George Russell", allNations.get(5), allTeams.get(9));
        Driver latifi = new Driver(new DriverId(6), "Nicholas Latifi", allNations.get(1), allTeams.get(9));

        repository.insert(verstappen);
        repository.insert(hamilton);
        repository.insert(bottas);
        repository.insert(alonso);
        repository.insert(vettel);
        repository.insert(leclerc);
        repository.insert(norris);
        repository.insert(sainz);
        repository.insert(ricciardo);
        repository.insert(ocon);
        repository.insert(gasly);
        repository.insert(tsunoda);
        repository.insert(perez);
        repository.insert(stroll);
        repository.insert(raikkonen);
        repository.insert(giovinazzi);
        repository.insert(mazepin);
        repository.insert(schumacher);
        repository.insert(russell);
        repository.insert(latifi);

        return repository;

    }

}
