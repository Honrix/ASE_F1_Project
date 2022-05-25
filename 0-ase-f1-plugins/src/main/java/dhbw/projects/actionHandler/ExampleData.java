package dhbw.projects.actionHandler;

import dhbw.projects.Driver.DriverStats;
import dhbw.projects.Driver.DriverStatsService;
import dhbw.projects.data.Date;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.track.Track;
import dhbw.projects.data.driver.DriverId;
import dhbw.projects.driver.DriverRepositoryImpl;
import dhbw.projects.newRace.RaceService;
import dhbw.projects.race.RaceResultResource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExampleData {

    private final RaceResultResource raceResultResource;
    private final RaceService raceResult;

    public ExampleData(List<Driver> allDrivers, List<Track> tracks) throws Exception {
        raceResult = generateDate(allDrivers, tracks);
        raceResultResource = new RaceResultResource(raceResult);

    }

    public RaceResultResource getRaceResultResource() {
        return raceResultResource;
    }

    private RaceService generateDate(List<Driver> allDrivers, List<Track> tracks) throws Exception {
        DriverRepositoryImpl drivers = new DriverRepositoryImpl();
        for (Driver driver : allDrivers){
            drivers.insert(driver);
        }

        DriverStats driverStats1 = new DriverStats(drivers.getById(new DriverId(33)), 3, 1, 90.000);
        DriverStats driverStats2 = new DriverStats(drivers.getById(new DriverId(44)), 1, 3, 95.300);
        DriverStats driverStats3 = new DriverStats(drivers.getById(new DriverId(5)), 5, 4, 95.320);
        DriverStats driverStats4 = new DriverStats(drivers.getById(new DriverId(16)), 4, 2, 91.335);

        List<DriverStats> stats = new ArrayList<>();
        stats.add(driverStats1);
        stats.add(driverStats2);
        stats.add(driverStats3);
        stats.add(driverStats4);

        DriverStatsService service = new DriverStatsService(stats);

        /*RaceService raceService = new RaceService(
                tracks.get(0),
                service.getDriverStats(),
                50,
                new Date("20220524"),
                UUID.randomUUID()
        );*/

        return raceResult;
    }

}
