package org.algorithms.others;

import java.util.function.BiFunction;

/*
    https://en.wikipedia.org/wiki/Hamming_distance
*/
public final class HammingDistance {

    private HammingDistance() {}

    public static final BiFunction<String, String, Integer> SOLUTION = (str1, str2) -> {
        Integer diff = 0;
        if (str1.length() != str2.length()) return -1;
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        for (int i = 0; i < str1Arr.length; i++) {
            if (str1Arr[i] != str2Arr[i]) diff++;
        }
        return diff;
    };
}
