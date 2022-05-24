package dhbw.projects;

import dhbw.projects.data.nation.Nation;

import java.util.List;
import java.util.UUID;

public interface NationRepository {
    void insert(Nation nation);
    List<Nation> getAll();
    Nation getById(UUID nationId);
}
