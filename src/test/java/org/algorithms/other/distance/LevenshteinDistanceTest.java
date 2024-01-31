package org.algorithms.other.distance;

import org.algorithms.others.distance.LevenshteinDistance;
import org.algorithms.utils.BenchmarkTools;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LevenshteinDistanceTest {

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
            "kitten,sitting,3",
            "Saturday,Sunday,3",
            "glomax,folmax,3",
            "dog,,3",
            "w61dUqcZXKr2qGhqi42Mf58ZGwDnd3teH8QN4R6yjqRwh9n6hjZQUjrTSMFvakSMwyQQ4q1beB5BWwCQUiZSuhyLfevZT34mAQZPv1hRcWZmjL50ME3ggfEuC2Cv5YGnWh2RtfQfUKmQKVZRyb7RWRDBmQaE45NGfVfG20RMtjp43MiAKhZwwvLrcmFHS3Eq2xFjQS9c,w61dUqcZXKr2qGhqi42Mf58ZGwDnd3teH8QN4R6yjZZRwh9n6hjZQUjrTSMFvakSMwyQQ4q1bZZB5BWwCQUiZSuhyLfevZT34mAQZPv1hRcWZmjL50ME3ggfZZuC2Cv5YGnWh2RtfQfUKmQKVZRyb7RWRDBmQaE45NGfVfG20RMtjp43MiAKZZZwwvLrcmFHS3Eq2xFjQS9,9"
    })
    void test(String str1, String str2, Integer expected) {
        Assertions.assertEquals(
                expected,
                BenchmarkTools.benchmark(LevenshteinDistance.CALCULATE_WITH_MEMOIZATION, str1, str2)
        );
    }

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
            "kitten,sitting,3",
            "Saturday,Sunday,3",
            "glomax,folmax,3",
            "dog,,3",
            // The test case below takes too long to execute. Takes > 30 seconds
//            "w61dUqcZXKr2qGhqi42Mf58ZGwDnd3teH8QN4R6yjqRwh9n6hjZQUjrTSMFvakSMwyQQ4q1beB5BWwCQUiZSuhyLfevZT34mAQZPv1hRcWZmjL50ME3ggfEuC2Cv5YGnWh2RtfQfUKmQKVZRyb7RWRDBmQaE45NGfVfG20RMtjp43MiAKhZwwvLrcmFHS3Eq2xFjQS9c,w61dUqcZXKr2qGhqi42Mf58ZGwDnd3teH8QN4R6yjZZRwh9n6hjZQUjrTSMFvakSMwyQQ4q1bZZB5BWwCQUiZSuhyLfevZT34mAQZPv1hRcWZmjL50ME3ggfZZuC2Cv5YGnWh2RtfQfUKmQKVZRyb7RWRDBmQaE45NGfVfG20RMtjp43MiAKZZZwwvLrcmFHS3Eq2xFjQS9,9"
    })
    void test2(String str1, String str2, Integer expected) {
        Assertions.assertEquals(
                expected,
                BenchmarkTools.benchmark(LevenshteinDistance.CALCULATE_RECURSIVE, str1, str2)
        );
    }
}
