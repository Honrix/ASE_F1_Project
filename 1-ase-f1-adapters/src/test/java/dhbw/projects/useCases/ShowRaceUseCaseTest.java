package dhbw.projects.useCases;

import dhbw.projects.RaceRepository;
import dhbw.projects.data.date.Date;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.driver.DriverId;
import dhbw.projects.data.driver.DriverInformations;
import dhbw.projects.data.nation.Nation;
import dhbw.projects.data.race.Race;
import dhbw.projects.data.team.Team;
import dhbw.projects.data.track.Track;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ShowRaceUseCaseTest {

    @Test
    void getShowRaceService() {
        RaceRepository raceRepository = mock(RaceRepository.class);
        ShowRaceUseCase showRaceUseCase = new ShowRaceUseCase(raceRepository);
        assertEquals(ShowRaceService.class, showRaceUseCase.getShowRaceService().getClass());
    }

    @Test
    void raceToString() {
        RaceRepository raceRepository = mock(RaceRepository.class);
        ShowRaceUseCase showRaceUseCase = new ShowRaceUseCase(raceRepository);
        List<DriverInformations> driverInformations = new ArrayList<>();
        DriverId driverId = mock(DriverId.class);
        Nation nation = mock(Nation.class);
        Team team = mock(Team.class);
        Driver driver = new Driver(driverId, "Max Verstappen", nation, team);
        DriverInformations driverInformations1 = new DriverInformations(driver, 1, 1, 12.123);
        DriverInformations driverInformations2 = new DriverInformations(driver, 2, 2, 62.113);
        DriverInformations driverInformations3 = new DriverInformations(driver, 3, 3, 22.246);
        driverInformations.add(driverInformations1);
        driverInformations.add(driverInformations2);
        driverInformations.add(driverInformations3);
        Date date = new Date("20220523");
        Track track = new Track(UUID.randomUUID(), "Bahrain");
        Race race = new Race(track, driverInformations, 25, date, UUID.randomUUID());
        assertEquals(
                " _________________________________________________\n" +
                        "|  2022-05-23, 25% Bahrain:                       |\n" +
                        "|     1....Max Verstappen         0:12.122   (1)  |\n" +
                        "|     2....Max Verstappen         1:02.112   (2)  |\n" +
                        "|     3....Max Verstappen         0:22.245   (3)  |\n" +
                        "|_________________________________________________|",
                showRaceUseCase.raceToString(race));
    }
}