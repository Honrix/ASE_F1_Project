package dhbw.projects;

import dhbw.projects.data.Driver;
import dhbw.projects.data.DriverId;

import java.util.ArrayList;
import java.util.List;

public class DriverRepositoryImpl implements DriverRepository {

    private final List<Driver> drivers = new ArrayList<>();

    @Override
    public void insert(Driver driver) {
        drivers.add(driver);
    }

    @Override
    public List<Driver> getAll() {
        return drivers;
    }

    @Override
    public Driver getById(DriverId driverId) {
        return drivers.stream().filter(driver -> driver.getDriverId() == driverId).toList().get(0);
    }

}
