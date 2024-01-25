package org.algorithms.grokkingbook;

import org.algorithms.utils.ArrayCrazyOps;

import java.util.Arrays;
import java.util.function.UnaryOperator;

// O(n log n)
// O(n) because of the loop inside the function and O(log n) due to the recursive call quantity, which we call as "call stack size"
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
        return ArrayCrazyOps.INTEGER_ARRAY_CONCAT.apply(
                new Integer[][] {
                        QuickSort.SOLUTION.apply(left),
                        new Integer[]{pivot},
                        QuickSort.SOLUTION.apply(right)
                }
        );
    };
}
