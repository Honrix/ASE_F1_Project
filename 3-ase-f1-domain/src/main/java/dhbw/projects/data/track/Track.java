package dhbw.projects.data.track;

import java.util.UUID;

public class Track {

    private final String name;
    private final UUID trackId;

    public Track(UUID uuid, String name) {

        this.name = name;
        this.trackId = uuid;
    }

    public String toString() {
        return name;
    }

    public UUID getTrackId() {
        return trackId;
    }

}
