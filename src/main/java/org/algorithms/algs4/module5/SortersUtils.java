package org.algorithms.algs4.module5;

public final class SortersUtils {
    private SortersUtils() {}

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) <= 0;
    }

    public static void exchange(Comparable[] array, int a, int b) {
        final Comparable swap = array[a];
        array[a] = array[b];
        array[b] = swap;
    }
}
