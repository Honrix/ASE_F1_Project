package dhbw.projects;

import dhbw.projects.data.Date;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        DriverRepository repository = new DriverRepositoryImpl();

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

}
