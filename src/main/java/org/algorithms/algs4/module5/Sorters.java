package org.algorithms.algs4.module5;

import edu.princeton.cs.algs4.StdRandom;

import java.util.function.Consumer;

import static org.algorithms.algs4.module5.SortersUtils.exchange;
import static org.algorithms.algs4.module5.SortersUtils.less;

// All sorting algorithms in graphics: https://www.toptal.com/developers/sorting-algorithms
public final class Sorters {

    private Sorters() {}

    /*
        Algorithm scans from left to right. No matter if the array is sorted, it will run in quadratic time N^2
        * Entries the left of (up) including (up) fixed and in ascending order
        * No entry to the right (up) is smaller than any entry to left of (up)
    */
    public static final Consumer<Comparable<?>[]> SELECTION_SORT = a -> {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                if (less(a[j], a[min])) min = j;
            exchange(a, i, min);
        }
    };

    /*
        Algorithm scans from left to right.
        * Entries to the left of (up) including (up) are in ascending order.
        * Entries to the right of (up) have not yet been seen.
        Proposition: to sort a randomly-ordered array with distinct keys, insertion sort uses ~1/4N^2 exchanges on average.
        -- expect each entry to move halfway back.
        Best case when the array is nearly sorted
        Worst case when the array is sorted in reverse order
        Average case, when the array is randomly sorted. in average, it will swap items to the half of the array
     */
    public static final Consumer<Comparable<?>[]> INSERTION_SORT = a -> {
        for (int i = 0; i < a.length; i++)
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exchange(a, j, j - 1);
    };

    public static final Consumer<Comparable<?>[]> SHELL_SORT = a -> {
        int h = 1;
        while (h < a.length / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < a.length; i++)
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exchange(a, j, j - h);
            h = h / 3;
        }
    };

    /*
        This shuffler is an example of a bad distributed
    */
    public static final Consumer<Comparable<?>[]> SHUFFLER = a -> {
        for (int i = 1; i < a.length; i++) {
            int r = StdRandom.uniformInt(i - 1, a.length);
            exchange(a, i, r);
        }
    };
}
