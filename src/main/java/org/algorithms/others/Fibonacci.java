package org.algorithms.others;

import java.util.function.BiFunction;
import java.util.function.IntFunction;

public final class Fibonacci {
    private Fibonacci() {}

    public static final IntFunction<Integer> WITHOUT_MEMOIZATION = n -> {
        if (n == 0 || n == 1) return n;
        return Fibonacci.WITHOUT_MEMOIZATION.apply(n - 1) + Fibonacci.WITHOUT_MEMOIZATION.apply(n - 2);
    };

    public static final BiFunction<Integer, int[], Integer> WITH_MEMOIZATION = (n, memo) -> {
        if (n == 0 || n == 1) return n;
        if (memo[n] == 0) {
            memo[n] = Fibonacci.WITHOUT_MEMOIZATION.apply(n - 1) + Fibonacci.WITHOUT_MEMOIZATION.apply(n - 2);
        }
        return memo[n];
    };
}
