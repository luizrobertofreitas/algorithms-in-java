package org.algorithms.algs4.module2.assignment;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PercolationV1Test {

    @Test
    void testIsOpen() {
        int n = 3;
        final PercolationV1 p = new PercolationV1(n);
        assertFalse(p.isOpen(1,1));
        assertFalse(p.isOpen(1,3));
        assertFalse(p.isOpen(3,3));

        p.open(3,3);
        p.open(1,1);
        p.open(1,2);
        assertTrue(p.isOpen(3,3));
        assertTrue(p.isOpen(1,1));
        assertTrue(p.isOpen(1,2));
        print(p);

        assertEquals(3, p.numberOfOpenSites());
    }

    @Test
    void testPercolates() {
        final PercolationV1 p = new PercolationV1(5);
        p.open(1,2);
        p.open(2,2);
        p.open(2,3);
        assertFalse(p.percolates());
        p.open(3,3);
        p.open(3,4);
        p.open(4,4);
        p.open(4,3);
        assertFalse(p.percolates());
        p.open(5,5);
        p.open(5,4);
        assertTrue(p.percolates());

        assertTrue(p.isFull(2,2));
        assertFalse(p.isFull(1,5));
        p.open(5,1);
        print(p);
        assertFalse(p.isFull(5,1));
    }

    @Test
    void testGetIndex() {
        final PercolationV1 p = new PercolationV1(5);
        assertEquals(0, p.getIndex(1,1));
        assertEquals(1, p.getIndex(1,2));
        assertEquals(2, p.getIndex(1,3));
        assertEquals(3, p.getIndex(1,4));
        assertEquals(4, p.getIndex(1,5));
        assertEquals(5, p.getIndex(2,1));
        assertEquals(6, p.getIndex(2,2));
        assertEquals(7, p.getIndex(2,3));
        assertEquals(8, p.getIndex(2,4));
        assertEquals(9, p.getIndex(2,5));
        assertEquals(10, p.getIndex(3,1));
        assertEquals(11, p.getIndex(3,2));
        assertEquals(12, p.getIndex(3,3));
        assertEquals(13, p.getIndex(3,4));
        assertEquals(14, p.getIndex(3,5));
        assertEquals(15, p.getIndex(4,1));
        assertEquals(16, p.getIndex(4,2));
        assertEquals(17, p.getIndex(4,3));
        assertEquals(18, p.getIndex(4,4));
        assertEquals(19, p.getIndex(4,5));
        assertEquals(20, p.getIndex(5,1));
        assertEquals(21, p.getIndex(5,2));
        assertEquals(22, p.getIndex(5,3));
        assertEquals(23, p.getIndex(5,4));
        assertEquals(24, p.getIndex(5,5));
    }

    private void print(final PercolationV1 p) {
        System.out.println("Sites:        " + Arrays.toString(p.sites));
        System.out.println("Sites States: " + Arrays.toString(p.sitesStates));
        System.out.println("Sites Weight: " + Arrays.toString(p.sz));
    }
}
