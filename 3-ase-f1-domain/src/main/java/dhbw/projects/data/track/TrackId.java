package dhbw.projects.data.track;

public record TrackId (int id) {

    public TrackId{
        if(id< 0||id>99){
        throw new IllegalArgumentException("Illegal TrackId");
        }
    }
}
