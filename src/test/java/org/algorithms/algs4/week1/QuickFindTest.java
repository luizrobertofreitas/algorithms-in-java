package org.algorithms.algs4.week1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuickFindTest {

    @Test
    void test() {
        final int[] array = UnionFind.REFLEXIVE_ARRAY_GENERATOR.apply(30);

        final QuickFind qf = new QuickFind(array);

        assertTrue(qf.connected(1, 1));
        assertFalse(qf.connected(7, 6));
        assertThrows(IllegalArgumentException.class, () -> qf.connected(50, 44));
        qf.union(1, 8);
        assertTrue(qf.connected(1, 8));
        qf.union(3, 4);
        assertTrue(qf.connected(3, 4));
        qf.union(4, 9);
        assertTrue(qf.connected(3, 9));
        qf.union(9, 1);
        assertTrue(qf.connected(8, 9));
        assertTrue(qf.connected(4, 8));
        assertTrue(qf.connected(3, 1));
        assertTrue(qf.connected(1, 4));
        qf.union(10, 1);
        qf.union(20,10);
        qf.union(4, 25);
        assertTrue(qf.connected(20, 1));
        assertTrue(qf.connected(4, 10));
        assertTrue(qf.connected(8, 20));
    }
}
