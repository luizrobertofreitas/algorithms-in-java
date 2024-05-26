package org.algorithms.algs4.week1;

import java.util.Arrays;
import java.util.function.IntFunction;

/**
 * We assume "is connected to" is an equivalence relation:
 *      - Reflexive: p is connected to p.
 *      - Symmetric: if p is connected to q, then q is connected to p.
 *      - Transitive: if p is connected to q and q is connected to r, then p is connected to r.
 */
abstract class UnionFind {

    public static final IntFunction<int[]> REFLEXIVE_ARRAY_GENERATOR = size -> {
        final int[] array = new int[size];
        for (int i = 0; i < array.length; i++) array[i] = i;
        return array;
    };

    protected final int[] arr;

    protected UnionFind(int[] array) {
        this.arr = array;
    }

    abstract boolean connected(int first, int second);
    abstract void union(int first, int second);

    public void validate(int ... numbers) {
        if (Arrays.stream(numbers).anyMatch(n -> n > this.arr.length - 1))
            throw new IllegalArgumentException("There are some number in : " +
                    Arrays.toString(numbers) + " exceeding the array length " + (this.arr.length - 1));
    }

    @Override
    public String toString() {
        return Arrays.toString(this.arr);
    }
}
