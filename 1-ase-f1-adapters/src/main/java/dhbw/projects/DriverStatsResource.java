package dhbw.projects;

import dhbw.projects.data.driver.Driver;

public class DriverStatsResource {

    private Driver driver;
    private int startPosition;        // = Grid-Position
    private int finalPosition;        // = Position at the end of the race
    private int positionsGained;      // Difference between Grid-Position to Position after race
    private double fastestLap;        //Save in seconds and milliseconds (e.g.: "90.684" instead of "1,30.684")

    public DriverStatsResource(Driver driver, int startPosition, int finalPosition, double fastestLap) throws Exception {
        if(!validatePosition(startPosition) || !validatePosition(finalPosition) || !validateFastestLap(fastestLap)) {
            throw new IllegalArgumentException("Error by creating " + driver.getName() +
                    " (SP: " + startPosition + ", FP: " +
                    finalPosition + ", Laptime: " +
                    fastestLap + ")");
        }
        this.driver = driver;
        this.startPosition = startPosition;
        this.finalPosition = finalPosition;
        this.positionsGained = startPosition - finalPosition;
        this.fastestLap = fastestLap;
    }

    private boolean validatePosition(int position) {
        if(position > 20){
            return false;
        } else if (position < 1){
            return false;
        } else {
            return true;
        }
    }

    private boolean validateFastestLap(double time) {
        if(time <= 0){
            return false;
        } else {
            return ((int) (time * 1000)) * 10 == (int) (time * 10000);  // Prüfüng: 4. Nachkommastelle = 0 ?
        }
    }

    public int getFinalPosition() {
        return finalPosition;
    }

    public String getName(){
        return driver.getName();
    }

}
