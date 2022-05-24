package dhbw.projects.data.driver;

public record DriverId(int id) {

    public DriverId {
        if (id < 0 || id > 99) {
            throw new IllegalArgumentException("Illegal DriverId");
        }
    }

}
