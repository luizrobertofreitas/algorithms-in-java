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
            "100000",
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

    @Timeout(20)
    @ParameterizedTest
    @CsvSource({
            "10",
            "100",
            "1000",
            "10000",
            "100000",
    })
    void shellSortTest(Integer size) {
        System.out.println("Size: " + size);
        Integer[] arr = generateArray(size);
        final String expected = Arrays.toString(arr);
        System.out.println("Expected: " + expected);
        Integer[] shuffleArr = shuffleArray(arr);
        System.out.println("Shuffle: " + Arrays.toString(shuffleArr));
        Sorters.SHELL_SORT.accept(shuffleArr);
        System.out.println("Sorted: " + Arrays.toString(shuffleArr));
        Assertions.assertEquals(expected, Arrays.toString(shuffleArr));
        System.out.println("************************************************************************************");
    }

//    @Timeout(20)
//    @ParameterizedTest
//    @CsvSource({
//            "3",
//            "4",
//            "5",
//            "6",
//    })
    void badShufflerConsideringA3rdOfPossiblePermutationsTest(Integer size) {
        Integer numberOfPermutations = factorial(size); // considering a 3rd of permutations possible
        System.out.println("Number of permutations on shuffling: " + numberOfPermutations);
        Integer[][] arrHistory = new Integer[numberOfPermutations][];
        arrHistory[0] = generateArray(size);

        for (int i = 1; i < numberOfPermutations; i++) {
            Integer[] toBeShuffled = Arrays.copyOf(arrHistory[0], size); // considering the last one
            Sorters.SHUFFLER.accept(toBeShuffled);
            arrHistory[i] = toBeShuffled;
        }

        for (int i = 0; i < numberOfPermutations; i++) {
            System.out.println(Arrays.toString(arrHistory[i]));
        }

        for (int i = 0; i < numberOfPermutations; i++)
            for (int j = 0; j < numberOfPermutations; j++) {
                if (i != j) Assertions.assertNotEquals(Arrays.toString(arrHistory[i]), Arrays.toString(arrHistory[j]));
            }
    }

    @ParameterizedTest
    @CsvSource({
            "2,2",
            "3,6",
            "4,24",
            "5,120"
    })
    void testingFactorial(Integer n, Integer expected) {
        Assertions.assertEquals(expected, factorial(n));
    }

    private Integer[] generateArray(int size) {
        Integer[] a = new Integer[size];
        for (int i = 0; i < size; i++)
            a[i] = i;
        return a;
    }

    private Integer factorial(Integer n) {
        if (n == 1) return n;
        else return factorial(n -1 ) * n;
    }

    private Integer[] shuffleArray(Integer[] a) {
        List<Integer> l = Arrays.asList(a);
        Collections.shuffle(l);
        return l.toArray(new Integer[a.length]);
    }
}
