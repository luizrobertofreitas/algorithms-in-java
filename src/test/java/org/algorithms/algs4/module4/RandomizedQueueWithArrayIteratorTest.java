package org.algorithms.algs4.module4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

class RandomizedQueueWithArrayIteratorTest {
    @Test
    void unsupportedIteratorRemoveOperationTest() {
        final RandomizedQueueWithArray rq = new RandomizedQueueWithArray();
        final Iterator<String> rqi = rq.iterator();
        Assertions.assertThrows(UnsupportedOperationException.class, rqi::remove);
    }

    @Test
    void emptyIteratorTest() {
        final RandomizedQueueWithArray rq = new RandomizedQueueWithArray();
        final Iterator<String> rqi = rq.iterator();
        Assertions.assertFalse(rqi.hasNext());
        Assertions.assertThrows(NoSuchElementException.class, rqi::next);
    }

    @ParameterizedTest
    @CsvSource({
            "100",
            "1000",
            "10000",
            "100000",
//            "1000000",
//            "10000000",
    })
    void massiveIteratorItemsOnEnqueueTest(int size) {
        final Integer[] arr = createArray(size);
        final RandomizedQueueWithArray rq = new RandomizedQueueWithArray();
        for (Integer i : arr) rq.enqueue(String.valueOf(i));
        Assertions.assertEquals(size, rq.size());

        final String[] resultArr = new String[size];
        final Iterator<String> rqi = rq.iterator();
        int count = 0;
        while(rqi.hasNext()) resultArr[count++] = rqi.next();
        Assertions.assertNotEquals(Arrays.toString(arr), Arrays.toString(resultArr));
    }

    private Integer[] createArray(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; arr[i++] = i);
        return arr;
    }
}
