package dhbw.projects;

import dhbw.projects.data.track.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TrackRepositoryImpl implements TrackRepository{

    private final List<Track> tracks = new ArrayList<>();
    @Override
    public void insert(Track track) {
        tracks.add(track);
    }

    @Override
    public List<Track> getAll() {
        return tracks;
    }

    @Override
    public Track getById(UUID trackId) {
        return tracks.stream().filter(track -> track.getTrackId() == trackId).toList().get(0);
    }
}
