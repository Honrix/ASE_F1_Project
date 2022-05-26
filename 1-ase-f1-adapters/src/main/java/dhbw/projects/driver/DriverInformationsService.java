package dhbw.projects.driver;

import dhbw.projects.InputValidator;
import dhbw.projects.ObjectOutput;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.driver.DriverInformations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DriverInformationsService {

    private DriverInformations driverInformations;
    private final Map<String, Driver> drivers;
    private final Scanner scanner = new Scanner(System.in);
    private final InputValidator inputValidator = new InputValidator();

    public DriverInformationsService(Map<String, Driver> drivers, int finalPosition){
        this.drivers = drivers;
        initialize(finalPosition);
    }

    public DriverInformations getDriverInformations() {
        return driverInformations;
    }

    private Map<String, String> getDriverNames(Map<String, Driver> drivers){
        Map<String, String> driverNames = new HashMap<>();
        for (int i = 0; i < drivers.size(); i++) {
            driverNames.put(String.valueOf(i), drivers.get(String.valueOf(i)).getName());
        }
        return driverNames;
    }

    private void initialize(int finalPosition){
        Map<String, String> driverNames = getDriverNames(this.drivers);
        Driver driver;
        int startingPosition;
        double fastestLap;
        driver = enterDriver(driverNames, finalPosition);
        while(!this.inputValidator.confirmInput(driver.getName())){
            driver = enterDriver(driverNames, finalPosition);
        }
        startingPosition = enterGridPosition(driver);
        while(!this.inputValidator.confirmInput(String.valueOf(startingPosition))){
            startingPosition = enterGridPosition(driver);
        }
        fastestLap = enterFastestLap(driver);
        while(!this.inputValidator.confirmInput(fastestLap +" in ms")){
            fastestLap = enterFastestLap(driver);
        }
        driverInformations = new DriverInformations(
                driver,
                startingPosition,
                finalPosition,
                startingPosition-finalPosition,
                fastestLap
        );
    }

    private Driver enterDriver(Map<String, String> drivers, int finalPosition){
        System.out.println("Select the Driver with the final Position " + (finalPosition) + ":");
        System.out.println(printDrivers(drivers));
        String selectedDriverKey = this.inputValidator.validateCertainSelection(this.scanner.next(), drivers.size());
        return (this.drivers.get(String.valueOf(Integer.parseInt(selectedDriverKey)-1)));
    }

    private String printDrivers(Map<String, String> drivers){
        ObjectOutput objectOutput = new ObjectOutput(drivers, "All Drivers");
        return objectOutput.getOutput();
    }

    private int enterGridPosition(Driver driver){
        System.out.println("Enter the Grid-Position of " + (driver.getName()) + ":");
        String input = this.inputValidator.validateCertainSelection(this.scanner.next(), this.drivers.size());
        return Integer.parseInt(input);
    }

    private double enterFastestLap(Driver driver){
        System.out.println("Enter the Fastest Lap of " + (driver.getName()) + " (Format: XX.XXX):");
        String input = this.scanner.next();
        while(!this.inputValidator.validateLaptime(input)){
            System.out.println("Please Enter a valide Laptime (Format: XX.XXX)");
            input = this.scanner.next();
        }
        return Double.parseDouble(input);
    }

}
