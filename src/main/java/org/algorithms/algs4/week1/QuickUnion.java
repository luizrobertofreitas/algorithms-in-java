package org.algorithms.algs4.week1;

/*
    Complexity: for an N number of commands [union, connected] it executes N over the array

    initialize: O(N)
    union:      O(N) <- includes cost of finding roots
    find:       O(N) Worst Case
 */
public class QuickUnion extends UnionFind {

    public QuickUnion(final int[] array) {
        super(array);
    }

    @Override
    boolean connected(int first, int second) {
        validate(first, second);
        return findRoot(first) == findRoot(second);
    }

    @Override
    void union(int first, int second) {
        validate(first, second);
        if (first == second) return;
        int firstRoot = findRoot(first);
        int secondRoot = findRoot(second);
        this.arr[firstRoot] = secondRoot;
    }

    protected int findRoot(int number) {
        int root = this.arr[number];
        while (root != this.arr[root])
            root = this.arr[root];
        return root;
    }
}
