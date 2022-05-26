package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.actionHandler.UserOptions;
import dhbw.projects.actionHandler.Values;
import dhbw.projects.data.date.Date;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.race.Race;
import dhbw.projects.data.track.Track;
import dhbw.projects.driver.DriverInformationsService;

import java.util.*;

public class CreateRaceAction implements UserOptions {

    private final CreateRaceUseCase createRaceUseCase;
    private final Map<String, Track> tracks = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private final int[] lengthOptions = {25, 50, 100};
    private List<DriverInformations> scoreboard = new ArrayList<>();
    private Map<String, Driver> drivers = new HashMap<>();
    private Map<String, Integer> lengths = new HashMap<>();
    private Race race;
    private Date date;
    private Track track;
    private int lengthOfRace;
    private Values values;

    public CreateRaceAction(RaceRepository raceRepository){
        this.createRaceUseCase = new CreateRaceUseCase(raceRepository);
    }

    private Date enterDate(){
        System.out.println("Please Enter the Date of the Race (Format: YYYYMMDD):");
        String input = this.scanner.next();
        while(!this.createRaceUseCase.getInputValidator().validateDate(input)){
            System.out.println("Please Enter a valide Date (Format: YYYYMMDD)");
            input = this.scanner.next();
        }
        return new Date(input);
    }

    private Track enterTrack(){
        System.out.println("Select one of the following tracks:");
        this.values.sortedOutput(this.values.getTrackNames(), "All Tracks");
        String input = this.createRaceUseCase.getInputValidator().validateCertainSelection(
                this.scanner.next(), this.values.getTrackNames().size());
        return(this.values.getAllTracks().get(String.valueOf(Integer.parseInt(input)-1)));
    }

    private int enterLength(){
        System.out.println("Select one of the following Lengths of the Race:");
        for (int i = 0; i < this.lengthOptions.length; i++) {
            this.lengths.put(String.valueOf(i+1), this.lengthOptions[i]);
        }
        this.lengths.forEach((key, value) -> System.out.printf("%-10s", "\n[" + key + "] " + value + "%\n"));
        return(this.lengths.get(
                this.createRaceUseCase.getInputValidator().validateCertainSelection(
                        this.scanner.next(), this.lengthOptions.length)));
    }

    private void enterHeader(){
        this.date = enterDate();
        while(!this.createRaceUseCase.getInputValidator().confirmInput(date.toString(""))){
            date = enterDate();
        }
        this.track = enterTrack();
        while(!this.createRaceUseCase.getInputValidator().confirmInput(track.toString())){
            track = enterTrack();
        }
        this.lengthOfRace = enterLength();
        while(!this.createRaceUseCase.getInputValidator().confirmInput(lengthOfRace + "%")){
            lengthOfRace = enterLength();
        }
    }

    private void enterScoreboard(){
        this.scoreboard = new ArrayList<>();
        this.drivers = values.getAllDrivers();
        DriverInformationsService driverInformationsService;
        for (int i = 0; i < 3; i++) {
            driverInformationsService = new DriverInformationsService(this.drivers, i+1);
            this.scoreboard.add(driverInformationsService.getDriverInformations());
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
}
