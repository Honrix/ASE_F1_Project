package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.race.Race;

import java.util.*;

public class GetReportUseCase {

    private final GetReportService getReportService;
    private final List<Race> allRaces;
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
        return this.getReportService.getSortedList(totalPoints.entrySet().toArray());
    }

    private void clearLists(){
        this.totalPoints = new ArrayList<>();
        this.driverWithPoints = new ArrayList<>();
    }

    private void getPointsOfDrivers(){
        clearLists();
        for (Race race: this.allRaces) {
            for (int i = 0; i < race.getScoreboard().size(); i++) {
                Driver driver = race.getScoreboard().get(i).getDriver();
                int points = this.getReportService.getPointsOfPosition(i+1);
                if(this.getReportService.containsDriver(this.driverWithPoints, driver)){
                    int driverPosition = this.getReportService.getDriverPositionInList(this.driverWithPoints, driver);
                    this.totalPoints.set(driverPosition, this.totalPoints.get(driverPosition) + points);
                }   else {
                    this.driverWithPoints.add(driver);
                    this.totalPoints.add(points);
                }
            }
        }
    }


}
