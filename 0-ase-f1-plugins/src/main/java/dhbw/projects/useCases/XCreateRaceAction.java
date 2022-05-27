/*package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.actionHandler.UserOptions;
import dhbw.projects.values.ValuesImpl;
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
    private ValuesImpl valuesImpl;

    public CreateRaceAction(RaceRepository raceRepository){
        this.createRaceUseCase = new CreateRaceUseCase(raceRepository);
    }

    @Override
    public void initializeOption() {
        this.valuesImpl = new ValuesImpl();
        enterHeader();
        enterScoreboard();
        this.race = new Race(this.track, this.scoreboard, this.lengthOfRace, this.date, UUID.randomUUID());
        this.createRaceUseCase.insert(this.race);
        System.out.println("You have entered all information. Your race of " + this.date.toString("") + " has been saved!\n\n\n");

    }

    private void enterScoreboard(){
        this.scoreboard = new ArrayList<>();
        this.drivers = valuesImpl.getDrivers();
        DriverInformationsService driverInformationsService;
        for (int i = 0; i < 3; i++) {
            driverInformationsService = new DriverInformationsService(this.drivers, i+1);
            this.scoreboard.add(driverInformationsService.getDriverInformations());
        }
    }

}*/
