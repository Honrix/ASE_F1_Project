package dhbw.projects.actionHandler;

import dhbw.projects.RaceRepository;
import dhbw.projects.race.RaceRepositoryImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu implements Observer {

    private final Map<String, UserOptions> userOptions = new HashMap<>();
    private final Scanner scanner;
    private String description;

    public Menu(String descriptionOfMenu){
        this.scanner = new Scanner(System.in);
        initializeMenu(descriptionOfMenu);
    }

    private void initializeMenu(String description){
        this.description = description;
    }

    public void insertUserOption(String key, UserOptions userOption){
        this.userOptions.put(key, userOption);
    }

    private UserOptions getUserOption(String key){
        return this.userOptions.get(key);
    }

    private void printUserOptions(){
        addExitOption();
        this.userOptions.forEach((key, userOptions) -> System.out.println("[" + key + "] " + userOptions.getDescription()));
    }

    public void start(){
        while(true){
            printUserOptions();
            String input = scanner.next();
            if(input.equals("E")){
                break;
            }
            UserOptions selectedOption = getUserOption(input);
            if(selectedOption != null){
                System.out.println("\n\n\n");
                selectedOption.initializeOption();
            }
        }
    }

    @Override
    public void addExitOption() {
        System.out.println("Select an option" +
                String.join("", Collections.nCopies(100, "-")) + "[E] for Exit");
    }
}
