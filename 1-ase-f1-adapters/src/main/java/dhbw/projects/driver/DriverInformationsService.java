package dhbw.projects.driver;

import dhbw.projects.ValuesService;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.driver.DriverInformations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DriverInformationsService {

    private DriverInformations driverInformations;
    private final Map<String, Driver> drivers;
    private final Scanner scanner = new Scanner(System.in);
    private final ValuesService valuesService = new ValuesService();

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
        while(!confirmInput(driver.getName())){
            driver = enterDriver(driverNames, finalPosition);
        }

        startingPosition = enterGridPosition(driver);
        while(!confirmInput(String.valueOf(startingPosition))){
            startingPosition = enterGridPosition(driver);
        }

        fastestLap = enterFastestLap(driver);
        while(!confirmInput(String.valueOf(fastestLap)+" in ms")){
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

    private boolean confirmInput(String input) {
        System.out.println("Is that correct: " + input + "? [Y/N]");
        String userInput = scanner.next();
        if (userInput.equals("Y")) {
            return true;
        } else if (userInput.equals("N")) {
            return false;
        } else {
            while (true) {
                if (userInput.equals("Y")) {
                    return true;
                } else if (userInput.equals("N")) {
                    return false;
                } else {
                    System.out.println("Please enter \"Y\" or \"N\"");
                }
                userInput = scanner.next();
            }
        }
    }

    private Driver enterDriver(Map<String, String> drivers, int finalPosition){
        System.out.println("Select the Driver with the final Position " + (finalPosition) + ":");
        String selectedDriverKey;
        System.out.println(this.valuesService.sortedOutput(drivers, "All Drivers"));
        selectedDriverKey = this.scanner.next();
        selectedDriverKey = validateCertainSelection(selectedDriverKey, drivers.size());
        return (this.drivers.get(String.valueOf(Integer.parseInt(selectedDriverKey)-1)));
    }

    private int enterGridPosition(Driver driver){
        System.out.println("Enter the Grid-Position of " + (driver.getName()) + ":");
        String input = validateCertainSelection(this.scanner.next(), this.drivers.size());
        return Integer.parseInt(input);
    }

    private double enterFastestLap(Driver driver){
        System.out.println("Enter the Fastest Lap of " + (driver.getName()) + " (Format: XX.XXX):");
        String input = this.scanner.next();
        while(!validateLaptime(input)){
            System.out.println("Please Enter a valide Laptime (Format: XX.XXX)");
            input = this.scanner.next();
        }
        return Double.parseDouble(input);
    }

    private String validateCertainSelection(String input, int maxValue){
        while(!validateSelection(input, maxValue)){
            System.out.println("Select A Number between [1] and [" + maxValue + "]:");
            input = this.scanner.next();
        }
        return input;
    }

    public boolean validateLaptime(String date){
        return date.matches("^\\d{1,3}[.]\\d{3}$");
    }

    public boolean validateSelection(String input, int maxValue){
        if(input.matches("^\\d+$")) {
            return (0 < Integer.parseInt(input) && Integer.parseInt(input) <= maxValue);
        } else {
            return false;
        }
    }



}
