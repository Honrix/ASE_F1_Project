package dhbw.projects;

import dhbw.projects.actionHandler.MainMenu;
import dhbw.projects.actionHandler.Menu;


public class Main {

    public static void main(String[] args) throws Exception {

        MainMenu menu = new MainMenu("MainMenu");
        menu.start();

        /*List<String> trackNames = new ArrayList<>();
        for (Track track: tracks.getAll()){
            trackNames.add(track.toString());
        }
        List<String> teamNames = new ArrayList<>();
        for (Team team: teams.getAll()){
            teamNames.add(team.toString());
        }
        List<String> driverNames = new ArrayList<>();
        for (Driver driver: drivers.getAll()){
            driverNames.add(driver.getName());
        }

        System.out.println("");

        DriverStats driverStats1 = new DriverStats(drivers.getById(new DriverId(33)), 3, 1, 90.000);
        DriverStats driverStats2 = new DriverStats(drivers.getById(new DriverId(44)), 1, 3, 95.333);
        DriverStats driverStats3 = new DriverStats(drivers.getById(new DriverId(5)), 5, 4, 95.323);
        DriverStats driverStats4 = new DriverStats(drivers.getById(new DriverId(16)), 4, 2, 91.335);

        List<DriverStats> stats = new ArrayList<>();
        stats.add(driverStats1);
        stats.add(driverStats2);
        stats.add(driverStats3);
        stats.add(driverStats4);

        DriverStatsService service = new DriverStatsService(stats);

        RaceResult race1 = new RaceResult(
                tracks.getAll().get(0),
                service.getDriverStats(),
                50,
                new Date("20220524"),
                UUID.randomUUID()
        );
        RaceResultResource raceResultResource = new RaceResultResource(race1);
        RaceResultOutput raceResultOutput = new RaceResultOutput(raceResultResource);

        IOController newDialogue = new IOController(UUID.randomUUID());
        Message helloMessage = new Message("Willkommen zu diesem Test", UUID.randomUUID());
        newDialogue.createNewMessage(helloMessage);
        Message auswahl = new Message("Was willst du machen? \n" + "[1] Neues Rennen anlegen  [2] Bestehendes Rennen anschauen", UUID.randomUUID());
                newDialogue.createNewMessage(auswahl);
        newDialogue.newInput();
        System.out.println(newDialogue.getLastMessage().getMessageText());

        if(newDialogue.getLastMessage().getMessageText().equals("1")){
            sortedOutput(trackNames, "Alle Tracks");
            sortedOutput(teamNames, "Alle Teams");
            sortedOutput(driverNames, "Alle Fahrer");

        } else if (newDialogue.getLastMessage().getMessageText().equals("2")){
            newDialogue.createNewMessage(new Message(raceResultOutput.toString(), UUID.randomUUID()));
        } else {
            System.out.println("Falsche Eingabe!");
            }*/

    }

}
