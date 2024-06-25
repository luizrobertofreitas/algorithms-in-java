package org.algorithms.algs4.week1.assignment;

import org.junit.jupiter.api.Test;

class PercolationStatsTest {

    @Test
    void test1() {
        final int n = 4;
        final int trials = 60;
        final PercolationStats ps = new PercolationStats(n, trials);
        System.out.println("mean                    = " + ps.mean());
        System.out.println("stdev                   = " + ps.stddev());
        System.out.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }
}
