package org.algorithms.grokkingbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        String[] stringArray = input.split(",");
        Integer[] array = new Integer[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            array[i] = Integer.valueOf(stringArray[i]);
        }
        Assertions.assertEquals(expectedResult, DivideAndConquer.sum.applyAsInt(array));
    }
}