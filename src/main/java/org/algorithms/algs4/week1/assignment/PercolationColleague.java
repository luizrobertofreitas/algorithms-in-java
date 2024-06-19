package org.algorithms.algs4.week1.assignment;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationColleague {
    private static final byte OPEN = 1 << 2; // [1,0,0]
    private static final byte CONNECTED_TO_TOP = 1 << 1; // [0,1,0]
    private static final byte CONNECTED_TO_BOTTOM = 1; // [0,0,1]
    private static final byte CONDUCTOR = CONNECTED_TO_TOP | CONNECTED_TO_BOTTOM | OPEN; //[1,1,1]
    private WeightedQuickUnionUF UF;
    private byte[] sitesState;
    private int n;
    private int openSites;
    private boolean systemPercolates;

    // creates n-by-n grid, with all sites initially blocked
    public PercolationColleague(int n) {
        if (n < 1) throw new IllegalArgumentException();
        this.n = n;
        this.UF = new WeightedQuickUnionUF(n * n);
        this.sitesState = new byte[n * n];
    }

    private int position(int row, int col) {
        return (row - 1) * n + col - 1;
    }

    private boolean validCoordinate(int row, int col) {
        return !(row < 1 || row > n || col < 1 || col > n);
    }

    public void open(int row, int col) {
        if (!validCoordinate(row, col)) throw new IllegalArgumentException();
        if (isOpen(row, col)) return;

        int idx = position(row, col);

        sitesState[idx] |= OPEN; // 100
        if (row == 1) sitesState[idx] |= CONNECTED_TO_TOP; // 110
        if (row == n) sitesState[idx] |= CONNECTED_TO_BOTTOM; // 101

        if (row > 1 && (sitesState[idx-n] & OPEN) != 0) union(idx, idx-n); // above
        if (col < n && (sitesState[idx+1] & OPEN) != 0) union(idx, idx+1); // right
        if (col > 1 && (sitesState[idx-1] & OPEN) != 0) union(idx, idx-1); // left
        if (row < n && (sitesState[idx+n] & OPEN) != 0) union(idx, idx+n); // below

        openSites++;
        if (sitesState[UF.find(idx)] == CONDUCTOR) systemPercolates = sitesState[UF.find(idx)] == CONDUCTOR;
    }

    private void union(int p, int q) {
        int firstRoot = UF.find(p);
        int secondRoot = UF.find(q);
        if (firstRoot == secondRoot) return;

        UF.union(firstRoot, secondRoot);

        sitesState[firstRoot] |= sitesState[secondRoot];
        sitesState[secondRoot] |= sitesState[firstRoot];

        firstRoot = UF.find(p);

        if (sitesState[firstRoot] == CONDUCTOR) systemPercolates = sitesState[firstRoot] == CONDUCTOR;
        System.out.println("percolates: " + systemPercolates);
    }

    public boolean isOpen(int row, int col) {
        if (!validCoordinate(row, col)) throw new IllegalArgumentException();
        int pos = position(row, col);
        return (sitesState[pos] & OPEN) != 0;
    }

    public boolean isFull(int row, int col) {
        if (!validCoordinate(row, col)) throw new IllegalArgumentException();
        return (sitesState[UF.find(position(row, col))] & CONNECTED_TO_TOP) != 0;
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        return systemPercolates;
    }
}
