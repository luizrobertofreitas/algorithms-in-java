package org.algorithms.algs4.module4.assignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomizedQueueTest {

    @Test
    void emptyOnCreateTest() {
        final RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        Assertions.assertTrue(rq.isEmpty());
    }

    @Test
    void enqueueFirstItemOnDequeTest() {
        final RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(1);
        Assertions.assertEquals(1, rq.size());
        Assertions.assertFalse(rq.isEmpty());
        Assertions.assertEquals(1, rq.dequeue());
        Assertions.assertEquals(0, rq.size());
        Assertions.assertTrue(rq.isEmpty());
    }

    @ParameterizedTest
    @CsvSource({
            "100",
            "1000",
            "10000",
            "100000",
            "1000000",
            "10000000",
    })
    void enqueueMassiveItemsAndDequeue(int amount) {
        final RandomizedQueue<Integer> rd = new RandomizedQueue<>();
        for (int i = 0; i < amount; i++) {
            rd.enqueue(i);
        }
        Assertions.assertEquals(amount, rd.size());
        for (int i = 0; i < amount; i++) {
            Assertions.assertEquals(i, rd.dequeue());
        }
        Assertions.assertEquals(0, rd.size());
        Assertions.assertTrue(rd.isEmpty());
    }
}
