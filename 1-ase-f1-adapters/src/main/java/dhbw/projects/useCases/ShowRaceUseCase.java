package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.race.Race;

import java.util.*;

public class ShowRaceUseCase {

    private final ShowRaceService showRaceService;

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

    public ShowRaceService getShowRaceService() {
        return showRaceService;
    }

    public String scoreboardToString(Race race){
        List<DriverInformations> scoreboard = race.getScoreboard();
        String output = "";

        for (DriverInformations driverInformations: scoreboard) {
            String fastestLap = fastestLapToString(driverInformations.getFastestLap());
            output += "|";
            output += String.format("%7s", "    " + driverInformations.getFinalPosition() + ".");
            output += String.format("%-24s", "..." + driverInformations.getDriver().getName());
            output += String.format("%10s", fastestLap);
            output += String.format("%6s", "  (" + driverInformations.getStartPosition() + ")");
            output += String.format("%4s", "|\n");
        }

        return  output;

    }

    private String fastestLapToString(double fastestLap){
        int decimalDigits;

        decimalDigits = (int)((fastestLap - Math.floor(fastestLap))*1000);

        if(decimalDigits < 100) {
            if (decimalDigits < 10) {
                decimalDigits *= 100;
            } else {
                decimalDigits *= 10;
            }
        }

        return (int) Math.floor(fastestLap/60) + ":" + (int) (Math.floor(fastestLap) % 60) + "." +
                (decimalDigits <= 0? "000" : decimalDigits+1);

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

    public boolean validateSelection(String input, int maxValue){
        if(input.matches("^\\d+$")) {
            return (0 < Integer.parseInt(input) && Integer.parseInt(input) <= maxValue);
        } else {
            return false;
        }
    }
}
