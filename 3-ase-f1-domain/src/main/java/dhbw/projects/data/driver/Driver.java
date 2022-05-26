package dhbw.projects.data.driver;

import dhbw.projects.data.nation.Nation;
import dhbw.projects.data.team.Team;

public class Driver {

    private final DriverId driverId;
    private final String name;
    private final Nation nation;
    private final Team team;

    public Driver(DriverId driverId, String name, Nation nation, Team team) {
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
