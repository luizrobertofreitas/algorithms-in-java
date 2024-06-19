package org.algorithms.algs4.week1.assignment;

import org.algorithms.utils.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PercolationCorrectnessTest {

    /*
        Tests 1 through 7 create a Percolation object using your code, then repeatedly
        open sites by calling open(). After each call to open(), it checks the return
        values of isOpen(), percolates(), numberOfOpenSites(), and isFull() in that order.
    */
    @Test
    void test1() {
        // calls open, isOpen, percolates, numberOfOpenSites, isFull
        int numberOfOpenSites = 1;
        final int n = 6;
        final Percolation p = new Percolation(n);
        p.open(1, 3);
        assertTrue(p.isOpen(1,3));
        assertFalse(p.percolates());
        assertEquals(numberOfOpenSites++, p.numberOfOpenSites());
        assertTrue(p.isFull(1,3));

        p.open(3,3);
        assertTrue(p.isOpen(3,3));
        assertFalse(p.percolates());
        assertEquals(numberOfOpenSites++, p.numberOfOpenSites());
        assertFalse(p.isFull(3,3));

        p.open(5,3);
        assertTrue(p.isOpen(5,3));
        assertFalse(p.percolates());
        assertEquals(numberOfOpenSites++, p.numberOfOpenSites());
        assertFalse(p.isFull(5,3));

        p.open(2,4);
        assertTrue(p.isOpen(2,4));
        assertFalse(p.percolates());
        assertEquals(numberOfOpenSites++, p.numberOfOpenSites());
        assertFalse(p.isFull(2,4));

        p.open(4,4);
        assertTrue(p.isOpen(4,4));
        assertFalse(p.percolates());
        assertEquals(numberOfOpenSites++, p.numberOfOpenSites());
        assertFalse(p.isFull(4,4));

        p.open(6,4);
        assertTrue(p.isOpen(6,4));
        assertFalse(p.percolates());
        assertEquals(numberOfOpenSites++, p.numberOfOpenSites());
        assertFalse(p.isFull(6,4));

        p.open(1,5);
        assertTrue(p.isOpen(1,5));
        assertFalse(p.percolates());
        assertEquals(numberOfOpenSites++, p.numberOfOpenSites());
        assertTrue(p.isFull(1,5));

        p.open(2,5);
        assertTrue(p.isOpen(2,5));
        assertFalse(p.percolates());
        assertEquals(numberOfOpenSites++, p.numberOfOpenSites());
        assertTrue(p.isFull(2,5));

        p.open(3,5);
        assertTrue(p.isOpen(3,5));
        assertFalse(p.percolates());
        assertEquals(numberOfOpenSites++, p.numberOfOpenSites());
        assertTrue(p.isFull(3,5));

        p.open(6,5);
        assertTrue(p.isOpen(6,5));
        assertFalse(p.percolates());
        assertEquals(numberOfOpenSites++, p.numberOfOpenSites());
        assertFalse(p.isFull(6,5));

        p.open(6,3);
        assertTrue(p.isOpen(6,3));
        assertFalse(p.percolates());
        assertEquals(numberOfOpenSites++, p.numberOfOpenSites());
        assertFalse(p.isFull(6,3));

        p.open(4,3);
        assertTrue(p.isOpen(4,3));
        assertFalse(p.percolates());
        assertEquals(numberOfOpenSites++, p.numberOfOpenSites());
        assertFalse(p.isFull(4,3));

        p.open(4,5);
        assertTrue(p.isOpen(4,5));
        assertTrue(p.percolates());
        assertEquals(numberOfOpenSites, p.numberOfOpenSites());
        assertTrue(p.isFull(4,5));
    }

    @Test
    void test2() {
        // calls open, isOpen, percolates, numberOfOpenSites, isFull
        int numberOfOpenSites = 1;
        final int n = 8;
        final Percolation p = new Percolation(n);

        // first round
        for (int i = 1; i <= n; i++) {
            p.open(i, i);
            assertTrue(p.isOpen(i,i));
            assertFalse(p.percolates());
            assertEquals(numberOfOpenSites++, p.numberOfOpenSites());
            if (i == 1) {
                assertTrue(p.isFull(i,i));
            } else {
                assertFalse(p.isFull(i,i));
            }
        }

        // second round
        for (int row = n, col = 1; row > 0 || col <= n; row--, col++) {
            p.open(row, col);
            assertTrue(p.isOpen(row, col));
            assertFalse(p.percolates());
            assertEquals(numberOfOpenSites++, p.numberOfOpenSites());
            if (row == 1) {
                assertTrue(p.isFull(row,col));
            } else {
                assertFalse(p.isFull(row,col));
            }
        }

        // third round
        for (int row = 1, col = (n/2) + 1; row < (n/2) ; row++) {
            p.open(row, col);
            assertTrue(p.isOpen(row, col));
            assertFalse(p.percolates());
            assertEquals(numberOfOpenSites++, p.numberOfOpenSites());
            assertTrue(p.isFull(row,col));
        }

        // fourth round
        for (int row = n-2, col = (n/2); row <= n ; row++) {
            p.open(row, col);
            assertTrue(p.isOpen(row, col));
            if (row == n) assertTrue(p.percolates());
            else assertFalse(p.percolates());
            assertEquals(numberOfOpenSites++, p.numberOfOpenSites());
            assertTrue(p.isFull(row,col));
        }
    }

    @ParameterizedTest
    @CsvSource({
        "algs4/input8-no.txt,0.5971,false",
        "algs4/heart25.txt,0.5971,false",
        "algs4/input8.txt,0.5971,true",
        "algs4/input6.txt,0.5971,true",
        "algs4/input20.txt,0.65,true",
    })
    void test3(final String filePath, final double probability, final boolean shouldPercolate) {
        final List<String> lines = FileUtils.getStreamOfLinesFromFile(filePath);
        final int n = Integer.parseInt(lines.get(0));
        final Percolation p = new Percolation(n);
        double numberOfOpen = 1;
        for (String line : lines) {
            final String[] lineArr = line.trim().split(" ");
            if (lineArr.length > 1) {
                final int row = Integer.parseInt(lineArr[0]);
                final int col = Integer.parseInt(lineArr[1]);
                p.open(row, col);
                assertTrue(p.isOpen(row, col));
                assertEquals(numberOfOpen++, p.numberOfOpenSites());
            }
        }

        double probabilityExecution = numberOfOpen / (n * n);

        System.out.println("File: " + filePath + ", probabilityExecution: " + probabilityExecution + ", and probability: " + probability);
        assertTrue(probabilityExecution <= probability);
        assertEquals(shouldPercolate, p.percolates());
    }
}
