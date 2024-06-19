package org.algorithms.algs4.week1.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PercolationCornerCasesTest {
    @Test
    void test1() {
        final int n = 1;
        final Percolation p = new Percolation(n);
        p.open(1,1);
        assertTrue(p.isOpen(1,1));
        assertTrue(p.percolates());
        assertTrue(p.isFull(1,1));
        assertEquals(1, p.numberOfOpenSites());
    }

    @Test
    void test2() {
        final int n = 2;
        final Percolation p = new Percolation(n);
        p.open(1,1);
        assertTrue(p.isOpen(1,1));
        assertFalse(p.percolates());
        assertTrue(p.isFull(1,1));
        assertEquals(1, p.numberOfOpenSites());

        p.open(2,1);
        assertTrue(p.isOpen(2,1));
        assertTrue(p.percolates());
        assertTrue(p.isFull(2,1));
        assertEquals(2, p.numberOfOpenSites());
    }

    @Test
    void test3() {
        final int n = 2;
        final Percolation p = new Percolation(n);
        p.open(1,1);
        assertTrue(p.isOpen(1,1));
        assertFalse(p.percolates());
        assertTrue(p.isFull(1,1));
        assertEquals(1, p.numberOfOpenSites());

        p.open(2,2);
        assertTrue(p.isOpen(2,2));
        assertFalse(p.percolates());
        assertFalse(p.isFull(2,2));
        assertEquals(2, p.numberOfOpenSites());

        p.open(1,2);
        assertTrue(p.isOpen(1,2));
        assertTrue(p.percolates());
        assertTrue(p.isFull(1,2));
        assertEquals(3, p.numberOfOpenSites());
    }
}
