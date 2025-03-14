package org.algorithms.other;

import java.math.BigInteger;

import static org.algorithms.others.KaratsubaMultiplication.karatsuba;

public class KaratsubaMultiplicationTest {

    void test() {
        BigInteger x = new BigInteger("12345678901234567890");
        BigInteger y = new BigInteger("98765432109876543210");

        BigInteger result = karatsuba(x, y);
        System.out.println("Product: " + result);
    }
}
