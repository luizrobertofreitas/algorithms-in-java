package org.algorithms.algs4.week1;

/*
    This implementation applies both improvements: Weighted Tree and Tree Path Compression on Quick Union algorithm.

    In this one, the worst-case time will be: N + M log* N
 */
public class WeightedQuickUnionPathCompression extends WeightedQuickUnion {
    public WeightedQuickUnionPathCompression(int[] array) {
        super(array);
    }

    @Override
    public int findRoot(int i) {
        while (i != arr[i]) {
            arr[i] = arr[arr[i]]; // looks 2 node below the one right below root. Cutting to the half of the tree depth
            i = arr[i];
        }
        return i;
    }
}
