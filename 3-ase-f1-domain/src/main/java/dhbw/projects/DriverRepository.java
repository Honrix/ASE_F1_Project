package dhbw.projects;

import dhbw.projects.data.Driver;
import dhbw.projects.data.DriverId;

import java.util.List;

public interface DriverRepository {
    void insert(Driver driver);
    List<Driver> getAll();
    Driver getById(DriverId driverId);
}
