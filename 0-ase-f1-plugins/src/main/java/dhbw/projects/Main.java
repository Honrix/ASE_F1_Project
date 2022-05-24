package dhbw.projects;

import dhbw.projects.data.Date;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.nation.Nation;
import dhbw.projects.data.team.Team;
import dhbw.projects.data.track.Track;
import dhbw.projects.driver.DriverRepositoryImpl;
import dhbw.projects.nation.NationRepositoryImpl;
import dhbw.projects.team.TeamRepositoryImpl;
import dhbw.projects.track.TrackRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Main {

    public static void main(String[] args) throws Exception {
        DriverRepository repository = new DriverRepositoryImpl();

        loadTracks();
        loadNations();
        loadTeams();

        Driver verstappen = new Driver(33, "Max Verstappen", )
        repository.insert();

        DriverStats driver1 = new DriverStats(Driver.VERSTAPPEN, 3, 1, 87.354);
        DriverStats test1 = new DriverStats(Driver.HAMILTON, 1, 5, 90.525);
        DriverStats test2 = new DriverStats(Driver.ALONSO, 2, 3, 49.948);

        List<DriverStats> liste = new ArrayList<>();
        liste.add(driver1);
        liste.add(test1);
        liste.add(test2);
        DriverStatsService controller = new DriverStatsService(liste);
        Date date1 = new Date("20220523");
        RaceResult raceResult = new RaceResult(Track.BELGIUM, controller.getDriverStats(), 100, date1);
        controller.getDriverStats().forEach(driverStat -> System.out.println(driverStat.getName() + " - " + driverStat.getFinalPosition()));

        Date date2 = new Date(2022, 05, 23);
        System.out.println(date2.toString());



    }

    public static void loadTracks(){

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
    }

    public static void loadNations(){

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

        repository.insert(aus);
        repository.insert(can);
        repository.insert(esp);
        repository.insert(fin);
        repository.insert(fra);
        repository.insert(gbr);
        repository.insert(ger);
        repository.insert(ita);
        repository.insert(jpn);
        repository.insert(mex);
        repository.insert(mon);
        repository.insert(ned);
        repository.insert(rus);
    }

    public static void loadTeams(){

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

        repository.insert(MERCEDES);
        repository.insert(FERRARI);
        repository.insert(RED_BULL);
        repository.insert(MCLAREN);
        repository.insert(ALPINE);
        repository.insert(ALPHATAURI);
        repository.insert(ASTON_MARTIN);
        repository.insert(ALFA_ROMEO);
        repository.insert(HAAS);
        repository.insert(WILLIAMS);
    }

}
