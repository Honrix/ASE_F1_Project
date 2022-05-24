package dhbw.projects;

import dhbw.projects.data.track.Track;

import java.util.List;
import java.util.UUID;

public interface TrackRepository {
    void insert(Track track);
    List<Track> getAll();
    Track getById(UUID trackId);
}
