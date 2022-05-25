package dhbw.projects.actionHandler;

import dhbw.projects.useCases.CreateRaceAction;
import dhbw.projects.useCases.ObjectView;

public class MainMenu extends Menu {

    public MainMenu(String descriptionOfMenu) {
        super(descriptionOfMenu);
        this.insertUserOption("1", new ObjectView());
        this.insertUserOption("2", new CreateRaceAction());
    }



    /*private final Map<String, UserOptions> userOptions = new HashMap<>();
    private IOController dialogue;
    private Scanner scanner;
    private Values values;
    private ExampleData exampleData;

    public MainMenu() throws Exception {
        initializeMenu();
        this.dialogue = new IOController(UUID.randomUUID());
        scanner = new Scanner(System.in);
    }

    private void initializeMenu() throws Exception {
        this.values = new Values();
        this.exampleData = new ExampleData(values.getDrivers(), values.getTracks().getAll());

        addExitOption();
        System.out.println(
                "WELCOME TO YOUR PERSONAL F1 2021 RACE MANAGER!" + "\n\n" +
                "Choose one option to continue your race..."
        );

        for (UserOptions userOption: userOptions.values()){

        }


    }

    public void start(){
        boolean exit = false;
        while(!exit){
            String input = scanner.next();
            if(input.equals("E")){
                exit = true;
            } else if (input.equals("1")) {
                for (int i = 0; i < values.getAllValues().size(); i++) {
                    this.values.sortedOutput(values.getAllValues().get(i), values.getHeaders().get(i));
                }
            } else if (input.equals("2")) {
                RaceResultAction raceResultAction = new RaceResultAction(exampleData.getRaceResultResource());
            }
        }
    }

    @Override
    public void addExitOption() {
        System.out.println(String.join("", Collections.nCopies(110, "-")) + "[E] for Exit");
    }*/
}
