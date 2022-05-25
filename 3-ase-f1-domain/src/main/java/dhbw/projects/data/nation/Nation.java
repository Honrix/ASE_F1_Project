package dhbw.projects.data.nation;

import java.util.UUID;

public class Nation {

    private String shortName;
    private String fullName;
    private UUID nationId;

    public Nation (UUID uuid, String shortName, String nationName){
        this.shortName = shortName;
        this.fullName = nationName;
        this.nationId = uuid;
    }

    public UUID getNationId() {
        return nationId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }
}
