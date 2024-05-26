package org.algorithms.algs4.week1;

import java.util.Arrays;

/*
    Running time
    * Find: takes time proportional to depth of p and q.
    * Union: takes constant time, given roots

    initialize: O(N)
    union:      O(N)
    find:       1
 */
public class WeightedQuickUnion extends QuickUnion {

    private final int[] sz;

    public WeightedQuickUnion(int[] array) {
        super(array);
        sz = new int[array.length];
        for (int i = 0; i < sz.length; sz[i] = 1, i++);
    }

    @Override
    void union(int first, int second) {
        validate(first, second);
        if (first == second) return;
        int firstRoot = this.findRoot(first);
        int secondRoot = this.findRoot(second);
        if (sz[firstRoot] > sz[secondRoot]) {
            arr[firstRoot] = secondRoot;
            sz[firstRoot] += sz[secondRoot];
        } else {
            arr[secondRoot] = firstRoot;
            sz[secondRoot] += sz[firstRoot];
        }
    }

    public String weightedArrayToString() {
        return Arrays.toString(sz);
    }
}
