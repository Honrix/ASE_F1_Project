package dhbw.projects.race;

import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.useCases.RaceService;

import java.util.ArrayList;
import java.util.List;

public class RaceResultResource {

    private RaceService raceService;
    private List<String> raceResultOutputs = new ArrayList<>();

    public RaceResultResource(RaceService raceService){
        this.raceService = raceService;
    }

    public String scoreboardToString(){
        List<DriverInformations> scoreboard = raceService.getRace().getScoreboard();
        String output = "";

        for (DriverInformations driverInformations: scoreboard) {
            String fastestLap = fastestLapToString(driverInformations.getFastestLap());

            output += "\n|";
            output += String.format("%7s", "    " + driverInformations.getFinalPosition() + ".");
            output += String.format("%-24s", "..." + driverInformations.getDriver().getName());
            output += String.format("%10s", fastestLap);
            output += String.format("%4s", "(" + driverInformations.getStartPosition() + ")");
            output += String.format("%5s", "|");
        }

        return  output;

    }

    private String fastestLapToString(double fastestLap){
        int decimalDigits;
        String output;

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

}
