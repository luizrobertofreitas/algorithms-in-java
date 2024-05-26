package org.algorithms.algs4.week1;

/*
    Complexity: for an N number of commands [union, connected] it executes N over the array

    initialize: O(N)
    union:      O(N)
    find:       1
 */
public class QuickFind extends UnionFind {
    public QuickFind(int[] array) {
        super(array);
    }

    @Override
    public boolean connected(int first, int second) {
        validate(first, second);
        return this.arr[first] == this.arr[second];
    }

    @Override
    public void union(int first, int second) {
        validate(first, second);
        if (!this.connected(first, second)) {
            for (int i = 0; i < this.arr.length; i++)
                if (this.arr[i] == first) this.arr[i] = this.arr[second];
        }
    }
}
