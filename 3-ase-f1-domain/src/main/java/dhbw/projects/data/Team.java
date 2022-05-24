package dhbw.projects.data;

public class Team {

    /*
    MERCEDES ("Mercedes-AMG Petronas"),
    FERRARI ("Ferrari"),
    RED_BULL ("Red Bull Racing"),
    MCLAREN ("McLaren"),
    ALPINE ("Alpine"),
    ALPHATAURI ("AlphaTauri"),
    ASTON_MARTIN ("Aston Martin"),
    ALFA_ROMEO ("Alfa Romeo Racing"),
    HAAS ("Haas"),
    WILLIAMS ("Williams");*/

    private String name;

    Team(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

}
