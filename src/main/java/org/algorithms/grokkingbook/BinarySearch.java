package org.algorithms.grokkingbook;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.logging.Logger;

public final class BinarySearch {
    private BinarySearch() {}

    private static final Logger LOGGER = Logger.getLogger(BinarySearch.class.toString());

    public static final BiFunction<Integer[], Integer, Integer> SOLUTION = (array, item) -> {
        int low = 0;
        int high = array.length - 1;

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

    public static Integer recursiveSolution(Integer[] array, Integer item, Integer low, Integer high) {
        LOGGER.fine(() -> Arrays.toString(Arrays.copyOfRange(array, low, high)));
        if (array.length > 0) {
            int mid = (low + high) / 2;
            if (Objects.equals(array[mid], item))
                return mid;
            else if (array[mid] > item)
                return recursiveSolution(array, item, low, mid - 1);
            else
                return recursiveSolution(array, item, mid + 1, high);
        }
        return -1;
    }
}
