package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.UserInputHandler;
import dhbw.projects.actionHandler.UserOptions;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.race.Race;

import java.util.*;

public class ShowRaceAction implements UserOptions {

    private final ShowRaceUseCase showRaceUseCase;
    private final Scanner scanner = new Scanner(System.in);
    private final UserInputHandler userInputHandler;
    private Map<Integer, Race> races;
    private Map<Integer, DriverInformations> driverInformations = new HashMap<>();
    private Race selectedRace;
    private int selectedRaceKey;
    private int editSeletionKey;

    public ShowRaceAction(RaceRepository raceRepository) {
        this.showRaceUseCase = new ShowRaceUseCase(raceRepository);
        this.userInputHandler = new UserInputHandler();
    }

    private void showRace(){
        if(this.races.isEmpty()){
            System.out.println("No existing Race found");
        } else {
            System.out.println("Select one of the following Races:");
            Race race;
            String body;
            for (int i = 0; i < races.size(); i++) {
                race = races.get(i);
                body = race.getDate().toString("-") + ", " + race.getLengthTime() + "% " + race.getTrack();
                System.out.printf("%5s", "\n[" + (i + 1) + "] ");
                System.out.print(body);
            }
            System.out.println("");
            printRace(getSelectedRace());
            addEditOption();

        }
    }

    private void printRace(Race race){
        System.out.println(this.showRaceUseCase.raceToString(race));

    }

    private Race getSelectedRace() {
        this.selectedRaceKey = Integer.parseInt(this.userInputHandler.getValidInputOfRange(this.races.size()));
        this.selectedRace = this.races.get(this.selectedRaceKey-1);
        return selectedRace;
    }


    @Override
    public void initializeOption() {
        this.races = showRaceUseCase.getShowRaceService().getExistingRaces();
        showRace();
    }

    private void addEditOption(){
        System.out.println("Do You Want To Edit This Race? [Y/N]");
        if(this.userInputHandler.getUserInputAdapter().confirmUserInput(this.scanner.next())) {
            this.driverInformations = getDriverInformations();
            do {
                DriverInformations selectedDriverInformation = getEditSelection();
                while (!confirmSelectedDriverInformation(selectedDriverInformation.getDriver().getName())) {
                    selectedDriverInformation = getEditSelection();
                }
                editSelectedDriverInformations();
                System.out.println("Do You Want To Edit Another Driver? [Y/N]");
                updateRaces();
                this.selectedRace = this.races.get(this.selectedRaceKey - 1);
            } while (this.userInputHandler.getUserInputAdapter().confirmUserInput(this.scanner.next()));
            endEditMode();
        }
    }

    private void endEditMode(){
        System.out.println("New Race: ");

        printRace(selectedRace);
        System.out.println("Do you want to go back to menu? [Y/N]");
        if(!this.userInputHandler.getUserInputAdapter().confirmUserInput(this.scanner.next())){
            addEditOption();
        }
    }

    private void updateRaces(){
        List<DriverInformations> newDriverInformations = new ArrayList<>();
        for (int i = 0; i < this.driverInformations.size(); i++) {
            newDriverInformations.add(this.driverInformations.get(i+1));
        }
        overwriteRace(selectedRace, newDriverInformations);
        List<Race> updatedRaces = new ArrayList<>();
        for (int i = 0; i < this.races.size(); i++) {
            updatedRaces.add(this.races.get(i));
        }
        this.showRaceUseCase.getShowRaceService().getRaceRepository().insertRaceList(updatedRaces);
    }

    private Map<Integer, DriverInformations> getDriverInformations(){
        Map<Integer, DriverInformations> driverInformations = new HashMap<>();
        List<DriverInformations> scoreboard = this.selectedRace.getScoreboard();

        for (int i = 0; i < scoreboard.size(); i++) {
            driverInformations.put(i+1, scoreboard.get(i));
        }

        return driverInformations;
    }

    private boolean confirmSelectedDriverInformation(String input) {
        System.out.println("Is that the Driver You Want To Edit: " + input + "? [Y/N]");
        return this.userInputHandler.getUserInputAdapter().confirmUserInput(this.scanner.next());
    }

    private DriverInformations getEditSelection(){
        printRace(selectedRace);
        System.out.println("Select A Driver To Edit: [1-" + this.driverInformations.size() + "] ");
        String input = this.userInputHandler.getValidInputOfRange(this.driverInformations.size());
        this.editSeletionKey = Integer.parseInt(input);
        return this.driverInformations.get(Integer.parseInt(input));
    }

    private void editSelectedDriverInformations(){
        this.driverInformations.replace(editSeletionKey, userInputHandler.getDriverInformations(editSeletionKey));
    }

    private void overwriteRace(Race oldRace, List<DriverInformations> driverInformations){
        Race race = new Race(
                oldRace.getTrack(),
                driverInformations,
                oldRace.getLengthTime(),
                oldRace.getDate(),
                oldRace.getRaceId()
        );
        this.races.replace(this.selectedRaceKey-1, oldRace, race);

    }

    @Override
    public String getDescription() {
        return "Show/Edit An Existing Race";
    }
}
