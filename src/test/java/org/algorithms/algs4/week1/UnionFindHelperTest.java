package org.algorithms.algs4.week1;

import static org.junit.jupiter.api.Assertions.*;

abstract class UnionFindHelperTest {
    public static void test(UnionFind uf) {
        assertTrue(uf.connected(1, 1));
        assertFalse(uf.connected(7, 6));
        assertThrows(IllegalArgumentException.class, () -> uf.connected(50, 44));
        uf.union(1, 8);
        assertTrue(uf.connected(1, 8));
        uf.union(3, 4);
        assertTrue(uf.connected(3, 4));
        uf.union(4, 9);
        assertTrue(uf.connected(3, 9));
        uf.union(9, 1);
        assertTrue(uf.connected(8, 9));
        assertTrue(uf.connected(4, 8));
        assertTrue(uf.connected(3, 1));
        assertTrue(uf.connected(1, 4));
        uf.union(10, 1);
        uf.union(20,10);
        uf.union(4, 25);
        assertTrue(uf.connected(20, 1));
        assertTrue(uf.connected(4, 10));
        assertTrue(uf.connected(8, 20));
        assertEquals(25, uf.findLargestConnectedTo(1));
    }
}
