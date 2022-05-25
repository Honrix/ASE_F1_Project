package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.actionHandler.UserOptions;
import dhbw.projects.actionHandler.Values;
import dhbw.projects.data.Date;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.race.Race;
import dhbw.projects.data.track.Track;

import java.util.*;

public class CreateRaceAction implements UserOptions {

    private final CreateRaceUseCase createRaceUseCase;
    private final Scanner scanner = new Scanner(System.in);
    private Race race;
    private Date date;
    private Track track;
    private int lengthOfRace;
    private final int[] lengthOptions = {25, 50, 100};
    private String selectedDriverKey;
    private List<DriverInformations> scoreboard = new ArrayList<>();
    private Values values;
    private Map<String, Track> tracks = new HashMap<>();
    private Map<String, Driver> drivers = new HashMap<>();
    private Map<String, Integer> lengths = new HashMap<>();

    public CreateRaceAction(RaceRepository raceRepository){
        this.createRaceUseCase = new CreateRaceUseCase(raceRepository);
    }

    private Date enterDate(){
        System.out.println("Please Enter the Date of the Race (Format: YYYYMMDD):");
        String input = this.scanner.next();
        while(!this.createRaceUseCase.validateDate(input)){
            System.out.println("Please Enter a valide Date (Format: YYYYMMDD)");
            input = this.scanner.next();
        }
        return new Date(input);
    }

    private Track enterTrack(){
        System.out.println("Select one of the following tracks:");
        this.values.sortedOutput(this.values.getTrackNames(), "All Tracks");
        String input = validateSelection(this.scanner.next(), this.values.getTrackNames().size());
        return(this.values.getAllTracks().get(String.valueOf(Integer.parseInt(input)-1)));
    }

    private int enterLength(){
        System.out.println("Select one of the following Lengths of the Race:");
        for (int i = 0; i < this.lengthOptions.length; i++) {
            this.lengths.put(String.valueOf(i+1), this.lengthOptions[i]);
        }
        this.lengths.forEach((key, value) -> System.out.printf("%-10s", "\n[" + key + "] " + value + "%\n"));
        return(this.lengths.get(validateSelection(this.scanner.next(), this.lengthOptions.length)));
    }

    private String validateSelection(String input, int maxValue){
        while(!this.createRaceUseCase.validateSelection(input, maxValue)){
            System.out.println("Select A Number between [1] and [" + maxValue + "]:");
            input = this.scanner.next();
        }
        return input;
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

    private void enterHeader(){
        this.date = enterDate();
        while(!confirmInput(date.toString(""))){
            date = enterDate();
        }

        this.track = enterTrack();
        while(!confirmInput(track.toString())){
            track = enterTrack();
        }

        this.lengthOfRace = enterLength();
        while(!confirmInput(String.valueOf(lengthOfRace))){
            lengthOfRace = enterLength();
        }

    }

    private Driver enterDriver(Map<String, String> drivers, int finalPosition){
        System.out.println("Select the Driver with the final Position " + (finalPosition) + ":");
        this.values.sortedOutput(drivers, "All Drivers");
        selectedDriverKey = this.scanner.next();
        selectedDriverKey = validateSelection(selectedDriverKey, drivers.size());
        return (this.drivers.get(String.valueOf(Integer.parseInt(selectedDriverKey)-1)));
    }

    private int enterGridPosition(Driver driver){
        System.out.println("Enter the Grid-Position of " + (driver.getName()) + ":");
        String input = validateSelection(this.scanner.next(), this.drivers.size());
        return Integer.parseInt(input);
    }

    private double enterFastestLap(Driver driver){
        System.out.println("Enter the Fastest Lap of " + (driver.getName()) + " (Format: XX.XXX):");
        String input = this.scanner.next();
        while(!this.createRaceUseCase.validateLaptime(input)){
            System.out.println("Please Enter a valide Laptime (Format: XX.XXX)");
            input = this.scanner.next();
        }
        return Double.parseDouble(input);
    }

    private void enterScoreboard(){
        this.scoreboard = new ArrayList<>();
        this.drivers = values.getAllDrivers();
        Map<String, String> remainingDrivers = new HashMap<>();
        remainingDrivers = this.values.getDriverNames();
        DriverInformations driverInformations;
        Driver driver;
        int startingPosition;
        double fastestLap;

        for (int i = 0; i < this.drivers.size(); i++) {
            driver = enterDriver(remainingDrivers, i+1);
            while(!confirmInput(driver.getName())){
                driver = enterDriver(remainingDrivers, i+1);
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
                    i+1,
                    startingPosition-i+1,
                    fastestLap
            );

            this.scoreboard.add(driverInformations);

        }

    }

    @Override
    public void initializeOption() {
        this.values = new Values();

        enterHeader();
        enterScoreboard();

        this.race = new Race(this.track, this.scoreboard, this.lengthOfRace, this.date, UUID.randomUUID());

        this.createRaceUseCase.insert(this.race);
        System.out.println("You have entered all information. Your race of " + this.date.toString("") + " has been saved!\n\n\n");

    }

    @Override
    public String getDescription() {
        return "Create A New Race";
    }

    @Override
    public void closeAction() {
        scanner.close();
    }
}
