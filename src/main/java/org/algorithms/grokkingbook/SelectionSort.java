package org.algorithms.grokkingbook;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// O(n^2) algorithm
public final class SelectionSort {
    public static Function<Integer[], Integer[]> SOLUTION = array -> {
        Integer[] sortedArray = new Integer[array.length];
        Integer[] copyOfArray = Arrays.copyOf(array, array.length);
        for (int i = 0 ; i < copyOfArray.length ; i++) {
            Integer smallest = copyOfArray[0];
            Integer smallestIndex = 0;
            for (int j = 1 ; j < copyOfArray.length ; j++) if (smallest > copyOfArray[j]) {
                smallest = copyOfArray[j];
                smallestIndex = j;
            }
            sortedArray[i] = copyOfArray[smallestIndex];
            copyOfArray[smallestIndex] = Integer.MAX_VALUE; // Setting the ceiling, no element can surpass this size; yeah "Gambi" is on!
        }
        return sortedArray;
    };
}
