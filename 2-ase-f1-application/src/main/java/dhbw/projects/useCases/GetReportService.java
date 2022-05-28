package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.race.Race;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GetReportService {

    private final RaceRepository raceRepository;

    public GetReportService(RaceRepository raceRepository){
        this.raceRepository = raceRepository;
    }

    public List<Race> getAllRaces() {
        return this.raceRepository.getAll();
    }

    public int getPointsOfPosition(int position){
        int[] points = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        if(position < 11){
            return points[position-1];
        }
        return 0;
    }

    public boolean containsDriver(List<Driver> drivers, Driver driver){
        for (Driver currentDriver: drivers) {
            if(currentDriver.getDriverId().equals(driver.getDriverId())){
                return true;
            }
        }
        return false;
    }

    public int getDriverPositionInList(List<Driver> drivers, Driver driver){
        for (int i = 0; i < drivers.size(); i++) {
            if(drivers.get(i).getDriverId().equals(driver.getDriverId())) {
                return i;
            }
        }
        return 0;
    }

    public Object[] getSortedList(Object[] object){
        Arrays.sort(object, (o1, o2) -> ((Map.Entry<String, Integer>) o2).getValue()
                .compareTo(((Map.Entry<String, Integer>) o1).getValue()));
        return object;
    }


}
