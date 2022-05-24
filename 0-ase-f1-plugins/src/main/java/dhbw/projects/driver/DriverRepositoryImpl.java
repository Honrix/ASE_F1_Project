package dhbw.projects.driver;

import dhbw.projects.DriverRepository;
import dhbw.projects.data.driver.Driver;
import dhbw.projects.data.driver.DriverId;

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
        for (Driver driver: drivers){
            if(driver.getDriverId().id() == driverId.id()){
                return driver;
            }
        }
        return null;
    }

}
