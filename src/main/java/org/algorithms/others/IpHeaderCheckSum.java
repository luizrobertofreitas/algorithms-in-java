package org.algorithms.others;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.ToIntBiFunction;

/*
    This guy helped a lot: https://www.youtube.com/watch?v=yHDyApknnU4

    And this was fundamental: https://gist.github.com/david-hoze/0c7021434796997a4ca42d7731a7073a
*/
public final class IpHeaderCheckSum {
    private IpHeaderCheckSum() {}

    public static final ToIntBiFunction<Integer[], Integer> CALCULATE = (arrayOfNBits, numOfBits) ->
        ~Arrays.stream(arrayOfNBits).reduce(0, (acc, b) -> {
            acc += b;
            while (Integer.toBinaryString(acc).length() > 16) {
                acc = (acc & 0xffff) + (acc >> 16);
            }
            return acc;
        });

    public static final BiFunction<Integer, Integer, String> PRINT = (number, numOfBits) -> {
        String numberAsString = Integer.toBinaryString(number);
        if (numberAsString.length() > numOfBits) {
            numberAsString = numberAsString.substring(numberAsString.length() - numOfBits);
        }
        return numberAsString;
    };
}
