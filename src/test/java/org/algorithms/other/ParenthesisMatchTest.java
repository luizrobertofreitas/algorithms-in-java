package org.algorithms.other;

import org.algorithms.others.ParenthesisMatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ParenthesisMatchTest {

    @Timeout(1) // under a second
    @ParameterizedTest
    @CsvSource({
            "(()()())(),true",
            "(()()())()(,false",
            "(()()())()((((()))))()(()),true",
            "((()()())()(())),true",
            "((()()())()()),true",
            "((()()())()())(((((((((())))))))),false",
            "(((baz)()())()(foo bar bits)),true",
            "((2*(2+1)(0-1)(3/2))(4*100)5*(foo bar bits)),true",
    })
    void run(String input, Boolean expectedResult) {
        Assertions.assertEquals(expectedResult, ParenthesisMatch.SOLUTION.test(input));
    }
}
