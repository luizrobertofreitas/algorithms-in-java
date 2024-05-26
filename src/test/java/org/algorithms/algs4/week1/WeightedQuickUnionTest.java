package org.algorithms.algs4.week1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeightedQuickUnionTest {

    @Test
    void test() {
        final int[] array = UnionFind.REFLEXIVE_ARRAY_GENERATOR.apply(30);
        final WeightedQuickUnion wqu = new WeightedQuickUnion(array);
        assertTrue(wqu.connected(1, 1));
        assertFalse(wqu.connected(7, 6));
        assertThrows(IllegalArgumentException.class, () -> wqu.connected(50, 44));
        wqu.union(1, 8);
        assertTrue(wqu.connected(1, 8));
        wqu.union(3, 4);
        assertTrue(wqu.connected(3, 4));
        wqu.union(4, 9);
        assertTrue(wqu.connected(3, 9));
        wqu.union(9, 1);
        assertTrue(wqu.connected(8, 9));
        assertTrue(wqu.connected(4, 8));
        assertTrue(wqu.connected(3, 1));
        assertTrue(wqu.connected(1, 4));
        wqu.union(10, 1);
        wqu.union(20,10);
        wqu.union(4, 25);
        assertTrue(wqu.connected(20, 1));
        System.out.println(wqu);
        assertTrue(wqu.connected(4, 10));
        assertTrue(wqu.connected(8, 20));
        System.out.println(wqu.weightedArrayToString());
    }
}
