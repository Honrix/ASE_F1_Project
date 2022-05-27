package dhbw.projects.data.track;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {

    @Test
    void assignAttributesOfTrack() {
        UUID uuid = UUID.randomUUID();
        Track track = new Track(uuid, "Test");
        assertEquals(track.toString(), "Test");
        assertEquals(track.getTrackId(), uuid);

    }

}