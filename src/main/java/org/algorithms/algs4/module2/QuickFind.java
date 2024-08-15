package org.algorithms.algs4.module2;

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
        return arr[first] == arr[second];
    }

    @Override
    public void union(int first, int second) {
        validate(first, second);
        int firstValue = arr[first];
        int secondValue = arr[second];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == firstValue) arr[i] = secondValue;
        }
    }
}
