package dhbw.projects.actionHandler;

import dhbw.projects.RaceRepository;
import dhbw.projects.race.RaceRepositoryImpl;
import dhbw.projects.useCases.CreateRaceAction;
import dhbw.projects.useCases.ObjectView;
import dhbw.projects.useCases.ShowRaceAction;

public class MainMenu extends Menu {

    private final RaceRepository raceRepository = new RaceRepositoryImpl();

    public MainMenu(String descriptionOfMenu) {
        super(descriptionOfMenu);
        this.insertUserOption("1", new ObjectView());
        this.insertUserOption("2", new CreateRaceAction(raceRepository));
        this.insertUserOption("3", new ShowRaceAction(raceRepository));
    }
}
