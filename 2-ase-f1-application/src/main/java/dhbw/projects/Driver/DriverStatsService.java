package dhbw.projects.Driver;

import dhbw.projects.Driver.DriverStats;

import java.util.Comparator;
import java.util.List;

public class DriverStatsService {

    private List<DriverStats> driverStats ;

    public DriverStatsService(List<DriverStats> driverStats){
        driverStats.sort(Comparator.comparingInt(DriverStats::getFinalPosition));
        this.driverStats = driverStats;
    }

    public List<DriverStats> getDriverStats() {
        return driverStats;
    }


}
