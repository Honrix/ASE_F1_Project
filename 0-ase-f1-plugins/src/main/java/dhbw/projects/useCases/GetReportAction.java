package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.actionHandler.UserOptions;
import dhbw.projects.values.ValuesImpl;
import dhbw.projects.data.driver.Driver;

import java.util.*;

public class GetReportAction implements UserOptions {

    private final GetReportUseCase getReportUseCase;
    private final Scanner scanner = new Scanner(System.in);
    private Object[] totalPoints;
    private final ValuesImpl valuesImpl = new ValuesImpl();
    private Map<String, Driver> drivers = new HashMap<>();

    public GetReportAction(RaceRepository raceRepository){
        this.getReportUseCase = new GetReportUseCase(raceRepository, this.drivers);
    }

    @Override
    public void initializeOption() {
        System.out.println("Do You want to get a ranking of all drivers? [Y/N]");
        if(handleInput(this.scanner.next())){
            this.drivers = valuesImpl.getDrivers();
            getTotalPoints();
            printTotalPoints();
        }
    }

    private void getTotalPoints(){
        totalPoints = this.getReportUseCase.listOfTotalPoints();
    }

    private void printTotalPoints() {
        System.out.println(" " + String.join("", Collections.nCopies(49, "_")) + "");
        System.out.println("|  " + String.format("%-47s", "Gesamtpunkte der Fahrer") + "|");
        int i = 1;
        for (Object e : this.totalPoints) {
            System.out.print("|" + String.format("%7s", "    " + i + "."));
            System.out.printf("%-24s", "..." +((Map.Entry<String, Integer>) e).getKey());
            System.out.printf("%6s", ((Map.Entry<String, Integer>) e).getValue());
            System.out.printf("%14s", "|\n");
            i++;
        }
        System.out.println("|" + String.join("", Collections.nCopies(49, "_")) + "|");
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
        return "Get Report";
    }
}
