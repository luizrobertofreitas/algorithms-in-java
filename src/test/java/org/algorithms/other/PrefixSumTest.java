package org.algorithms.other;

import org.algorithms.others.PrefixSum;
import org.algorithms.utils.ArrayCrazyOps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class PrefixSumTest {

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4,5;[1, 3, 6, 10, 15]"
    })
    void prefixArrayGen(String input, String expected) {
        Integer[] arr = ArrayCrazyOps.CONVERT_STRING_TO_INTEGER_ARRAY.apply(input);
        Assertions.assertEquals(expected, Arrays.toString(PrefixSum.PREFIX_ARRAY_GEN.apply(arr)));
    }
}
