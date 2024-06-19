package org.algorithms.algs4.week1.assignment;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PercolationTest {
    @Test
    void percolatesTest() {
        final Percolation p = new Percolation(20);
        for (int i = 1; i <= 20; p.open(i, 5), i++);
        assertTrue(p.percolates());
    }

    @Test
    void doesNotPercolatesTest() {
        final Percolation p = new Percolation(20);
        for (int i = 1; i < 20; p.open(i, 5), i++);
        assertFalse(p.percolates());
    }

    @ParameterizedTest
    @CsvSource({
            "20,1,1,true",
            "20,1,19,true",
            "20,1,20,true",
            "20,2,2,false",
            "20,18,18,false",
            "20,2,1,false",
            "20,10,10,false",
            "20,1,15,true",
            "20,9,8,false",
            "20,19,1,false",
            "20,6,10,false",
            "20,20,20,false",
    })
    void isFullTest(int n, int row, int col, boolean expected) {
        final Percolation p = new Percolation(n);
        p.open(row, col);
        assertEquals(expected, p.isFull(row, col));
    }

    @Test
    void open1Test() {
        final int n = 3;
        final Percolation p = new Percolation(n);
        p.open(1,2);
        assertTrue(p.isFull(1,2));
        p.open(2,1);
        assertFalse(p.isFull(2,1));
        p.open(3,1);
        assertFalse(p.isFull(3,1));
        p.open(2,2);
        assertTrue(p.isFull(2,2));
        // Percolates?
        assertTrue(p.percolates());
        // Everybody's full?
        assertTrue(p.isFull(1,2));
        assertTrue(p.isFull(2,1));
        assertTrue(p.isFull(3,1));
        assertTrue(p.isFull(2,2));
        // Open sites == 4?
        assertEquals(4, p.numberOfOpenSites());
        // Not opened sites
        assertFalse(p.isOpen(3,3));
        assertFalse(p.isOpen(1,1));
        assertFalse(p.isOpen(2,3));
        // Opened sites
        assertTrue(p.isOpen(1,2));
        assertTrue(p.isOpen(2,1));
        assertTrue(p.isOpen(3,1));
        assertTrue(p.isOpen(2,2));

    }

    @ParameterizedTest
    @CsvSource({
        "4,1,1,true",
    })
    void isFullRandomTest(int n, int row, int col, boolean expected) {
        final Percolation p = new Percolation(n);
        int randomRow = 0;
        int randomCol = 0;
        for (int i = n; i > 0; i--) {
            p.open(i, n);
            if (i == n) {
                randomRow = i;
            }
        }
        assertTrue(p.isFull(randomRow, n));
    }

    @ParameterizedTest
    @CsvSource({
            "20,1,1",
            "20,1,19",
            "20,2,2",
            "20,18,18",
            "20,2,1",
            "20,10,10",
            "20,9,8",
            "20,19,1",
            "20,6,10",
            "20,20,20",
    })
    void isOpenTest(int n, int row, int col) {
        final Percolation p = new Percolation(n);
        p.open(row, col);
        assertTrue(p.isOpen(row, col));
    }

    @ParameterizedTest
    @CsvSource({
            "5,6,1",
            "5,1,6",
            "5,0,0",
            "5,6,6",
            "100,101,100",
            "100,-1,-2",
            "100,9,-2",
            "200,-9,1",
            "10000,-1,10001",
            "10000,10001,20",
    })
    void invalidRowAndColumnOnOpen(int n, int row, int col) {
        final Percolation p = new Percolation(n);
        assertThrows(IllegalArgumentException.class, () -> {
            p.open(row, col);
        });
    }

    @Test
    void openSitesTest() {
        final Percolation p = new Percolation(20);
        for (int i = 1; i <= 20; p.open(i, 5), i++);
        p.open(2, 4);
        p.open(2, 3);
        p.open(3, 3);
        p.open(3, 2);
        p.open(2,1);
        p.open(2,2);
        p.open(1,1);
        for (int i = 4; i <= 20; i++) {
            p.open(i, 2);
        }
        assertEquals(44, p.numberOfOpenSites());
    }

    @ParameterizedTest
    @CsvSource({
        "3,0.9",
        "7,0.9",
        "13,0.9",
        "17,0.9",
        "50,0.9",
        "120,0.9",
        "250,0.9",
        "500,0.9",
        "1000,0.9",
        "2500,0.9",
    })
    void openUntilItPercolatesWith80PercentThreshold(int n, double thresholdPercentage) {
        final Percolation p = new Percolation(n);
        int nOfTrials = 0;
        final int expectedThreshold = (int) (n * n * thresholdPercentage);
        while(!p.percolates() && nOfTrials <= expectedThreshold) {
            final int row = StdRandom.uniformInt(1, n + 1);
            final int col = StdRandom.uniformInt(1, n + 1);
            if (p.isOpen(row, col)) continue;
            p.open(row, col);
            nOfTrials++;
        }

        System.out.println(
            "N = " + n + "\n" +
            "Expected Threshold 80% = " + expectedThreshold + "\n" +
            "Number of tries = " + nOfTrials + "\n" +
            "Obtained Threshold (n/trials): " + n + "/" + nOfTrials + " = " + ((double) nOfTrials / (n*n)) + "\n" +
            "---------------------------------------------------------------------------"
        );
        assertTrue(p.percolates());
    }

    @Test
    void testingInclusiveOr() {
        int OPEN = 2;
        int CONNECTED_TOP = 6;
        int CONNECTED_BOTTOM = 3;
        int CONNECTED = 7;

        System.out.println("Fully connected: " + (OPEN | CONNECTED_TOP | CONNECTED_BOTTOM));

        System.out.println("Connected top: " + (OPEN | CONNECTED_TOP));
        System.out.println("Connected bottom: " + (OPEN | CONNECTED_BOTTOM));

        System.out.println("Fully connected 2: " + (OPEN | CONNECTED));

        System.out.println("TOP ones " + (CONNECTED_TOP | CONNECTED));
        assertEquals(CONNECTED, (CONNECTED_TOP | CONNECTED));
        assertEquals(CONNECTED, (CONNECTED_BOTTOM | CONNECTED));
        assertEquals(CONNECTED, (OPEN | CONNECTED));

        assertEquals(CONNECTED_TOP, (OPEN | CONNECTED_TOP));
        assertEquals(CONNECTED_BOTTOM, (OPEN | CONNECTED_BOTTOM));

        assertEquals(CONNECTED, (CONNECTED_BOTTOM | CONNECTED_TOP));

        System.out.println("top | bottom: " + (CONNECTED_BOTTOM | CONNECTED_TOP));
    }
}
