package org.algorithms.codesignal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.algorithms.utils.ArrayCrazyOps.CONVERT_STRING_TO_INTEGER_ARRAY;

class AvoidObstaclesTest {
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "5,3,6,7,9,11;4",
            "5,3,6,7,9,12;8",
            "2,3;4",
            "1,4,10,6,2;7",
            "1000,999;6",
            "19,32,11,23;3",
            "5,8,9,13,14;6",
            "5;2",
            "8;2",
            "5,7;2",
            "5,7,8,9,10;6",
            "1,2;3",
            "4,5;3",
    })
    void test(String input, Integer expectedResult) {
        final Integer[] arr = CONVERT_STRING_TO_INTEGER_ARRAY.apply(input);
        final Integer jumps = AvoidObstacles.SOLUTION.applyAsInt(arr);
        Assertions.assertEquals(expectedResult, jumps);
    }
}
