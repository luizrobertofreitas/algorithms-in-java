package org.algorithms.others;

import java.math.BigInteger;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public final class MathExercises {

    private MathExercises() {}

    public static final BinaryOperator<BigInteger> KARATSUBA_MULTIPLICATION = (x, y) -> {
        int n = Math.max(x.bitLength(), y.bitLength());

        // Base case: if numbers are small, use regular multiplication
        if (n <= 2000) { // Threshold can be adjusted
            return x.multiply(y);
        }

        // Divide the numbers into halves
        int m = (n / 2);
        BigInteger high1 = x.shiftRight(m);
        BigInteger low1 = x.subtract(high1.shiftLeft(m));
        BigInteger high2 = y.shiftRight(m);
        BigInteger low2 = y.subtract(high2.shiftLeft(m));

        // Recursive multiplications

        // S1 = B * D
        BigInteger z0 = MathExercises.KARATSUBA_MULTIPLICATION.apply(low1, low2);
        // S2 = (A+B) * (C+D)
        BigInteger z1 = MathExercises.KARATSUBA_MULTIPLICATION.apply(low1.add(high1), low2.add(high2));
        // S3 = A * C
        BigInteger z2 = MathExercises.KARATSUBA_MULTIPLICATION.apply(high1, high2);

        // Karatsuba formula: AC * 10^2m + (S2 - S3 - S1) * 10^m + BD
        return z2.shiftLeft(2 * m).add(z1.subtract(z2).subtract(z0).shiftLeft(m)).add(z0);
    };

    // 1000 + 1 = 1001
    // 1000 * 1001 = 1001000
    // 1001000 / 2 = 500500
    public static final IntBinaryOperator SUM_SEQ_OF_NUMBERS_V2 = (start, end) ->
        (end * (end + start)) / 2;

    public static final IntBinaryOperator SUM_SEQ_OF_NUMBERS_V1 = (start, end) -> {
        Integer sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    };
}
