package org.algorithms.others;

import java.math.BigInteger;

public class KaratsubaMultiplication {
    public static BigInteger karatsuba(BigInteger x, BigInteger y) {
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
        BigInteger z0 = karatsuba(low1, low2);          // B * D
        BigInteger z1 = karatsuba(low1.add(high1), low2.add(high2)); // (A+B) * (C+D)
        BigInteger z2 = karatsuba(high1, high2);        // A * C

        // Karatsuba formula: AC * 10^2m + ((A+B)(C+D) - AC - BD) * 10^m + BD
        return z2.shiftLeft(2 * m).add(z1.subtract(z2).subtract(z0).shiftLeft(m)).add(z0);
    }
}
