package org.algorithms.algs4.week1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuickUnionTest {

    @Test
    void test() {
        final int[] array = UnionFind.REFLEXIVE_ARRAY_GENERATOR.apply(30);
        final QuickUnion qu = new QuickUnion(array);
        assertTrue(qu.connected(1, 1));
        assertFalse(qu.connected(7, 6));
        assertThrows(IllegalArgumentException.class, () -> qu.connected(50, 44));
        qu.union(1, 8);
        assertTrue(qu.connected(1, 8));
        qu.union(3, 4);
        assertTrue(qu.connected(3, 4));
        qu.union(4, 9);
        assertTrue(qu.connected(3, 9));
        qu.union(9, 1);
        assertTrue(qu.connected(8, 9));
        assertTrue(qu.connected(4, 8));
        assertTrue(qu.connected(3, 1));
        assertTrue(qu.connected(1, 4));
        qu.union(10, 1);
        qu.union(20,10);
        qu.union(4, 25);
        assertTrue(qu.connected(20, 1));
        System.out.println(qu);
        assertTrue(qu.connected(4, 10));
        assertTrue(qu.connected(8, 20));
    }
}
