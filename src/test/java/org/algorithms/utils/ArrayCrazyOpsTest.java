package org.algorithms.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Stream;

class ArrayCrazyOpsTest {

    @Test
    @Timeout(1)
    void deletionTest() {
        Integer[] array = {10, 20, 30, 50, 40, 100, 90, 80, 70};
        Integer[] resultArray = ArrayCrazyOps.deleteFromArray(array, 3);
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Result Array: " + Arrays.toString(resultArray));
        Assertions.assertEquals(array.length - 1, resultArray.length);
        Assertions.assertEquals(0, Arrays.stream(resultArray).filter(i -> i == 50).count());
    }

    @Test
    @Timeout(1)
    void integerConcatenateTest() {
        Integer[] first = {1,2,3,4,5};
        Integer[] second = {6,7,8,9,10};
        Integer[] third = {11,12,13,14,15};
        Integer[] fourth = {16,17,18,19,20};
        Integer[] fifth = {21,22,23,24,25};
        Integer[] result = ArrayCrazyOps.integerArrayConcat(first, second, third, fourth, fifth);
        System.out.println(Arrays.toString(result));
        boolean isResultInTheRightSequence = true;
        for (int i = 1, prev = result[0]; i < result.length;  prev = result[i], i++) {
            if (result[i] < prev) {
                isResultInTheRightSequence = false;
                break;
            }
        }
        Assertions.assertTrue(isResultInTheRightSequence);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1,2,3,4,5,6,7,8,9,10;55",
            "0,0,3,4,5,-1,201;212",
    })
    @Timeout(1)
    void convertStringToIntegerArray(String input, Integer expectedResult) {
        final Integer[] arr = ArrayCrazyOps.convertStringToIntegerArray(input);
        final Integer sum = Stream.of(arr).reduce(0, Integer::sum);
        Assertions.assertEquals(expectedResult, sum);
    }
}
