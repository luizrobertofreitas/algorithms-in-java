package org.algorithms.algs4.module4.assignment;

import org.algorithms.utils.ArrayCrazyOps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

class RandomizedQueueIteratorTest {
    @Test
    void unsupportedIteratorRemoveOperationTest() {
        final RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        final Iterator<Integer> rqi = rq.iterator();
        Assertions.assertThrows(UnsupportedOperationException.class, rqi::remove);
    }

    @Test
    void emptyIteratorTest() {
        final RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        final Iterator<Integer> rqi = rq.iterator();
        Assertions.assertFalse(rqi.hasNext());
        Assertions.assertThrows(NoSuchElementException.class, rqi::next);
    }

    @ParameterizedTest
    @CsvSource({
            "100",
            "1000",
//            "10000",
//            "100000",
//            "1000000",
//            "10000000",
    })
    void massiveIteratorItemsOnEnqueueTest(int size) {
        final Integer[] arr = createArray(size);
        final RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        for (Integer i : arr) rq.enqueue(i);
        Assertions.assertEquals(size, rq.size());

        final Integer[] resultArr = new Integer[size];
        final Iterator<Integer> rqi = rq.iterator();
        int count = 0;
        while(rqi.hasNext()) resultArr[count++] = rqi.next();
        final String arr1 = Arrays.toString(arr);
        final String resultArr1 = Arrays.toString(resultArr);
        System.out.println(arr1);
        System.out.println(resultArr1);
        Assertions.assertEquals(arr1.length(), resultArr1.length());
        Assertions.assertNotEquals(arr1, resultArr1);
    }

    private Integer[] createArray(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; arr[i++] = i);
        return arr;
    }
}
