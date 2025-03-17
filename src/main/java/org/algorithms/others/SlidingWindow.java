package org.algorithms.others;

import java.util.function.BiFunction;

public final class SlidingWindow {

    private SlidingWindow() {}

    // [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20] window size of 3
    //          the maximum avg is 19 (57/3)
    // [18,19,20,4,5,6,7,8,9,10,11,12,13,14,15,16,17,1,2,3] window size of 3
    //          the maximum avg is 19 (57/3)
    // [1,2,3,4,5,6,7,8,9,18,19,20,10,11,12,13,14,15,16,17] window size of 3
    //          the maximum avg is 19 (57/3)
    public static final BiFunction<Integer[], Integer, Integer> MAXIMUM_AVG_SUBARRAY = (arr, subArrSize) -> {
        Integer avg = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            Integer sum = 0;
            for (int j = i; j < i + subArrSize; j++) {
                sum += arr[j];
            }
            if (avg < (sum / subArrSize)) avg = sum / subArrSize;
        }
        return avg;
    };

    public static final BiFunction<Integer[], Integer, Integer> MAXIMUM_AVG_SUBARRAY_V2 = (arr, subArrSize) -> {
        // [1,2,3,4,5,6,7,8,9,10,11,12], sub = 3
        //  firstRound out of loop
        //      sum = 6
        //      left = 1
        //      right = 3
        // secondRound inside the loop
        //      sum = sum - left(1) + newRight(4) = 6 - 1 + 4 = 9
        //      left = 2
        //      right = 4

        Integer sum = 0;
        Integer left = 0;
        Integer right = subArrSize-1;

        // Initialize first sum and first avg
        for (int i = 0; i < subArrSize; i++) sum += arr[i];
        Integer avg = sum / subArrSize;

        // Slide through all windows
        for (int i = 1; i < arr.length - 2; i++) {
            right++;
            sum = sum - arr[left] + arr[right];
            left++;
            if (avg < sum / subArrSize) avg = sum / subArrSize;
        }
        return avg;
    };
}
