package org.algorithms.grokkingbook;

import java.util.Arrays;
import java.util.function.ToIntFunction;

public final class DivideAndConquer {
    private DivideAndConquer() {}

    public static final ToIntFunction<Integer[]> sum = array -> {
        if (array.length == 1) return array[0];
        return array[0] + DivideAndConquer.sum.applyAsInt(Arrays.copyOfRange(array, 1, array.length));
    };
}
