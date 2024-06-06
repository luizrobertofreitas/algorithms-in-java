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

    @Test
    void isFullTest() {
        final Percolation p = new Percolation(20);
        for (int i = 1; i <= 20; p.open(i, 5), i++);
        p.open(2, 4);
        p.open(2, 3);
        p.open(3, 3);
        p.open(3, 2);
        assertTrue(p.isFull(5, 5));
        assertTrue(p.isFull(3,2));
        p.open(2,1);
        p.open(2,2);
        assertTrue(p.isFull(2,1));
        p.open(1,1);
        assertTrue(p.isFull(1,1));
        for (int i = 4; i <= 20; i++) {
            p.open(i, 2);
        }
        assertTrue(p.isFull(19, 2));
        assertTrue(p.isFull(17, 2));
        assertTrue(p.isFull(13, 2));
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
    void isNotFullTest(int n, int row, int col) {
        final Percolation p = new Percolation(n);
        p.open(row, col);
        assertFalse(p.isFull(row, col));
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
        "3",
        "7",
        "13",
        "17",
        "50",
        "120",
        "250",
        "500",
        "1000",
        "5500",
    })
    void openUntilItPercolates(int n) {
        final Percolation p = new Percolation(n);
        int randomCol = 1, randomRow = 1;
        int nOfTrials = 0;
        final int expectedThreshold = (int) (n * n * 0.6);
        while(!p.percolates()) {
            final int row = StdRandom.uniformInt(1, n + 1);
            final int col = StdRandom.uniformInt(1, n + 1);
            if (row == 2) {
                randomRow = row;
                randomCol = col;
            }
            p.open(row, col);
            nOfTrials++;
        }

        assertTrue(p.percolates());
        assertTrue(p.isFull(randomRow, randomCol));
        System.out.println("Expected Threshold 60% = " + expectedThreshold +
            ", Number of tries = " + nOfTrials);
    }
}
