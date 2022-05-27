package dhbw.projects.values;

import dhbw.projects.ValuesRepository;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class ValuesServiceTest {

    @Test
    public void insertObjectTest(){
        ValuesRepository valuesRepository = mock(ValuesRepository.class);
        String driverName = "TestDriver";
        int driverId = 10;
        String nation = "TestNation";
        String team = "TestTeam";
        String track = "TestTrack";
        valuesRepository.insertTrack(track);
        valuesRepository.insertTeam(team);
        valuesRepository.insertNation(nation);
        valuesRepository.insertDriver(driverId, driverName, nation, team);
        verify(valuesRepository).insertDriver(driverId, driverName, nation, team);
        verify(valuesRepository).insertTrack(track);
        verify(valuesRepository).insertTeam(team);
        verify(valuesRepository).insertNation(nation);

    }

}