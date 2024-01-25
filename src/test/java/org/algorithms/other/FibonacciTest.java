package org.algorithms.other;

import org.algorithms.others.Fibonacci;
import org.algorithms.utils.BenchmarkTools;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FibonacciTest {

    @ParameterizedTest
    @CsvSource({
            "10,55",
            "0,0",
            "1,1",
            "4,3",
            "15,610",
            "30,832040",
            "35,9227465",
    })
    void withoutMemoization(Integer n, Integer expected) {
        Assertions.assertEquals(
                expected,
                BenchmarkTools.benchmark(Fibonacci.WITHOUT_MEMOIZATION, n)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "10,55",
            "0,0",
            "1,1",
            "4,3",
            "15,610",
            "30,832040",
            "35,9227465",
    })
    void withMemoization(Integer n, Integer expected) {
        Assertions.assertEquals(
                expected,
                BenchmarkTools.benchmark(Fibonacci.WITH_MEMOIZATION, n, new int[n + 1])
        );
    }

}
