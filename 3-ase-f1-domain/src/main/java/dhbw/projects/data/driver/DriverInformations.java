package dhbw.projects.data.driver;

public class DriverInformations {

    private final Driver driver;
    private final int startPosition;        // = Grid-Position
    private final int finalPosition;        // = Position at the end of the race
    private final double fastestLap;        //Save in seconds and milliseconds (e.g.: "90.684" instead of "1,30.684")

    public DriverInformations(Driver driver, int startPosition, int finalPosition, double fastestLap) {
        this.driver = driver;
        this.startPosition = startPosition;
        this.finalPosition = finalPosition;
        this.fastestLap = fastestLap;
    }

    public Driver getDriver() {
        return driver;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getFinalPosition() {
        return finalPosition;
    }

    public double getFastestLap() {
        return fastestLap;
    }
}
