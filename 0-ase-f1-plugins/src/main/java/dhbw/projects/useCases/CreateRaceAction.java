package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.UserInputHandler;
import dhbw.projects.actionHandler.UserOptions;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.track.Track;

import java.util.*;

public class CreateRaceAction implements UserOptions {

    private final CreateRaceUseCase createRaceUseCase;
    private final UserInputHandler userInputHandler;

    public CreateRaceAction(RaceRepository raceRepository){
        this.createRaceUseCase = new CreateRaceUseCase(raceRepository);
        this.userInputHandler = new UserInputHandler();
    }

    @Override
    public void initializeOption() {
        System.out.println("Follow the instructions to create a new Race!");
        enterHeader();
        enterScoreboard();
        this.createRaceUseCase.insertRace();
        System.out.println("You have entered all information. Your race has been saved!\n\n\n");
    }

    private void enterHeader(){
        enterDate(this.userInputHandler.getDate());
        enterTrack(this.userInputHandler.getTrack());
        enterLength(this.userInputHandler.getLength());
    }

    private void enterScoreboard(){
        List<DriverInformations> scoreboard = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            scoreboard.add(this.userInputHandler.getDriverInformations(i+1));
        }
        this.createRaceUseCase.insertScoreboard(scoreboard);
    }

    private void enterDate(String dateInput) {
        this.createRaceUseCase.insertDate(dateInput);
    }

    private void enterTrack(Track track) {
        this.createRaceUseCase.insertTrack(track);
    }

    private void enterLength(int length){
        this.createRaceUseCase.insertLength(length);

    }

    @Override
    public String getDescription() {
        return "Create A New Race";
    }
}
