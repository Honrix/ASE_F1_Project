package dhbw.projects.data.driver;

import dhbw.projects.data.nation.Nation;
import dhbw.projects.data.Team;

public class Driver {

    /*
    VERSTAPPEN ("Max Verstappen", Nation.NED, Team.RED_BULL),
    HAMILTON ("Lewis Hamilton", Nation.GBR, Team.MERCEDES),
    BOTTAS ("Valtteri Bottas", Nation.FIN, Team.MERCEDES),
    ALONSO ("Fernando Alonso", Nation.ESP, Team.ALPINE),
    VETTEL ("Sebastian Vettel", Nation.GER, Team.ASTON_MARTIN),
    LECLERC ("Charles Leclerc", Nation.MON, Team.FERRARI),
    NORRIS ("Lando Norris", Nation.GBR, Team.MCLAREN),
    SAINZ ("Carlos Sainz", Nation.ESP, Team.FERRARI),
    RICCIARDO ("Daniel Ricciardo", Nation.AUS, Team.MCLAREN),
    OCON ("Esteban Ocon", Nation.FRA, Team.ALPINE),
    GASLY ("Pierre Gasly", Nation.FRA, Team.ALPHATAURI),
    TSUNODA ("Yuki Tsunoda", Nation.JPN, Team.ALPHATAURI),
    PEREZ ("Sergio Perez", Nation.MEX, Team.RED_BULL),
    STROLL ("Lance Stroll", Nation.CAN, Team.ASTON_MARTIN),
    RAIKKONEN ("Kimi Raikkonen", Nation.FIN, Team.ALFA_ROMEO),
    GIOVINAZZI ("Antonio Giovinazzi", Nation.ITA, Team.ALFA_ROMEO),
    MAZEPIN ("Nikita Mazepin", Nation.RUS, Team.HAAS),
    SCHUMACHER ("Mick Schumacher", Nation.GER, Team.HAAS),
    RUSSELL ("George Russell", Nation.GBR, Team.WILLIAMS),
    LATIFI ("Nicholas Latifi", Nation.CAN, Team.WILLIAMS);*/

    private DriverId driverId;
    private String name;
    private Nation nation;
    private Team team;

    Driver(DriverId driverId, String name, Nation nation, Team team) {
        this.driverId = driverId;
        this.name = name;
        this.nation = nation;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public DriverId getDriverId() {
        return driverId;
    }
}
