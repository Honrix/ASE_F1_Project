package dhbw.projects.data;

public record DriverId(int id) {

    public DriverId {
        if (id < 0 || id > 99) {
            throw new IllegalArgumentException("du bist dumm");
        }
    }

}
