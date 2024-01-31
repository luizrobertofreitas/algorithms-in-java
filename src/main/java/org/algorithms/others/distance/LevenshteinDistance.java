package org.algorithms.others.distance;

import java.util.Arrays;
import java.util.function.BiFunction;

/*
    https://en.wikipedia.org/wiki/Levenshtein_distance

    https://www.geeksforgeeks.org/java-program-to-implement-levenshtein-distance-computing-algorithm/
*/
public final class LevenshteinDistance {
    private LevenshteinDistance() {}

    public static final BiFunction<String, String, Integer> CALCULATE_WITH_MEMOIZATION = (str1, str2) -> {
        if (str1 == null) str1 = "";
        if (str2 == null) str2 = "";
        int[][] memo = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0) memo[i][j] = j;
                else if (j == 0) memo[i][j] = i;
                else {
                    memo[i][j] = min(
                            memo[i - 1][j - 1] + costOfSubstitution(str1.charAt(i - 1), str2.charAt(j - 1)),
                            memo[i - 1][j] + 1,
                            memo[i][j - 1] + 1
                    );
                }
            }
        }
        return memo[str1.length()][str2.length()];
    };

    public static final BiFunction<String, String, Integer> CALCULATE_RECURSIVE = (str1, str2) -> {
        if (str1 == null) str1 = "";
        if (str2 == null) str2 = "";
        if (str1.isEmpty()) return str2.length();
        if (str2.isEmpty()) return str1.length();

        int substitution = LevenshteinDistance.CALCULATE_RECURSIVE.apply(str1.substring(1), str2.substring(1))
                + costOfSubstitution(str1.charAt(0), str2.charAt(0));
        int insertion = LevenshteinDistance.CALCULATE_RECURSIVE.apply(str1, str2.substring(1)) + 1;
        int deletion = LevenshteinDistance.CALCULATE_RECURSIVE.apply(str1.substring(1), str2) + 1;

        return min(substitution, insertion, deletion);
    };

    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int min(int ... numbers) {
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }
}
