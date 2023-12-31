package org.algorithms.codesignal;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

/*
    Given a string, find out if its characters can be rearranged to form a palindrome.

    Example

    For inputString = "aabb", the output should be
    solution(inputString) = true.

    We can rearrange "aabb" to make "abba", which is a palindrome.
 */
public final class PalindromeRearranging {
    private PalindromeRearranging() {}

    public static final Predicate<String> SOLUTION = input -> {
        Map<Character, Integer> counter = new TreeMap<>();
        for (Character c : input.toCharArray()) if (counter.containsKey(c)) {
            counter.put(c, counter.get(c) + 1);
        } else {
            counter.put(c, 1);
        }
        return counter.values().stream().filter(i -> i % 2 != 0).count() < 2;
    };
}
