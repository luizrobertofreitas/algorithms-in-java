package org.algorithms.other;

import org.algorithms.others.IpHeaderCheckSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class IpHeaderCheckSumTest {

    /*
        Sample of the calculation doing step by step

        First sum (first and second binaries)
            11111111 11111111 +
            11111111 00000000 =
         [1]11111110 11111111 +   <- carries 1 and sum it
                            1 =
            11111111 00000000

        Second sum based on the result above
            11111111 00000000 +
            11110000 11110000 =
         [1]11101111 11110000 +   <- carries 1 and sum it
                            1 =
            11101111 11110001

        Third sum based on the result above
            11101111 11110001 +
            11000000 11000000 =
         [1]10110000 10110001 +   <- carries 1 and sum it
                            1 =
            10110000 10110010

        Now Applies the One's complement (invert all the bits of the number; 0 becomes 1 and vice-versa)
            01001111 01001101

    */
    @Test
    @Timeout(1)
    void calculate16BitsTest() {
        final Integer numOfBits = 16;
        final String expected = "0100111101001101";
        final Integer[] arr = new Integer[] {
                0b1111111111111111,
                0b1111111100000000,
                0b1111000011110000,
                0b1100000011000000
        };
        final Integer result = IpHeaderCheckSum.CALCULATE.applyAsInt(arr, numOfBits);
        Assertions.assertEquals(expected, IpHeaderCheckSum.PRINT.apply(result, numOfBits));
    }
}
