package org.algorithms.other;

import org.algorithms.others.TwoPointers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TwoPointersTest {

    @ParameterizedTest
    @CsvSource({
        "rever,true",
        "not,false",
        "aaaabbbbcccccdcccccbbbbaaaa,true",
        "aaaabbbbcccccdcccccbbbbaaaaz,false",
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccccccccccccdccccccccccccccccccccccccccccccccccccccccbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,true"
    })
    void palindromeTest(String input, Boolean expected) {
        Assertions.assertEquals(expected, TwoPointers.PALINDROME.test(input));
    }
}
