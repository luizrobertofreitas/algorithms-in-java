package org.algorithms.grokkingbook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;

public final class DijkstraAlgorithm {

    private DijkstraAlgorithm() {}

    public static final ToIntFunction<Direction> SHORTEST_PATH_BASED_ON_WEIGHT = initial -> {
        final Map<Location, Integer> costs = new HashMap<>(Map.of(
                Location.A, -1,
                Location.B, -1,
                Location.F, -1
        ));
        initial.neighbors.forEach(nei -> {
            costs.put(nei.location, nei.cost);
        });
        return 0;
    };

    public record Location(String name) {
        public static final Location A = new Location("A");
        public static final Location B = new Location("B");
        public static final Location I = new Location("I");
        public static final Location F = new Location("F");
    }
    public record Direction(Location location, Integer cost, List<Direction> neighbors) {}
}
