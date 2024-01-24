package org.algorithms.grokkingbook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public final class DijkstraAlgorithm {

    private DijkstraAlgorithm() {}

    public static final ToIntFunction<Direction> SHORTEST_PATH_BASED_ON_WEIGHT = initial -> {
        final Map<Location, Integer> costs = new HashMap<>(Map.of(
                Location.A, Integer.MAX_VALUE,
                Location.B, Integer.MAX_VALUE,
                Location.F, Integer.MAX_VALUE
        ));
        final Map<Location, Location> parents = new HashMap<>();
        initial.neighbors.forEach(nei -> {
            costs.put(nei.location, nei.cost);
            parents.put(initial.location, nei.location);
        });
        System.out.println(costs);
        System.out.println(parents);
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
