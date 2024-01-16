package org.algorithms.grokkingbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DijkstraAlgorithmTest {
    private DijkstraAlgorithm.Direction aToFinal = new DijkstraAlgorithm.Direction(DijkstraAlgorithm.Location.F, 1, List.of());
    private DijkstraAlgorithm.Direction initialToA = new DijkstraAlgorithm.Direction(DijkstraAlgorithm.Location.A, 6, List.of(aToFinal));
    private DijkstraAlgorithm.Direction bToFinal = new DijkstraAlgorithm.Direction(DijkstraAlgorithm.Location.B, 5, List.of());
    private DijkstraAlgorithm.Direction bToA = new DijkstraAlgorithm.Direction(DijkstraAlgorithm.Location.A, 3, List.of(aToFinal));
    private DijkstraAlgorithm.Direction initialToB = new DijkstraAlgorithm.Direction(DijkstraAlgorithm.Location.B, 2, List.of(bToFinal, bToA));
    private DijkstraAlgorithm.Direction initial = new DijkstraAlgorithm.Direction(DijkstraAlgorithm.Location.F, 0, List.of(initialToA, initialToB));

    @Test
    void test1() {
        Assertions.assertEquals(6, DijkstraAlgorithm.SHORTEST_PATH_BASED_ON_WEIGHT.applyAsInt(initial));
    }
}
