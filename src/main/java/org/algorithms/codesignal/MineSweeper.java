package org.algorithms.codesignal;

import java.util.Arrays;
import java.util.function.Function;

import static org.algorithms.utils.ArrayCrazyOps.CONVERT_PRIMITIVE_INT_MATRIX_TO_INTEGER_MATRIX;

public final class MineSweeper {
    private MineSweeper() {}

    public static final Function<Boolean[][], Integer[][]> GENERATE_PROXIMITY = matrix -> {
        final int[][] result = new int[matrix.length][matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c]) {
                     System.out.println("Bomb at: (r="+r+", c="+c+")");
                     System.out.println("Updating neighbors");
                    if (r == 0) {
                        result[r+1][c]++;
                        if (c == 0) {
                            result[r][c+1]++;
                            result[r+1][c+1]++;
                        }
                        if (c == result[r].length - 1) {
                            result[r+1][c-1]++;
                            result[r][c-1]++;
                        }
                        if (c > 0 && c < result[r].length - 1) {
                            result[r+1][c+1]++;
                            result[r+1][c-1]++;
                            result[r][c+1]++;
                            result[r][c-1]++;
                        }
                    }
                    if (r == result.length - 1) {
                        result[r-1][c]++;
                        if (c == 0) {
                            result[r-1][c+1]++;
                            result[r][c+1]++;
                        }
                        if (c == result[r].length - 1) {
                            result[r-1][c-1]++;
                            result[r][c-1]++;
                        }
                        if (c > 0 && c < result[r].length - 1) {
                            result[r-1][c+1]++;
                            result[r-1][c-1]++;
                            result[r][c+1]++;
                            result[r][c-1]++;
                        }
                    }
                    if (r > 0 && r < result.length - 1) {
                        result[r-1][c]++;
                        result[r+1][c]++;
                        if (c == 0) {
                            result[r-1][c+1]++;
                            result[r+1][c+1]++;
                            result[r][c+1]++;
                        }
                        if (c == result[r].length - 1) {
                            result[r-1][c-1]++;
                            result[r+1][c-1]++;
                            result[r][c-1]++;
                        }
                        if (c > 0 && c < result[r].length - 1) {
                            result[r-1][c-1]++;
                            result[r][c-1]++;
                            result[r+1][c-1]++;
                            result[r-1][c+1]++;
                            result[r][c+1]++;
                            result[r+1][c+1]++;
                        }
                    }
                     Arrays.stream(result).forEach(arr -> System.out.println(Arrays.toString(arr)));
                     System.out.println("==================================================");
                }
            }
        }

        return CONVERT_PRIMITIVE_INT_MATRIX_TO_INTEGER_MATRIX.apply(result);
    };
}
