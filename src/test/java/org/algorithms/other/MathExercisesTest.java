package org.algorithms.other;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;
import static org.algorithms.others.MathExercises.*;

class MathExercisesTest {

    @ParameterizedTest
    @CsvSource({
        "12345678901234567890,98765432109876543210,1219326311370217952237463801111263526900"
    })
    void karatsubaTest(BigInteger x, BigInteger y, BigInteger expected) {
        Assertions.assertEquals(expected, KARATSUBA_MULTIPLICATION.apply(x, y));
    }

    @ParameterizedTest
    @CsvSource({
        "1,1000,500500",
        "1,10000,50005000"
    })
    void sumSeqOfNumbersTestV1(Integer start, Integer end, Integer expected) {
        Assertions.assertEquals(expected, SUM_SEQ_OF_NUMBERS_V1.applyAsInt(start, end));
    }

    @ParameterizedTest
    @CsvSource({
        "1,1000,500500",
        "1,10000,50005000"
    })
    void sumSeqOfNumbersTestV2(Integer start, Integer end, Integer expected) {
        Assertions.assertEquals(expected, SUM_SEQ_OF_NUMBERS_V2.applyAsInt(start, end));
    }
}
