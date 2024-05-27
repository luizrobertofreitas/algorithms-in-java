package org.algorithms.algs4.week1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightedQuickUnionPathCompressionTest {

    @Test
    void test() {
        final int[] array = UnionFind.REFLEXIVE_ARRAY_GENERATOR.apply(30);
        final WeightedQuickUnionPathCompression wqupc = new WeightedQuickUnionPathCompression(array);
        assertTrue(wqupc.connected(1, 1));
        assertFalse(wqupc.connected(7, 6));
        assertThrows(IllegalArgumentException.class, () -> wqupc.connected(50, 44));
        wqupc.union(1, 8);
        assertTrue(wqupc.connected(1, 8));
        wqupc.union(3, 4);
        assertTrue(wqupc.connected(3, 4));
        wqupc.union(4, 9);
        assertTrue(wqupc.connected(3, 9));
        wqupc.union(9, 1);
        assertTrue(wqupc.connected(8, 9));
        assertTrue(wqupc.connected(4, 8));
        assertTrue(wqupc.connected(3, 1));
        assertTrue(wqupc.connected(1, 4));
        wqupc.union(10, 1);
        wqupc.union(20,10);
        wqupc.union(4, 25);
        assertTrue(wqupc.connected(20, 1));
        System.out.println(wqupc);
        assertTrue(wqupc.connected(4, 10));
        assertTrue(wqupc.connected(8, 20));
    }
}
