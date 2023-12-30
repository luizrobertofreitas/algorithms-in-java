package org.algorithms.utils;

import java.util.Arrays;

public class ArrayCrazyOps {
    public static <A> A[] deleteFromArray(A[] array, Integer index) {
        final A[] newArray = Arrays.copyOf(array, array.length - 1);
        for (int i = 0, newArrayIdx = 0; i < array.length; i++) {
            if (i == index) continue;
            newArray[newArrayIdx] = array[i];
            newArrayIdx++;
        }
        return newArray;
    }
}
