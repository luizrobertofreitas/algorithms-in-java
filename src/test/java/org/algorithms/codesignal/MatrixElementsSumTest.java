package org.algorithms.codesignal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

// Set a timeout of a second
public class MatrixElementsSumTest {

    @Test
    @Timeout(1)
    public void test1() {
        final Integer[][] matrix = {
                {0,1,1,2},
                {0,5,0,0},
                {2,0,3,3}
        };
        final Integer expectedResult = 9;
        executeColumnSolutionTest(matrix, expectedResult);
        executeTrivialSolutionTest(matrix, expectedResult);
    }

    @Test
    @Timeout(1)
    public void test2() {
        final Integer[][] matrix = {
                {1,1,1,0},
                {0,5,0,1},
                {2,1,3,10}
        };
        final Integer expectedResult = 9;
        executeColumnSolutionTest(matrix, expectedResult);
        executeTrivialSolutionTest(matrix, expectedResult);
    }

    @Test
    @Timeout(1)
    public void test3() {
        final Integer[][] matrix = {
                {1,1,1},
                {2,2,2},
                {3,3,3}
        };
        final Integer expectedResult = 18;
        executeColumnSolutionTest(matrix, expectedResult);
        executeTrivialSolutionTest(matrix, expectedResult);
    }

    @Test
    @Timeout(1)
    public void test4() {
        final Integer[][] matrix = {{0}};
        final Integer expectedResult = 0;
        executeColumnSolutionTest(matrix, expectedResult);
        executeTrivialSolutionTest(matrix, expectedResult);
    }

    @Test
    @Timeout(1)
    public void test5() {
        final Integer[][] matrix = {
                {1},
                {5},
                {0},
                {2}
        };
        final Integer expectedResult = 6;
        executeColumnSolutionTest(matrix, expectedResult);
        executeTrivialSolutionTest(matrix, expectedResult);
    }

    @Test
    @Timeout(1)
    public void test6() {
        final Integer[][] matrix = {
                {1,2,3,4,5}
        };
        final Integer expectedResult = 15;
        executeColumnSolutionTest(matrix, expectedResult);
        executeTrivialSolutionTest(matrix, expectedResult);
    }

    @Test
    @Timeout(1)
    public void test7() {
        final Integer[][] matrix = {
                {2},
                {5},
                {10}
        };
        final Integer expectedResult = 17;
        executeColumnSolutionTest(matrix, expectedResult);
        executeTrivialSolutionTest(matrix, expectedResult);
    }

    @Test
    @Timeout(1)
    public void test8() {
        final Integer[][] matrix = {
                {4,0,1},
                {10,7,0},
                {0,0,0},
                {9,1,2}
        };
        final Integer expectedResult = 15;
        executeColumnSolutionTest(matrix, expectedResult);
        executeTrivialSolutionTest(matrix, expectedResult);
    }

    @Test
    @Timeout(1)
    public void test9() {
        final Integer[][] matrix = {
                {1}
        };
        final Integer expectedResult = 1;
        executeColumnSolutionTest(matrix, expectedResult);
        executeTrivialSolutionTest(matrix, expectedResult);
    }

    private void executeColumnSolutionTest(final Integer[][] matrix, final Integer expectedResult) {
        Assertions.assertEquals(expectedResult, MatrixElementsSum.COLUMN_SOLUTION.apply(matrix));
    }

    private void executeTrivialSolutionTest(final Integer[][] matrix, final Integer expectedResult) {
        Assertions.assertEquals(expectedResult, MatrixElementsSum.TRIVIAL_SOLUTION.apply(matrix));
    }
}
