package org.algorithms.grokkingbook;

import java.util.Arrays;
import java.util.function.UnaryOperator;

// O(n^2) algorithm
public final class SelectionSort {

    private SelectionSort() {}

    public static final UnaryOperator<Integer[]> SOLUTION = array -> {
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
