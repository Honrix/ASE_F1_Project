package dhbw.projects;

import java.util.Scanner;

public class InputValidator {

    private final Scanner scanner;

    public InputValidator(){
        scanner = new Scanner(System.in);
    }

    public boolean confirmInput(String input) {
        System.out.println("Is that correct: " + input + "? [Y/N]");
        String userInput = scanner.next();
        do{
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

    public boolean validateLaptime(String date){
        return date.matches("^\\d{1,3}[.]\\d{3}$");
    }

    public boolean validateSelection(String input, int maxValue){
        if(input.matches("^\\d+$")) {
            return (0 < Integer.parseInt(input) && Integer.parseInt(input) <= maxValue);
        } else {
            return false;
        }
    }

    public String validateCertainSelection(String input, int maxValue){
        while(!validateSelection(input, maxValue)){
            System.out.println("Select A Number between [1] and [" + maxValue + "]:");
            input = this.scanner.next();
        }
        return input;
    }

    public boolean validateDate(String date){
        return date.matches("^\\d{8}$");
    }

}
