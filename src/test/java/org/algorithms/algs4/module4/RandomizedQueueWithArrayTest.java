package org.algorithms.algs4.module4;

import org.algorithms.algs4.module4.RandomizedQueueWithArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomizedQueueWithArrayTest {

    @Test
    void emptyOnCreateTest() {
        final RandomizedQueueWithArray rq = new RandomizedQueueWithArray();
        Assertions.assertTrue(rq.isEmpty());
    }

    @Test
    void enqueueFirstItemOnDequeTest() {
        final RandomizedQueueWithArray rq = new RandomizedQueueWithArray();
        rq.enqueue("1");
        Assertions.assertEquals(1, rq.size());
        Assertions.assertFalse(rq.isEmpty());
        Assertions.assertEquals("1", rq.dequeue());
        Assertions.assertEquals(0, rq.size());
        Assertions.assertTrue(rq.isEmpty());
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
    void enqueueMassiveItemsAndDequeueTest(int amount) {
        final RandomizedQueueWithArray rd = new RandomizedQueueWithArray();
        for (int i = 0; i < amount; i++) {
            rd.enqueue(String.valueOf(i));
        }
        Assertions.assertEquals(amount, rd.size());
        for (int i = 0; i < amount; i++) {
            String current = rd.dequeue();
            int currentInt = Integer.parseInt(current);
            Assertions.assertNotEquals(String.valueOf(currentInt + 1), current);
        }
        Assertions.assertEquals(0, rd.size());
        Assertions.assertTrue(rd.isEmpty());
    }

    @ParameterizedTest
    @CsvSource({
        "100",
        "1000",
        "10000",
        "100000",
    })
    void enqueueMassiveItemsAndDuplicatedDequeueTest(int amount) {
        final RandomizedQueueWithArray rd = new RandomizedQueueWithArray();
        for (int i = 0; i < amount; i++) {
            rd.enqueue(String.valueOf(i));
        }
        Assertions.assertEquals(amount, rd.size());
        StringBuilder dequeued = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            String current = rd.dequeue();
            int currentInt = Integer.parseInt(current);
            Assertions.assertNotEquals(String.valueOf(currentInt + 1), current);
            Assertions.assertFalse(dequeued.toString().contains("," + current + ","));
            dequeued.append(current).append(",");
        }
        Assertions.assertEquals(0, rd.size());
        Assertions.assertTrue(rd.isEmpty());
    }
}
