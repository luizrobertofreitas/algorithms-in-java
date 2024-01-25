package org.algorithms.utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.BiFunction;
import java.util.function.IntFunction;

public final class BenchmarkTools {

    private BenchmarkTools() {}

    public static <T> T benchmark(final IntFunction<T> fn, int v) {
        final LocalDateTime start = LocalDateTime.now();
        final T result = fn.apply(v);
        System.out.println("Function: " + fn.getClass().getSimpleName() + " with param: " + v + ", executed in " + Duration.between(start, LocalDateTime.now()));
        return result;
    }

    public static <T, U, R> R benchmark(final BiFunction<T, U, R> fn, T v1, U v2) {
        final LocalDateTime start = LocalDateTime.now();
        final R result = fn.apply(v1, v2);
        System.out.println("Function: " + fn.getClass().getSimpleName() + " with params: " + v1 + " and " + v2 + ", executed in " + Duration.between(start, LocalDateTime.now()));
        return result;
    }
}
