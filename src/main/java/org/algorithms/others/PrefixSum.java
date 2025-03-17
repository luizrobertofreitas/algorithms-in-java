package org.algorithms.others;

import java.util.function.UnaryOperator;

public class PrefixSum {
    private PrefixSum() {}

    public static final UnaryOperator<Integer[]> PREFIX_ARRAY_GEN = arr -> {
        Integer[] prefixArr = new Integer[arr.length];
        prefixArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) prefixArr[i] = prefixArr[i-1] + arr[i];
        return prefixArr;
    };
}
