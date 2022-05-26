package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.race.Race;

import java.util.*;

public class GetReportUseCase {

    private final GetReportService getReportService;
    private List<Race> allRaces;
    private ArrayList<Integer> totalPoints;
    private ArrayList<Driver> driverWithPoints;

    public GetReportUseCase(RaceRepository raceRepository, Map<String, Driver> drivers) {
        this.getReportService = new GetReportService(raceRepository);
        this.allRaces = this.getReportService.getAllRaces();
    }

    public Object[] getTotalPoints(){
        getPointsOfDrivers();
        Map<String, Integer> totalPoints = new HashMap<>();

        for (int i = 0; i < this.driverWithPoints.size(); i++) {
            totalPoints.put(this.driverWithPoints.get(i).getName(), this.totalPoints.get(i));
        }

        Object[] a = totalPoints.entrySet().toArray();
        Arrays.sort(a, (o1, o2) -> ((Map.Entry<String, Integer>) o2).getValue()
                .compareTo(((Map.Entry<String, Integer>) o1).getValue()));

        return a;
    }

    private void getPointsOfDrivers(){
        this.totalPoints = new ArrayList<>();
        this.driverWithPoints = new ArrayList<>();
        for (Race race: this.allRaces) {
            for (int i = 0; i < race.getScoreboard().size(); i++) {
                Driver driver = race.getScoreboard().get(i).getDriver();
                int points = getPointsOfPosition(i+1);
                if(containsDriver(driver)){
                    System.out.println(driver.getName() + " gefunden");
                    int driverPosition = getDriverPositionInList(driver);
                    this.totalPoints.set(driverPosition, this.totalPoints.get(driverPosition) + points);
                }   else {
                    System.out.println(driver.getName() + " nicht gefunden");
                    this.driverWithPoints.add(driver);
                    this.totalPoints.add(points);
                }

            }
        }
    }

    private boolean containsDriver(Driver driver){
        for (Driver currentDriver: this.driverWithPoints) {
            if(currentDriver.getDriverId().equals(driver.getDriverId())){
                return true;
            }
        }
        return false;
    }

    private int getDriverPositionInList(Driver driver){
        for (int i = 0; i < this.driverWithPoints.size(); i++) {
            if(this.driverWithPoints.get(i).getDriverId().equals(driver.getDriverId())) {
                return i;
            }
        }
        return 0;
    }

    private int getPointsOfPosition(int position){
        int[] points = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        if(position > 10){
            return 0;
        } else {
            return points[position-1];
        }
    }


}
