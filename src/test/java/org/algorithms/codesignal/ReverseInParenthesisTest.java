package org.algorithms.codesignal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// Set a timeout of a second
public class ReverseInParenthesisTest {

    @Timeout(1)
    @ParameterizedTest
    @CsvSource({
            "(bar),rab",
            "foo(bar)baz,foorabbaz",
            "foo(bar)baz(blim),foorabbazmilb",
            "foo(bar(baz))blim,foobazrabblim",
            ",",
            "(),",
            "(abc)d(efg),cbadgfe"
    })
    public void run(String input, String expectedResult) {
        if (expectedResult == null) expectedResult = "";
        Assertions.assertEquals(expectedResult, ReverseInParenthesis.SOLUTION.apply(input));
    }
}
