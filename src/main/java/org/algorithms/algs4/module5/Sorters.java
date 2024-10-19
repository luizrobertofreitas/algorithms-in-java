package org.algorithms.algs4.module5;

import java.util.function.Consumer;

public final class Sorters {

    private Sorters() {}

    /*
        Algorithm scans from left to right. No matter if the array is sorted, it will run in quadratic time N^2
        * Entries the left of (up) including (up) fixed and in ascending order
        * No entry to the right (up) is smaller than any entry to left of (up)
    */
    public static final Consumer<Comparable[]> SELECTION_SORT = a -> {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                if (SortersUtils.less(a[j], a[min])) min = j;
            SortersUtils.exchange(a, i, min);
        }
    };

    /*
        Algorithm scans from left to right.
        * Entries to the left of (up) including (up) are in ascending order.
        * Entries to the right of (up) have not yet been seen.
     */
    public static final Consumer<Comparable[]> INSERTION_SORT = a -> {
        for (int i = 0; i < a.length; i++)
            for (int j = i; j > 0; j--)
                if (SortersUtils.less(a[j], a[j - 1]))
                    SortersUtils.exchange(a, j, j - 1);
                else
                    break;
    };
}
