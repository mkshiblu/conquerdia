package ca.concordia.encs.conquerdia.engine.map;

import java.util.HashSet;
import java.util.Set;

public class WorldMap {
    private final Set<Continent> continents = new HashSet<>();

    public Set<Continent> getContinents() {
        return continents;
    }
}
