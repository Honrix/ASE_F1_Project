package dhbw.projects.useCases;

import dhbw.projects.InputValidator;
import dhbw.projects.RaceRepository;
import dhbw.projects.data.date.Date;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.race.Race;
import dhbw.projects.data.track.Track;

import java.util.List;
import java.util.UUID;

public class CreateRaceUseCase {

    private final CreateRaceService createRaceService;
    private final InputValidator inputValidator;
    private String outputString = "";
    private Date date;
    private Track track;
    private int length;
    private List<DriverInformations> scoreboard;


    public CreateRaceUseCase(RaceRepository raceRepository) {
        this.createRaceService = new CreateRaceService(raceRepository);
        this.inputValidator = new InputValidator();
    }

    public void insertDate(String date){
        this.date = new Date(date);
    }

    public void insertTrack(Track track){
        this.track = track;
    }

    public void insertLength(int length){
        this.length = length;
    }

    public void insertScoreboard(List<DriverInformations> scoreboard){
        this.scoreboard = scoreboard;
    }

    public InputValidator getInputValidator() {
        return this.inputValidator;
    }

    public String getOutputString() {
        return this.outputString;
    }

    public void insertRace(){
        this.createRaceService.insert(this.track, this.scoreboard, this.length, this.date);
    }

    public Boolean validateDateInput(String input) {
        Boolean valid = this.inputValidator.validateDate(input);
        if(!valid){
            this.outputString = "Please Enter a valide Date (Format: YYYYMMDD)";
        } else {
            this.outputString = "Is that correct: " + input + "? [Y/N]";
        }
        return valid;
    }

    public boolean validateInputOfRange(String input, int maxValue){
        boolean valid = this.inputValidator.validateSelection(input, maxValue);
        if(!valid) {
            this.outputString = ("Select A Number between [1] and [" + maxValue + "]:");
        }
        return valid;
    }

    public boolean validateConfirmationInput(String input){
        boolean valid = this.inputValidator.validateConfirmationInput(input);
        if(!valid) {
            this.outputString = ("Please enter \"Y\" or \"N\"");
        }
        return valid;
    }

    public boolean confirmUserInput(String input) {
        return input.equals("Y");
    }

    public Boolean validateLaptime(String input) {
        boolean valid = this.inputValidator.validateLaptime(input);
        if(!valid) {
            this.outputString = ("Please Enter a valid Laptime (Format: XX.XXX)");
        }
        return valid;
    }
}
