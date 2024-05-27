package org.algorithms.algs4.week1;

/*
    This implementation adds an improvement: Path Compression on Quick Union algorithm

    When every union operation, the "findRoot" function compresses one part of the node path cutting by half and setting the root as the main node

    The worst-case time complexity on it will be: N + M log N, similar to Weighted Quick Union
 */
public class QuickUnionPathCompression extends QuickUnion {
    public QuickUnionPathCompression(int[] array) {
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
