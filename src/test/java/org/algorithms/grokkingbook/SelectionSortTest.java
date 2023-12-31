package org.algorithms.grokkingbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;

class SelectionSortTest {

    @Test
    @Timeout(1)
    void test1() {
        Integer[] array = {50, 10, 30, 40, 90, 70, 20, 110, 20, 200, 140, 120};
        Integer[] sortedArrayResult = SelectionSort.SOLUTION.apply(array);
        Integer[] langSortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(langSortedArray);
        Assertions.assertEquals(Arrays.toString(langSortedArray), Arrays.toString(sortedArrayResult));
    }

    @Test
    @Timeout(1)
    void test2() {
        Integer[] array = {50, Integer.MIN_VALUE, 30, 40, Integer.MAX_VALUE, 70, 20, 110, Integer.MAX_VALUE, 200, Integer.MAX_VALUE, 120};
        Integer[] sortedArrayResult = SelectionSort.SOLUTION.apply(array);
        Integer[] langSortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(langSortedArray);
        System.out.println("Original Array: " + Arrays.toString(array));
        System.out.println("Lang Sorted Array: " + Arrays.toString(langSortedArray));
        System.out.println("Result Sorted Array: " + Arrays.toString(sortedArrayResult));
        Assertions.assertEquals(Arrays.toString(langSortedArray), Arrays.toString(sortedArrayResult));
    }
}
