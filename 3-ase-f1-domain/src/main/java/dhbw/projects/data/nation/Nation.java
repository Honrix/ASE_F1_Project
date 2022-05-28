package dhbw.projects.data.nation;

import java.util.UUID;

public class Nation {

    private final String name;
    private final UUID nationId;

    public Nation (UUID uuid, String name){
        this.name = name;
        this.nationId = uuid;
    }

    public UUID getNationId() {
        return nationId;
    }

    public String getName() {
        return name;
    }
}
