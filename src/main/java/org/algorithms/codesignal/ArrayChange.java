package org.algorithms.codesignal;

import java.util.function.ToIntFunction;

/*
    You are given an array of integers. On each move you are allowed to increase exactly one
    of its element by one. Find the minimal number of moves required to obtain a strictly
    increasing sequence from the input.

    Example

    For inputArray = [1, 1, 1], the output should be
    solution(inputArray) = 3.
 */
public final class ArrayChange {
    private ArrayChange() {}

    public static final ToIntFunction<Integer[]> SOLUTION = array -> {
        int moves = 0;
        for (int i = 1; i < array.length; i++) if (array[i].equals(array[i-1])) {
            moves++;
            array[i]++;
        } else if (array[i] < array[i-1]) {
            int diff = array[i-1] - array[i] + 1;
            array[i] += diff;
            moves += diff;
        }
        return moves;
    };
}
