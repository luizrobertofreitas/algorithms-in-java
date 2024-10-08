package org.algorithms.algs4.module2.assignment;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONSTANT_1_96 = 1.96;

    // trial array of arrays


    private final double[] trials;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();
        this.trials = new double[trials];
        for (int i = 0; i < this.trials.length; i++) {
            final Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int row = StdRandom.uniformInt(1, n + 1);
                int col = StdRandom.uniformInt(1, n + 1);
                if (!p.isOpen(row, col)) {
                    p.open(row, col);
                }
            }
            this.trials[i] = ((double) p.numberOfOpenSites()) / (n * n);
        }

    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(trials);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(trials);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((CONSTANT_1_96 * stddev()) / Math.sqrt(trials.length));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((CONSTANT_1_96 * stddev()) / Math.sqrt(trials.length));
    }

    // test client (see below)
    public static void main(String[] args) {
        final int n = Integer.parseInt(args[0]);
        final int trials = Integer.parseInt(args[1]);
        final PercolationStats ps = new PercolationStats(n, trials);
        System.out.println("mean                    = " + ps.mean());
        System.out.println("stdev                   = " + ps.stddev());
        System.out.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }
}

