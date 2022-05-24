package dhbw.projects.Driver;

import dhbw.projects.data.driver.Driver;

public class DriverStats {

    private final Driver driver;
    private final int startPosition;        // = Grid-Position
    private final int finalPosition;        // = Position at the end of the race
    private final int positionsGained;      // Difference between Grid-Position to Position after race
    private final double fastestLap;        //Save in seconds and milliseconds (e.g.: "90.684" instead of "1,30.684")

    public DriverStats(Driver driver, int startPosition, int finalPosition, double fastestLap) throws Exception {
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

    public String toCSVEntry() {
        return startPosition + ", " + driver + ", " + finalPosition + ", " + fastestLap;
    }

    private boolean validatePosition(int position) {
        if(position > 20 || position < 1) {
            return false;
        }
        return true;
    }

    private boolean validateFastestLap(double time) {
        if(time <= 0){
            return false;
        } else {
            return Math.round(time*1000) == time*1000;
        }
    }

    public int getFinalPosition() {
        return finalPosition;
    }

    public String getName(){
        return driver.getName();
    }

    public int getStartPosition() {
        return startPosition;
    }

    public double getFastestLap() {
        return fastestLap;
    }
}