package org.algorithms.algs4.module5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SortersTest {

    @Timeout(20)
    @ParameterizedTest
    @CsvSource({
            "10",
            "100",
            "1000",
            "10000",
    })
    void selectionSortTest(Integer size) {
        System.out.println("Size: " + size);
        Integer[] arr = generateArray(size);
        final String expected = Arrays.toString(arr);
        System.out.println("Expected: " + expected);
        Integer[] shuffleArr = shuffleArray(arr);
        System.out.println("Shuffle: " + Arrays.toString(shuffleArr));
        Sorters.SELECTION_SORT.accept(shuffleArr);
        System.out.println("Sorted: " + Arrays.toString(shuffleArr));
        Assertions.assertEquals(expected, Arrays.toString(shuffleArr));
        System.out.println("************************************************************************************");
    }

    @Timeout(20)
    @ParameterizedTest
    @CsvSource({
            "10",
            "100",
            "1000",
            "10000",
    })
    void insertionSortTest(Integer size) {
        System.out.println("Size: " + size);
        Integer[] arr = generateArray(size);
        final String expected = Arrays.toString(arr);
        System.out.println("Expected: " + expected);
        Integer[] shuffleArr = shuffleArray(arr);
        System.out.println("Shuffle: " + Arrays.toString(shuffleArr));
        Sorters.INSERTION_SORT.accept(shuffleArr);
        System.out.println("Sorted: " + Arrays.toString(shuffleArr));
        Assertions.assertEquals(expected, Arrays.toString(shuffleArr));
        System.out.println("************************************************************************************");
    }

    private Integer[] generateArray(int size) {
        Integer[] a = new Integer[size];
        for (int i = 0; i < size; a[i] = i, i++);
        return a;
    }

    public Integer[] shuffleArray(Integer[] a) {
        List<Integer> l = Arrays.asList(a);
        Collections.shuffle(l);
        return l.toArray(new Integer[a.length]);
    }
}
