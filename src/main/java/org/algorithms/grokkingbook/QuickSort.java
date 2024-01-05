package org.algorithms.grokkingbook;

import org.algorithms.utils.ArrayCrazyOps;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public final class QuickSort {
    private QuickSort() {}

    public static final UnaryOperator<Integer[]> SOLUTION = arr -> {
        if (arr.length < 2) return arr;
        int pivot = arr[0];
        Integer[] left = new Integer[0];
        Integer[] right = new Integer[0];
        for (int i = 1 ; i < arr.length ; i++) {
            if (arr[i] < pivot) {
                left = Arrays.copyOf(left, left.length + 1);
                left[left.length - 1] = arr[i];
            } else {
                right = Arrays.copyOf(right, right.length + 1);
                right[right.length - 1] = arr[i];
            }
        }
        return ArrayCrazyOps.integerArrayConcat(
                QuickSort.SOLUTION.apply(left),
                new Integer[] {pivot},
                QuickSort.SOLUTION.apply(right)
        );
    };
}
