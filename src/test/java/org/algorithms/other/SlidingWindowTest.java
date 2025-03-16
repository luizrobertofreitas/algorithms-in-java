package org.algorithms.other;

import org.algorithms.others.SlidingWindow;
import org.algorithms.utils.ArrayCrazyOps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SlidingWindowTest {

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20;3;19",
        "18,19,20,4,5,6,7,8,9,10,11,12,13,14,15,16,17,1,2,3;3;19",
        "1,2,3,4,5,6,7,8,9,18,19,20,10,11,12,13,14,15,16,17;3;19"
    })
    void maximumAvgTest(String input, Integer subArrSize, Integer expected) {
        Assertions.assertEquals(
            expected,
            SlidingWindow.MAXIMUM_AVG_SUBARRAY.apply(
                ArrayCrazyOps.CONVERT_STRING_TO_INTEGER_ARRAY.apply(input),
                subArrSize
            )
        );
    }
}
