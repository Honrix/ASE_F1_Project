package dhbw.projects;

import dhbw.projects.data.Date;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.track.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Main {

    public static void main(String[] args) throws Exception {
        DriverRepository repository = new DriverRepositoryImpl();

        loadTracks();

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

}
