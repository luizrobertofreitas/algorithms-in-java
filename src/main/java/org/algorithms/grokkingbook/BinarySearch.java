package org.algorithms.grokkingbook;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BinarySearch {
    public static BiFunction<Integer[], Integer, Integer> SOLUTION = (array, item) -> {
        int low = 0, high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = array[mid];
            if (guess == item)
                return mid;
            else if (guess > item)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    };
}
