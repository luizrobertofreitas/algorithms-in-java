package org.algorithms.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;

public class ArrayCrazyOpsTest {

    @Test
    @Timeout(1)
    public void deletionTest() {
        Integer[] array = {10, 20, 30, 50, 40, 100, 90, 80, 70};
        Integer[] resultArray = ArrayCrazyOps.deleteFromArray(array, 3);
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Result Array: " + Arrays.toString(resultArray));
        Assertions.assertEquals(array.length - 1, resultArray.length);
        Assertions.assertEquals(0, Arrays.stream(resultArray).filter(i -> i == 50).count());
    }
}
