package dhbw.projects;

public class UserInputAdapter {

    private String outputString = "";

    public UserInputAdapter(){

    }

    public Boolean validateDateInput(String input) {
        Boolean valid = input.matches("^\\d{8}$");
        if(!valid){
            this.outputString = "Please Enter a valide Date (Format: YYYYMMDD)";
        } else {
            this.outputString = "Is that correct: " + input + "? [Y/N]";
        }
        return valid;
    }

    public boolean validateInputOfRange(String input, int maxValue){
        boolean valid = input.matches("^\\d+$");
        if(valid){
            return (0 < Integer.parseInt(input) && Integer.parseInt(input) <= maxValue);
        } else {
            this.outputString = ("Select A Number between [1] and [" + maxValue + "]:");
            return false;
        }
    }

    public boolean validateConfirmationInput(String input){
        boolean valid = input.equals("Y") || input.equals("N");
        if(!valid) {
            this.outputString = ("Please enter \"Y\" or \"N\"");
        }
        return valid;
    }

    public boolean confirmUserInput(String input) {
        return input.equals("Y");
    }

    public Boolean validateLaptime(String input) {
        boolean valid = input.matches("^\\d{1,3}[.]\\d{3}$");
        if(!valid) {
            this.outputString = ("Please Enter a valid Laptime (Format: XX.XXX)");
        }
        return valid;
    }

    public String getOutputString() {
        return this.outputString;
    }

}
