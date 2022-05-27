package dhbw.projects.data.driver;

public class DriverId {

    private final int id;

    public DriverId(int id) {
        if (id < 1 || id > 99) {
            throw new IllegalArgumentException("Illegal DriverId");
        }
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
