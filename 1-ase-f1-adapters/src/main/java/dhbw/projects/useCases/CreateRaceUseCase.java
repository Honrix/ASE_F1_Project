package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.date.Date;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.track.Track;

import java.util.List;

public class CreateRaceUseCase {

    private final CreateRaceService createRaceService;
    private Date date;
    private Track track;
    private int length;
    private List<DriverInformations> scoreboard;


    public CreateRaceUseCase(RaceRepository raceRepository) {
        this.createRaceService = new CreateRaceService(raceRepository);
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

    public void insertRace(){
        this.createRaceService.insert(this.track, this.scoreboard, this.length, this.date);
    }
}
