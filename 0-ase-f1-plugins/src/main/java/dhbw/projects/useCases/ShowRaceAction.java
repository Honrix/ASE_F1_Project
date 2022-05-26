package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.actionHandler.UserOptions;
import dhbw.projects.actionHandler.Values;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.race.Race;
import dhbw.projects.driver.DriverInformationsService;

import java.util.*;

public class ShowRaceAction implements UserOptions {

    private final ShowRaceUseCase showRaceUseCase;
    private final Scanner scanner = new Scanner(System.in);
    private Map<Integer, Race> races;
    private Map<Integer, DriverInformations> driverInformations = new HashMap<>();
    private Race selectedRace;
    private int selectedRaceKey;
    private int editSeletionKey;
    private final Values values = new Values();

    public ShowRaceAction(RaceRepository raceRepository) {
        this.showRaceUseCase = new ShowRaceUseCase(raceRepository);
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
                body = race.getDate().toString("-") + ", " + race.getLengthTime() + "% " + race.getTrackName();
                System.out.printf("%5s", "\n[" + (i + 1) + "] ");
                System.out.print(body);
            }
            System.out.println("");
            printRace(getSelectedRace());
            addEditOption();

        }
    }

    private void printRace(Race race){
        this.showRaceUseCase.raceToString(race);

    }

    private Race getSelectedRace() {
        this.selectedRaceKey = this.scanner.nextInt()-1;
        this.selectedRace = this.races.get(this.selectedRaceKey);
        return selectedRace;
    }


    @Override
    public void initializeOption() {
        this.races = showRaceUseCase.getExistingRaces();
        showRace();
    }

    private void addEditOption(){
        System.out.println("Do You Want To Edit This Race? [Y/N]");
        if(handleInput(this.scanner.next())) {
            this.driverInformations = getDriverInformations();
            do {
                DriverInformations selectedDriverInformation = getEditSelection();
                while (!confirmSelectedDriverInformation(selectedDriverInformation.getDriver().getName())) {
                    selectedDriverInformation = getEditSelection();
                }
                editSelectedDriverInformations();
                System.out.println("Do You Want To Edit Another Driver? [Y/N]");
                updateRaces();
                this.selectedRace = this.races.get(this.selectedRaceKey);
            } while (handleInput(this.scanner.next()));
            endEditMode();
        }
    }

    private void endEditMode(){
        System.out.println("New Race: ");
        printRace(selectedRace);
        System.out.println("Do you want to go back to menu? [Y/N]");
        if(!handleInput(this.scanner.next())){
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
        return handleInput(this.scanner.next());
    }

    private DriverInformations getEditSelection(){
        printRace(selectedRace);
        System.out.println("Select A Driver To Edit: [1-" + this.driverInformations.size() + "] ");
        String input = this.scanner.next();
        while(!this.showRaceUseCase.getInputValidator().validateSelection(input, this.driverInformations.size())){
            input = this.scanner.next();
        }
        this.editSeletionKey = Integer.parseInt(input);
        return this.driverInformations.get(Integer.parseInt(input));
    }

    private void editSelectedDriverInformations(){
        DriverInformationsService driverInformationsService = new DriverInformationsService(
                this.values.getAllDrivers(), editSeletionKey);
        this.driverInformations.replace(editSeletionKey, driverInformationsService.getDriverInformations());
    }

    private void overwriteRace(Race oldRace, List<DriverInformations> driverInformations){
        Race race = new Race(
                oldRace.getTrackName(),
                driverInformations,
                oldRace.getLengthTime(),
                oldRace.getDate(),
                oldRace.getRaceId()
        );
        this.races.replace(this.selectedRaceKey, oldRace, race);

    }

    private boolean handleInput(String userInput){
        do {
            if (userInput.equals("Y")) {
                return true;
            } else if (userInput.equals("N")) {
                return false;
            } else {
                System.out.println("Please enter \"Y\" or \"N\"");
            }
            userInput = scanner.next();
        } while (true);
    }

    @Override
    public String getDescription() {
        return "Show/Edit An Existing Race";
    }
}
