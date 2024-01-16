package org.algorithms.utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public final class ArrayCrazyOps {

    private ArrayCrazyOps() {}

    public static <A> A[] deleteFromArray(A[] array, Integer index) {
        final A[] newArray = Arrays.copyOf(array, array.length - 1);
        int newArrayIdx = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == index) continue;
            newArray[newArrayIdx] = array[i];
            newArrayIdx++;
        }
        return newArray;
    }

    public static Integer[] integerArrayConcat(Integer[] ... arrays) {
        return Stream.of(arrays).flatMap(Stream::of).toArray(Integer[]::new);
    }

    public static Integer[] convertStringToIntegerArray(String input) {
        return Stream.of(input.split(",")).map(Integer::valueOf).toArray(Integer[]::new);
    }
}
