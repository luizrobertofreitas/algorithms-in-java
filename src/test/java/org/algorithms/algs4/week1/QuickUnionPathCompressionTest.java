package org.algorithms.algs4.week1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickUnionPathCompressionTest {

    @Test
    void test() {
        final int[] array = UnionFind.REFLEXIVE_ARRAY_GENERATOR.apply(30);
        final QuickUnionPathCompression qupc = new QuickUnionPathCompression(array);
        assertTrue(qupc.connected(1, 1));
        assertFalse(qupc.connected(7, 6));
        assertThrows(IllegalArgumentException.class, () -> qupc.connected(50, 44));
        qupc.union(1, 8);
        assertTrue(qupc.connected(1, 8));
        qupc.union(3, 4);
        assertTrue(qupc.connected(3, 4));
        qupc.union(4, 9);
        assertTrue(qupc.connected(3, 9));
        qupc.union(9, 1);
        assertTrue(qupc.connected(8, 9));
        assertTrue(qupc.connected(4, 8));
        assertTrue(qupc.connected(3, 1));
        assertTrue(qupc.connected(1, 4));
        qupc.union(10, 1);
        qupc.union(20,10);
        qupc.union(4, 25);
        assertTrue(qupc.connected(20, 1));
        System.out.println(qupc);
        assertTrue(qupc.connected(4, 10));
        assertTrue(qupc.connected(8, 20));
    }
}
