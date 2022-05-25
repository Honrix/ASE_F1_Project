package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.actionHandler.UserOptions;
import dhbw.projects.data.race.Race;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class ShowRaceAction implements UserOptions {

    private final ShowRaceUseCase showRaceUseCase;
    private final Scanner scanner = new Scanner(System.in);
    private Map<Integer, Race> races;

    public ShowRaceAction(RaceRepository raceRepository) {
        this.showRaceUseCase = new ShowRaceUseCase(raceRepository);
    }

    private void printRaces(){
        if(this.races.isEmpty()){
            System.out.println("No existing Race found");
        } else {
            System.out.println("Select one of the following Races:");
            Race race;
            String body;
            for (int i = 0; i < races.size(); i++) {
                race = races.get(i);
                body = race.getDate().toString("-") + ", " + race.getLengthTime() + "% " + race.getTrackName();
                System.out.printf("%5s", "\n[" + (i + 1) + "] ");
                System.out.print(body);
            }
            System.out.println("");
            printSelectedRace(getSelectedRace());

        }
    }

    private void printSelectedRace(Race race){
        this.showRaceUseCase.raceToString(race);

    }

    @Override
    public void initializeOption() {
        this.races = showRaceUseCase.getExistingRaces();
        printRaces();
    }

    private Race getSelectedRace() {
        return this.races.get(this.scanner.nextInt()-1);
    }

    @Override
    public String getDescription() {
        return "Show An Existing Race";
    }

    @Override
    public void closeAction() {
        scanner.close();
    }
}
