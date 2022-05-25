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
        return(this.values.getAllTracks().get(String.valueOf(this.scanner.nextInt()-1)));
    }

    private int enterLength(){
        System.out.println("Select one of the following Lengths of the Race:");
        this.lengths.put("1", 25);
        this.lengths.put("2", 50);
        this.lengths.put("3", 100);
        this.lengths.forEach((key, value) -> System.out.printf("%-10s", "\n[" + key + "] " + value + "%\n"));
        return(this.lengths.get(this.scanner.next()));
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
        selectedDriverKey = String.valueOf(this.scanner.nextInt()-1);
        return (this.drivers.get(selectedDriverKey));
    }

    private int enterStartingPosition(Driver driver){
        System.out.println("Enter the Grid-Position of " + (driver.getName()) + ":");
        return this.scanner.nextInt();
    }

    private double enterFastestLap(Driver driver){
        System.out.println("Enter the Fastest Lap of " + (driver.getName()) + " (Format: XX.XXX):");
        return this.scanner.nextDouble();
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

        for (int i = 0; i < 1; i++) {
            driver = enterDriver(remainingDrivers, i+1);
            while(!confirmInput(driver.getName())){
                driver = enterDriver(remainingDrivers, i+1);
            }

            startingPosition = enterStartingPosition(driver);
            while(!confirmInput(String.valueOf(startingPosition))){
                startingPosition = enterStartingPosition(driver);
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
