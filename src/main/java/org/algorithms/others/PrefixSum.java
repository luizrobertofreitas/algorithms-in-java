package org.algorithms.others;

import org.apache.commons.lang3.function.TriFunction;

import java.util.function.UnaryOperator;

public class PrefixSum {
    private PrefixSum() {}

    public static final UnaryOperator<Integer[]> PREFIX_ARRAY_GEN = arr -> {
        Integer[] prefixArr = new Integer[arr.length];
        prefixArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) prefixArr[i] = prefixArr[i-1] + arr[i];
        return prefixArr;
    };

    public static final TriFunction<Integer[], Integer, Integer, Integer> SUM_IN_THE_RANGE = (arr, i, j) -> {
        Integer[] prefixArr = PREFIX_ARRAY_GEN.apply(arr);
        if (i == 0 && j + 1 == arr.length) return prefixArr[j];
        return prefixArr[j] - prefixArr[i - 1];
    };
}
