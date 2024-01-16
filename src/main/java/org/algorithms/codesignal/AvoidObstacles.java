package org.algorithms.codesignal;

import java.util.function.ToIntFunction;

/*
    You are given an array of integers representing coordinates of obstacles situated on a straight line.

    Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only to make jumps of the same length represented by some integer.

    Find the minimal length of the jump enough to avoid all the obstacles.

    Example

    For inputArray = [5, 3, 6, 7, 9, 11], the output should be
    solution(inputArray) = 4.

    Check out the pic below for better understanding:
    |-------|-------|------||----
    0 1 2 3 4 5 6 7 8 9 10 11 12

    Non-empty array of positive integers.

    Guaranteed constraints:
        2 ≤ inputArray.length ≤ 1000,
        1 ≤ inputArray[i] ≤ 1000
*/
public final class AvoidObstacles {
    private AvoidObstacles() {}

    public static final ToIntFunction<Integer[]> SOLUTION = arr -> {
        if (arr.length == 1) return 2;
        if (arr.length == 0) return 0;
        int jump = 1;
        boolean fail = true;

        while(fail) {
            jump++;
            fail = false;
            for (Integer integer : arr)
                if (integer % jump == 0) {
                    fail = true;
                    break;
                }
        }

        return jump;
    };
}
