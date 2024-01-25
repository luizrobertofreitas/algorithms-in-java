package org.algorithms.grokkingbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.algorithms.utils.ArrayCrazyOps.CONVERT_STRING_TO_INTEGER_ARRAY;

class DivideAndConquerTest {

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1,2,3,4,5,6;21",
            "10,20,30,40,50,60;210",
            "1,0,3,0,5,0;9",
            "1001,1002,1003,1004;4010",
            "0,0,0,1,0,0;1",
            "0,0,0,1,0,-1;0",
            "1,0,0,0,0,-5;-4"
    })
    void sumTest(String input, Integer expectedResult) {
        Integer[] array = CONVERT_STRING_TO_INTEGER_ARRAY.apply(input);
        Assertions.assertEquals(expectedResult, DivideAndConquer.sum.applyAsInt(array));
    }
}
