package org.algorithms.others;

import java.util.function.Predicate;

public class TwoPointers {
    public static final Predicate<String> PALINDROME = input -> {
        for (int i = 0, j = input.length() - 1; i < input.length() / 2; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) return false;
        }
        return true;
    };
}
