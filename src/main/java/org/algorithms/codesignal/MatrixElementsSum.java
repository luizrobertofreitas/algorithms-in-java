package org.algorithms.codesignal;

import java.util.function.Function;

/*
    After becoming famous, the CodeBots decided to move into a new building together. Each of the rooms has a different cost,
    and some of them are free, but there's a rumour that all the free rooms are haunted! Since the CodeBots are quite superstitious,
    they refuse to stay in any of the free rooms, or any of the rooms below any of the free rooms.

    Given matrix, a rectangular matrix of integers, where each value represents the cost of the room, your task is to return
    the total sum of all rooms that are suitable for the CodeBots (ie: add up all the values that don't appear below a 0).
*/
public class MatrixElementsSum {

    public static final Function<Integer[][], Integer> COLUMN_SOLUTION = matrix -> {
        int sum = 0;
        int c = 0;
        for (int r = 0; r < matrix.length; r++) {
            if (c == matrix[0].length) break; // if we reached out the end of the columns, bye
            sum += matrix[r][c]; // since haunted rooms are 0 and doesn't impact in the sum, no problem summing them up
            if (matrix[r][c] == 0) { // if it is a haunted room, we skip the rest of the column
                c++;
                r=-1;
                continue;
            }
            if (r + 1 == matrix.length) { // if we were able to reach the last row
                c++;
                r=-1;
            }
        }
        return sum;
    };

    public static final Function<Integer[][], Integer> TRIVIAL_SOLUTION = matrix -> {
        System.out.println(matrix[0].length);
        int[] hauntedColumns = new int[matrix[0].length];
        int sum = 0;
        for (Integer[] integers : matrix) {
            for (int c = 0; c < integers.length; c++) {
                if (hauntedColumns[c] == -1) continue;
                if (integers[c] == 0)
                    hauntedColumns[c] = -1;
                sum += integers[c];
            }
        }
        return sum;
    };
}
