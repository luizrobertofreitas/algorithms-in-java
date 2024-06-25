package org.algorithms.algs4.week1.assignment;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final int OPEN = 4;
    private static final int TOP = 2;
    private static final int BOTTOM = 1;
    private static final int CONNECTED = 7;
    private static final int TOP_CONNECTED = TOP | OPEN;

    private final int n;
    private final int[] sitesStates;
    private final WeightedQuickUnionUF wqu;
    private int numOfOpenSites = 0;
    private boolean percolates = false;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 1) throw new IllegalArgumentException("n can't be less than 1");
        this.n = n;
        final int totalSize = n * n;
        wqu = new WeightedQuickUnionUF(totalSize);
        sitesStates = new int[totalSize];
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validates(row, col);
        if (isOpen(row, col)) return;
        int i = getIndex(row, col);
        if (n > 1) sitesStates[i] |= OPEN;
        else sitesStates[i] |= CONNECTED;
        if (row == 1) sitesStates[i] |= TOP;
        if (row == n) sitesStates[i] |= BOTTOM;
        numOfOpenSites++;
        // up
        if (row > 1) union(i, i - n);
        // right
        if (col < n) union(i, i + 1);
        // left
        if (col > 1) union(i, i - 1);
        // down
        if (row < n) union(i, i + n);

        if (sitesStates[i] == CONNECTED) percolates = true;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validates(row, col);
        return isOpenByIndex(getIndex(row, col));
    }

    // is the site (row, col) full? is this connected to another site that reaches the other side?
    public boolean isFull(int row, int col) {
        validates(row, col);
        final int root = wqu.find(getIndex(row, col));
        return sitesStates[root] == TOP_CONNECTED || sitesStates[root] == CONNECTED;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return percolates;
    }

    private int getIndex(int row, int col) {
        return (row - 1) * n + (col - 1);
    }

    private boolean isOpenByIndex(int i) {
        return sitesStates[i] != 0;
    }

    private void union(int first, int second) {
        if (second < 0 || second >= sitesStates.length || !isOpenByIndex(second)) return;
        int firstRoot = wqu.find(first);
        int secondRoot = wqu.find(second);
        if (firstRoot == secondRoot) return;

        final int stateBeforeUnion = sitesStates[firstRoot] | sitesStates[secondRoot];

        wqu.union(firstRoot, secondRoot);

        final int mainRoot = wqu.find(firstRoot);
        sitesStates[mainRoot] |= stateBeforeUnion; // should be before the union

        if (sitesStates[mainRoot] == CONNECTED) percolates = sitesStates[mainRoot] == CONNECTED;
    }

    private void validates(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) throw new IllegalArgumentException();
    }
}
