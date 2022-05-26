package dhbw.projects.useCases;

import dhbw.projects.InputValidator;
import dhbw.projects.RaceRepository;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.race.Race;

import java.util.*;

public class ShowRaceUseCase {

    private final ShowRaceService showRaceService;
    private final InputValidator inputValidator = new InputValidator();

    public ShowRaceUseCase(RaceRepository raceRepository) {
        this.showRaceService = new ShowRaceService(raceRepository);
    }

    public Map<Integer, Race> getExistingRaces(){
        List<Race> races = showRaceService.getExistingRaces();
        Map<Integer, Race> allRaces = new HashMap<>();
        for (int i = 0; i < races.size(); i++) {
            allRaces.put(i, races.get(i));
        }
        return allRaces;
    }

    public InputValidator getInputValidator() {
        return inputValidator;
    }

    public ShowRaceService getShowRaceService() {
        return showRaceService;
    }

    private String scoreboardToString(Race race){
        List<DriverInformations> scoreboard = race.getScoreboard();
        StringBuilder output = new StringBuilder();
        for (DriverInformations driverInformations: scoreboard) {
            output.append(driverInformationToString(driverInformations));
        }
        return output.toString();
    }

    private String driverInformationToString(DriverInformations driverInformations){
        String fastestLap = fastestLapToString(driverInformations.getFastestLap());
        String output = "|";
        output += String.format("%7s", "    " + driverInformations.getFinalPosition() + ".");
        output += String.format("%-24s", "..." + driverInformations.getDriver().getName());
        output += String.format("%10s", fastestLap);
        output += String.format("%6s", "  (" + driverInformations.getStartPosition() + ")");
        output += String.format("%4s", "|\n");
        return output;
    }

    private int getDecimalDigits(double number){
        int decimalDigits;
        decimalDigits = (int)((number - Math.floor(number))*1000);
        if(decimalDigits < 100) {
            if (decimalDigits < 10) {
                decimalDigits *= 100;
            } else {
                decimalDigits *= 10;
            }
        }
        return decimalDigits;
    }

    private String fastestLapToString(double fastestLap){
        String decimalDigits = String.valueOf(getDecimalDigits(fastestLap));
        String seconds = getSeconds(fastestLap);
        String minutes = String.valueOf((int) Math.floor(fastestLap/60));
        return minutes + ":" + seconds + "." + decimalDigits;
    }

    private String getSeconds(double fastestLap) {
        int seconds = (int) (Math.floor(fastestLap) % 60);
        if(seconds < 10){
            return "0" + seconds;
        }
        return String.valueOf(seconds);
    }

    public void raceToString(Race race) {
        String dateFormated = race.getDate().toString("-");
        String length = String.valueOf(race.getLengthTime());
        String trackName = race.getTrackName().toString();

        String output = " " + String.join("", Collections.nCopies(49, "_")) + "\n";
        output += "|  " + String.format("%-47s", dateFormated + ", " + length + "% " + trackName + ": ") + "|\n";
        output += this.scoreboardToString(race);
        output += "|" + String.join("", Collections.nCopies(49, "_")) + "|";


        System.out.println(output);
    }

}
