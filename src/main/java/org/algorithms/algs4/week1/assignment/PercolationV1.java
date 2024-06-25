package org.algorithms.algs4.week1.assignment;

import java.util.Arrays;

public class PercolationV1 {
    public final int n;
    public final int[] sites;
    public final int[] sz;
    public final int[] sitesStates;

    // creates n-by-n grid, with all sites initially blocked
    public PercolationV1(int n) {
        this.n = n;
        final int totalSize = n * n;
        sitesStates = new int[totalSize];
        sites = new int[totalSize];
        sz = new int[totalSize];
        for (int i = 0; i < sites.length; sites[i] = i, sz[i] = 1, i++);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validates(row, col);
        int i = getIndex(row, col);
        sitesStates[i] = 1;
        //up
        union(i, getIndex(row - 1, col));
        //down
        union(i, getIndex(row + 1, col));
        //left
        union(i, getIndex(row, col - 1));
        //right
        union(i, getIndex(row, col + 1));
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validates(row, col);
        int i = getIndex(row, col);
        return sitesStates[i] == 1;
    }

    // is the site (row, col) full? is this connected to another site that reaches the other side?
    public boolean isFull(int row, int col) {
        validates(row, col);
        if (!isOpen(row, col)) return false;
        final int iRoot = findRoot(getIndex(row, col));
        boolean[] connectedBottomUp = new boolean[2];
        for (int j = 0; j < n; j++) {
            if (iRoot == findRoot(j)) {
                connectedBottomUp[0] = true;
                break;
            }
        }

        for (int i = sites.length - n; i < sites.length; i++) {
            if (iRoot == findRoot(i)) {
                connectedBottomUp[1] = true;
                break;
            }
        }

        return connectedBottomUp[0] && connectedBottomUp[1];
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return Arrays.stream(sitesStates).sum();
    }

    // does the system percolate?
    public boolean percolates() {
        for (int i = 0; i < n; i++) {
            int firstRoot = findRoot(i);
            for (int j = sites.length - n; j < sites.length; j++) {
                int secondRoot = findRoot(j);
                if (firstRoot == secondRoot) return true;
            }
        }
        return false;
    }

    public int getIndex(int row, int col) {
        return (row - 1) * n + (col - 1);
    }

    private int findRoot(int i) {
        while (i != sites[i])
            i = sites[i];
        return i;
    }

    private void union(int first, int second) {
        if (second > -1 && second < sites.length && isOpenByIndex(second)) {
            if (first == second) return;
            int firstRoot = this.findRoot(first);
            int secondRoot = this.findRoot(second);
            if (sz[firstRoot] > sz[secondRoot]) {
                sites[firstRoot] = secondRoot;
                sz[firstRoot] += sz[secondRoot];
            } else {
                sites[secondRoot] = firstRoot;
                sz[secondRoot] += sz[firstRoot];
            }
        }
    }

    private boolean isOpenByIndex(int i) {
        return sitesStates[i] == 1;
    }

    private void validates(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) throw new IllegalArgumentException();
    }
}
