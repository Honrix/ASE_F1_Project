package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.actionHandler.UserOptions;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.track.Track;
import dhbw.projects.values.ValuesImpl;

import java.util.*;

public class CreateRaceAction implements UserOptions {

    private final CreateRaceUseCase createRaceUseCase;
    private final ValuesImpl valuesImpl;
    private final Scanner scanner;
    private final int[] lengthOptions = {25, 50, 100};
    private Map<String, Integer> lengths = new HashMap<>();

    public CreateRaceAction(RaceRepository raceRepository){
        this.createRaceUseCase = new CreateRaceUseCase(raceRepository);
        this.valuesImpl = new ValuesImpl();
        scanner = new Scanner(System.in);
    }

    @Override
    public void initializeOption() {
        System.out.println("Follow the instructions to create a new Race!");
        for (int i = 0; i < this.lengthOptions.length; i++) {
            this.lengths.put(String.valueOf(i+1), this.lengthOptions[i]);
        }
        enterHeader();
        enterScoreboard();
        this.createRaceUseCase.insertRace();
    }

    private void enterHeader(){
        enterDate();
        enterTrack();
        enterLength();
    }

    private void enterScoreboard(){
        List<DriverInformations> scoreboard = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            Driver driver = enterDriver();
            int gridPosition = enterGridPosition(driver);
            double fastestLap = enterFastestLap(driver);
            scoreboard.add(new DriverInformations(driver, gridPosition, i, fastestLap));
        }
        this.createRaceUseCase.insertScoreboard(scoreboard);
    }

    private void enterDate() {
        String input;
        String dateInput;
        do {
            System.out.println("Please Enter the Date of the Race (Format: YYYYMMDD):");
            dateInput = getValidDateInput();
            System.out.println("Is that correct: " + dateInput + "? [Y/N]");
            input = confirmInput();
        } while(!this.createRaceUseCase.confirmUserInput(input));
        this.createRaceUseCase.insertDate(dateInput);
    }

    private void enterTrack() {
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
        } while(!this.createRaceUseCase.confirmUserInput(input));
        this.createRaceUseCase.insertTrack(
                this.valuesImpl.getValuesAdapter().getValuesService().getTrackByName(trackInput));
    }

    private void enterLength(){
        String input;
        String lengthInput;
        do {
            System.out.println("Select one of the following Lengths of the Race:");
            this.lengths.forEach((key, value) -> System.out.printf("%-10s", "\n[" + key + "] " + value + "%\n"));

            lengthInput = getValidInputOfRange(this.lengthOptions.length);
            System.out.println("Is that correct: " + this.lengths.get(lengthInput).toString() + "? [Y/N]");
            input = confirmInput();
        } while(!this.createRaceUseCase.confirmUserInput(input));
        this.createRaceUseCase.insertLength(Integer.parseInt(lengthInput));

    }

    private Driver enterDriver(){
        String input;
        String driverInput;
        Map<String, Driver> drivers = this.valuesImpl.getDrivers();
        do {
            System.out.println("Select one of the following Driver:");
            System.out.println(
                    this.valuesImpl.getValuesAdapter().sortedOutput(
                            this.valuesImpl.getDriverNames(), "All Tracks"));

            driverInput = getValidInputOfRange(drivers.size());
            System.out.println("Is that correct: " + drivers.get(driverInput).getName() + "? [Y/N]");
            input = confirmInput();
        } while(!this.createRaceUseCase.confirmUserInput(input));
        return drivers.get(driverInput);

    }

    private int enterGridPosition(Driver driver) {
        String input;
        String gridPositionInput;
        do {
            System.out.println("Enter the Grid-Position of " + (driver.getName()) + ":");
            gridPositionInput = getValidInputOfRange(this.valuesImpl.getDrivers().size());
            System.out.println("Is that correct: " + gridPositionInput + "? [Y/N]");
            input = confirmInput();
        } while(!this.createRaceUseCase.confirmUserInput(input));
        return Integer.parseInt(gridPositionInput);
    }

    private double enterFastestLap(Driver driver){
        String input;
        String fastestLapInput;
        do {
            System.out.println("Enter the Fastest Lap of " + (driver.getName()) + " (Format: XX.XXX):");
            fastestLapInput = getValidLaptime();
            System.out.println("Is that correct: " + fastestLapInput + "? [Y/N]");
            input = confirmInput();
        } while(!this.createRaceUseCase.confirmUserInput(input));
        return Double.parseDouble(fastestLapInput);

    }

    private String confirmInput(){
        String input;
        do {
            input = readNextLine();
            if(!this.createRaceUseCase.validateConfirmationInput(input)){
                printOutputString();
            }
        } while(!this.createRaceUseCase.validateConfirmationInput(input));
        return input;
    }

    private void printOutputString(){
        System.out.println(this.createRaceUseCase.getOutputString());
    }

    private String getValidLaptime() {
        Boolean validateLaptime;
        String input;
        do {
            input = readNextLine();
            validateLaptime = this.createRaceUseCase.validateLaptime(input);
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
            validateDate = this.createRaceUseCase.validateDateInput(input);
            if (!validateDate) {
                printOutputString();
            }
        } while (!validateDate);
        return input;
    }

    private String getValidInputOfRange(int maxValue) {
        Boolean validateTrack;
        String input;
        do {
            input = readNextLine();
            validateTrack = this.createRaceUseCase.validateInputOfRange(input, maxValue);
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
    public String getDescription() {
        return "Create A New Race";
    }
}
