package org.algorithms.codesignal;

import java.util.function.ToIntFunction;

public final class ArrayChange {
    private ArrayChange() {}

    public static final ToIntFunction<Integer[]> SOLUTION = array -> {
        int moves = 0;
        for (int i = 1; i < array.length; i++) if (array[i] == array[i-1]) {
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
