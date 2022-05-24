package dhbw.projects.data.track;

import java.util.UUID;

public class Track {

    private String name;
    private UUID trackId;

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
