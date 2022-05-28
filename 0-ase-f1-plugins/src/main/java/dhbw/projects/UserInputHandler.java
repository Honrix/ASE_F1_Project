package dhbw.projects;

import dhbw.projects.actionHandler.UserOptions;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.track.Track;
import dhbw.projects.values.ValuesImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInputHandler implements UserOptions {

    private final UserInputAdapter userInputAdapter;
    private final ValuesImpl valuesImpl;
    private final Scanner scanner = new Scanner(System.in);
    private final int[] lengthOptions = {25, 50, 100};
    private Map<String, Integer> lengths = new HashMap<>();

    public UserInputHandler(){
        this.userInputAdapter = new UserInputAdapter();
        this.valuesImpl = new ValuesImpl();
        initializeOption();
    }

    public String getDate() {
        String input;
        String dateInput;
        do {
            System.out.println("Please Enter the Date of the Race (Format: YYYYMMDD):");
            dateInput = getValidDateInput();
            System.out.println("Is that correct: " + dateInput + "? [Y/N]");
            input = confirmInput();
        } while(!this.userInputAdapter.confirmUserInput(input));
        return dateInput;
    }

    public UserInputAdapter getUserInputAdapter() {
        return userInputAdapter;
    }

    public Track getTrack() {
        String input;
        String trackInput;
        Map<String, Track> tracks = this.valuesImpl.getTracks();
        do {
            System.out.println("Select one of the following tracks:");
            System.out.println(
                    this.valuesImpl.getValuesAdapter().sortedOutput(
                            this.valuesImpl.getTrackNames(), "All Tracks"));

            trackInput = getValidInputOfRange(this.valuesImpl.getTracks().size());
            System.out.println("Is that correct: " + tracks.get(trackInput).toString() + "? [Y/N]");
            input = confirmInput();
        } while(!this.userInputAdapter.confirmUserInput(input));
        return this.valuesImpl.getValuesAdapter().getValuesService().getTrackById(trackInput);
    }

    public int getLength(){
        String input;
        String lengthInput;
        do {
            System.out.println("Select one of the following Lengths of the Race:");
            this.lengths.forEach((key, value) -> System.out.printf("%-10s", "\n[" + key + "] " + value + "%\n"));

            lengthInput = getValidInputOfRange(this.lengthOptions.length);
            System.out.println("Is that correct: " + this.lengths.get(lengthInput).toString() + "? [Y/N]");
            input = confirmInput();
        } while(!this.userInputAdapter.confirmUserInput(input));
        return Integer.parseInt(this.lengths.get(lengthInput).toString());

    }

    private Driver getDriver(int finalPosition){
        String input;
        String driverInput;
        Map<String, Driver> drivers = this.valuesImpl.getDrivers();
        do {
            System.out.println("Select the driver of position " + finalPosition + ":");
            System.out.println(
                    this.valuesImpl.getValuesAdapter().sortedOutput(
                            this.valuesImpl.getDriverNames(), "All Driver"));

            driverInput = getValidInputOfRange(drivers.size());
            System.out.println("Is that correct: " + drivers.get(driverInput).getName() + "? [Y/N]");
            input = confirmInput();
        } while(!this.userInputAdapter.confirmUserInput(input));
        return drivers.get(driverInput);

    }

    private int getGridPosition(Driver driver) {
        String input;
        String gridPositionInput;
        do {
            System.out.println("Enter the Grid-Position of " + (driver.getName()) + ":");
            gridPositionInput = getValidInputOfRange(this.valuesImpl.getDrivers().size());
            System.out.println("Is that correct: " + gridPositionInput + "? [Y/N]");
            input = confirmInput();
        } while(!this.userInputAdapter.confirmUserInput(input));
        return Integer.parseInt(gridPositionInput);
    }

    private double getFastestLap(Driver driver){
        String input;
        String fastestLapInput;
        do {
            System.out.println("Enter the Fastest Lap of " + (driver.getName()) + " (Format: XX.XXX):");
            fastestLapInput = getValidLaptime();
            System.out.println("Is that correct: " + fastestLapInput + "? [Y/N]");
            input = confirmInput();
        } while(!this.userInputAdapter.confirmUserInput(input));
        return Double.parseDouble(fastestLapInput);

    }

    public DriverInformations getDriverInformations(int finalPosition){
        Driver driver = getDriver(finalPosition);
        int gridPosition = getGridPosition(driver);
        double fastestLap = getFastestLap(driver);
        return new DriverInformations(driver, gridPosition, finalPosition, fastestLap);
    }

    public String confirmInput(){
        String input;
        do {
            input = readNextLine();
            if(!this.userInputAdapter.validateConfirmationInput(input)){
                printOutputString();
            }
        } while(!this.userInputAdapter.validateConfirmationInput(input));
        return input;
    }

    private void printOutputString(){
        System.out.println(this.userInputAdapter.getOutputString());
    }

    private String getValidLaptime() {
        Boolean validateLaptime;
        String input;
        do {
            input = readNextLine();
            validateLaptime = this.userInputAdapter.validateLaptime(input);
            if (!validateLaptime) {
                printOutputString();
            }
        } while (!validateLaptime);
        return input;
    }

    private String getValidDateInput() {
        Boolean validateDate;
        String input;
        do {
            input = readNextLine();
            validateDate = this.userInputAdapter.validateDateInput(input);
            if (!validateDate) {
                printOutputString();
            }
        } while (!validateDate);
        return input;
    }

    public String getValidInputOfRange(int maxValue) {
        Boolean validateTrack;
        String input;
        do {
            input = readNextLine();
            validateTrack = this.userInputAdapter.validateInputOfRange(input, maxValue);
            if (!validateTrack) {
                printOutputString();
            }
        } while (!validateTrack);
        return input;
    }

    private String readNextLine(){
        return this.scanner.next();
    }

    @Override
    public void initializeOption() {
        for (int i = 0; i < this.lengthOptions.length; i++) {
            this.lengths.put(String.valueOf(i+1), this.lengthOptions[i]);
        }
    }

    @Override
    public String getDescription() {
        return "Handles in- and outputs of User";
    }
}
