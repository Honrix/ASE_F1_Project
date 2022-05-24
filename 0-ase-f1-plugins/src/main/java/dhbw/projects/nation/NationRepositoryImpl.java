package dhbw.projects.nation;

import dhbw.projects.NationRepository;
import dhbw.projects.data.nation.Nation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NationRepositoryImpl implements NationRepository {

    private final List<Nation> nations = new ArrayList<>();
    @Override
    public void insert(Nation nation) {
        nations.add(nation);
    }

    @Override
    public List<Nation> getAll() {
        return nations;
    }

    @Override
    public Nation getById(UUID nationId) {
        return nations.stream().filter(nation -> nation.getNationId() == nationId).toList().get(0);
    }
}
