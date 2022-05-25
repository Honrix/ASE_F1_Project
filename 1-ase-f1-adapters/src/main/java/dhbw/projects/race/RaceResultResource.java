package dhbw.projects.race;

import dhbw.projects.Driver.DriverStats;
import dhbw.projects.newRace.RaceService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceResultResource {

    private RaceService raceService;
    private List<String> raceResultOutputs = new ArrayList<>();

    public RaceResultResource(RaceService raceService){
        this.raceService = raceService;
        //raceResultOutputs = generateOutput(raceService);
    }

    /*public List<String> getRaceResultOutputs() {
        return raceResultOutputs;
    }

    private List<String> generateOutput(RaceService raceService){
        List<String> strings = new ArrayList<>();

        String title = raceResult.getRace().getDate().toString() + ", " + raceResult.getRace().getLengthTime() + "% " + raceResult.getRace().getTrackName();
        String output = " " + String.join("", Collections.nCopies(49, "_")) + "\n";

        output += "|  " +
                String.format("%-47s", raceResult.getRace().getDate().toFormatedString() + ", " + raceResult.getRace().getLengthTime()
                        + "% " + raceResult.getRace().getTrackName() + ": ") +
                "|";

        String dateAsString = "";
        double fastestLap;
        int decimalDigits;

        for (DriverStats driverStat: raceResult.getLeaderboard()) {
            fastestLap = driverStat.getFastestLap();

            decimalDigits = (int)((fastestLap - Math.floor(fastestLap))*1000);

            if(decimalDigits < 100) {
                if (decimalDigits < 10) {
                    decimalDigits *= 100;
                } else {
                    decimalDigits *= 10;
                }
            }

            dateAsString = (int) Math.floor(fastestLap/60) + ":" +
                    (int) (Math.floor(fastestLap) % 60) + "." + (decimalDigits <= 0? "000" : decimalDigits+1);

            output += "\n|";
            output += String.format("%7s", "    " + driverStat.getFinalPosition() + ".");
            output += String.format("%-24s", "..." + driverStat.getName());
            output += String.format("%10s", dateAsString);
            output += String.format("%4s", "(" + driverStat.getStartPosition() + ")");
            output += String.format("%5s", "|");
        }
        output += "\n|" + String.join("", Collections.nCopies(49, "_")) + "|";

        strings.add(title);
        strings.add(output);

        return strings;
    }*/

}
