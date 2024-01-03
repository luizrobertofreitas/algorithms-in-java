package org.algorithms.codesignal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PalindromeRearrangingTest {
    @ParameterizedTest
    @CsvSource({
            "aabb,true",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabc,false",
            "abbcabb,true",
            "zyyzzzzz,true",
            "z,true",
            "zaa,true",
            "abca,false",
            "abcad,false",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbccccaaaaaaaaaaaaa,false",
            "abdhuierf,false",
    })
    void test(String input, Boolean expectedResult) {
        Assertions.assertEquals(expectedResult, PalindromeRearranging.SOLUTION.test(input));
    }
}
