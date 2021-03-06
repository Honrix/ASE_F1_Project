package dhbw.projects.actionHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu implements Observer {

    private final Map<String, UserOptions> userOptions = new HashMap<>();
    private final Scanner scanner;
    private final String seperator = String.join("", Collections.nCopies(124, "="));
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

    public UserOptions getUserOption(String key){
        return this.userOptions.get(key);
    }

    private void printUserOptions(){
        addExitOption();
        this.userOptions.forEach((key, userOptions) ->
                System.out.println("    [" + key + "] " + userOptions.getDescription()));
    }

    public void start(){
        while(true){
            printUserOptions();
            System.out.println(this.seperator);
            String input = this.scanner.next();
            if(input.equals("E")){
                break;
            }
            UserOptions selectedOption = getUserOption(input);
            if(selectedOption != null){
                selectedOption.initializeOption();
            }
        }
    }

    @Override
    public void addExitOption() {
        System.out.println("Select an Option" +
                String.join("", Collections.nCopies(96, "=")) + "[E] for Exit");
    }
}
