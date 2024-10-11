package org.algorithms.algs4.module4.assignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomizedQueueTest {

    @Test
    void emptyOnCreateTest() {
        final RandomizedQueue<String> rq = new RandomizedQueue<>();
        Assertions.assertTrue(rq.isEmpty());
    }

    @Test
    void enqueueFirstItemOnDequeTest() {
        final RandomizedQueue<String> rq = new RandomizedQueue<>();
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
        final RandomizedQueue<String> rq = new RandomizedQueue<>();
        for (int i = 0; i < amount; i++) {
            rq.enqueue(String.valueOf(i));
        }
        Assertions.assertEquals(amount, rq.size());
        for (int i = 0; i < amount; i++) {
            String current = rq.dequeue();
            int currentInt = Integer.parseInt(current);
            Assertions.assertNotEquals(String.valueOf(currentInt + 1), current);
        }
        Assertions.assertEquals(0, rq.size());
        Assertions.assertTrue(rq.isEmpty());
    }

    @ParameterizedTest
    @CsvSource({
        "100",
        "1000",
        "10000",
        "100000",
    })
    void enqueueMassiveItemsAndDuplicatedDequeueTest(int amount) {
        final RandomizedQueue<String> rq = new RandomizedQueue<>();
        for (int i = 0; i < amount; i++) {
            rq.enqueue(String.valueOf(i));
        }
        Assertions.assertEquals(amount, rq.size());
        StringBuilder dequeued = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            String current = rq.dequeue();
            int currentInt = Integer.parseInt(current);
            Assertions.assertNotEquals(String.valueOf(currentInt + 1), current);
            Assertions.assertFalse(dequeued.toString().contains("," + current + ","));
            dequeued.append(current).append(",");
        }
        Assertions.assertEquals(0, rq.size());
        Assertions.assertTrue(rq.isEmpty());
    }

    void t() {
        String[] a = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z"};
        for (int i = 0, j = 0; i < 100000; i++) {
            if (j == a.length) j = 0;
            System.out.print(a[j++] + i + " ");
        }
    }
}
