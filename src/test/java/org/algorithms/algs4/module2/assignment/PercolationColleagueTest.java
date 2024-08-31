package org.algorithms.algs4.module2.assignment;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PercolationColleagueTest {
    @Test
    void percolatesTest() {
        int n = 3;
        final PercolationColleague p = new PercolationColleague(n);
        for (int i = 1; i <= n; p.open(i, 2), i++);
        assertTrue(p.percolates());
    }

    @Test
    void doesNotPercolatesTest() {
        final PercolationColleague p = new PercolationColleague(20);
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
        final PercolationColleague p = new PercolationColleague(n);
        p.open(row, col);
        assertEquals(expected, p.isFull(row, col));
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
        final PercolationColleague p = new PercolationColleague(n);
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
        final PercolationColleague p = new PercolationColleague(n);
        assertThrows(IllegalArgumentException.class, () -> {
            p.open(row, col);
        });
    }

    @Test
    void openSitesTest() {
        final PercolationColleague p = new PercolationColleague(20);
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
    })
    void openUntilItPercolates(int n) {
        final PercolationColleague p = new PercolationColleague(n);
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
//        assertTrue(p.isFull(randomRow, randomCol));
        System.out.println("Expected Threshold 60% = " + expectedThreshold +
            ", Number of tries = " + nOfTrials);
    }
}
