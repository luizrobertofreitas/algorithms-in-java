import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int n;
    private final int[] sitesStates;
    private final WeightedQuickUnionUF wqu;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
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
        sitesStates[i] = 1;
        //up
        union(i, getIndex(row - 1, col));
        //down
        union(i, getIndex(row + 1, col));
        //left
        union(i, getIndex(row, col) - 1);
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
        int idx = getIndex(row, col);
        boolean[] connectedBottomUp = new boolean[2];
        for (int i = 0; i < n; i++) {
            if (isOpenByIndex(i) && connected(idx, i)) {
                connectedBottomUp[0] = true;
                break;
            }
        }

        for (int i = sitesStates.length - n; i < sitesStates.length; i++) {
            if (isOpenByIndex(i) && connected(idx, i)) {
                connectedBottomUp[1] = true;
                break;
            }
        }

        return connectedBottomUp[0] && connectedBottomUp[1];
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int sum = 0;
        for (int i = 0; i < sitesStates.length; sum += sitesStates[i], i++);
        return sum;
    }

    // does the system percolate?
    public boolean percolates() {
        for (int i = 0; i < n; i++) {
            if (!isOpenByIndex(i)) continue;
            for (int j = sitesStates.length - n; j < sitesStates.length; j++) {
                if (isOpenByIndex(j) && connected(i, j)) return true;
            }
        }
        return false;
    }

    private int getIndex(int row, int col) {
        return (row - 1) * n + (col - 1);
    }

    private boolean isOpenByIndex(int i) {
        return sitesStates[i] == 1;
    }

    private void union(int first, int second) {
        if (second > -1 && second < sitesStates.length && isOpenByIndex(second)) {
            wqu.union(first, second);
        }
    }

    private boolean connected(int first, int second) {
        return wqu.find(first) == wqu.find(second);
    }

    private void validates(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) throw new IllegalArgumentException();
    }
}