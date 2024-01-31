package org.algorithms.other.distance;

import org.algorithms.others.distance.HammingDistance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HammingDistanceTest {

    @ParameterizedTest
    @CsvSource({
            "karolin,kathrin,3",
            "karolin,kerstin,3",
            "kathrin,kerstin,4",
            "karolin,karolin,0",
            "0000,1111,4",
            "0000,1011,3",
            "0000,1001,2",
            "0000,0100,1",
    })
    void test(String str1, String str2, Integer expected) {
        Assertions.assertEquals(expected, HammingDistance.SOLUTION.apply(str1, str2));
    }
}
