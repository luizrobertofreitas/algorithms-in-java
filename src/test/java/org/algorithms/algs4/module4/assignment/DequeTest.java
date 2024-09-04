package org.algorithms.algs4.module4.assignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.NoSuchElementException;

class DequeTest {
    @Test
    void emptyOnCreateTest() {
        Deque<String> d = new Deque<>();
        Assertions.assertTrue(d.isEmpty());
    }

    @Test
    void enqueueFirstItemOnDequeTest() {
        Deque<String> d = new Deque<>();
        d.addFirst("John");
        Assertions.assertFalse(d.isEmpty());
        Assertions.assertEquals("John", d.removeFirst());
    }

    @Test
    void enqueueLastItemOnDequeTest() {
        Deque<String> d = new Deque<>();
        d.addLast("John");
        Assertions.assertFalse(d.isEmpty());
        Assertions.assertEquals("John", d.removeLast());
    }

    @Test
    void enqueueOneFirstItemAndRemoveLastDequeTest() {
        Deque<String> d = new Deque<>();
        d.addFirst("John");
        Assertions.assertFalse(d.isEmpty());
        Assertions.assertEquals("John", d.removeLast());
    }

    @Test
    void enqueueOneLastItemAndRemoveFirstDequeTest() {
        Deque<String> d = new Deque<>();
        d.addLast("John");
        Assertions.assertFalse(d.isEmpty());
        Assertions.assertEquals("John", d.removeFirst());
    }

    @Test
    void removeOnEmptyDequeTest() {
        Deque<String> d = new Deque<>();
        Assertions.assertThrows(NoSuchElementException.class, d::removeFirst);
        Assertions.assertThrows(NoSuchElementException.class, d::removeLast);
    }

    @Test
    void enqueueNullOnDequeTest() {
        Deque<String> d = new Deque<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> d.addFirst(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> d.addLast(null));
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
    void enqueueMassiveFirstItemsAndRemoveLast(int amount) {
        Deque<String> d = new Deque<>();
        for (int i = 0 ; i < amount ; i++) {
            d.addFirst("Item " + i);
        }
        Assertions.assertEquals(amount, d.size());
        for (int i = 0 ; i < amount ; i++) {
            Assertions.assertEquals("Item " + i, d.removeLast());
        }
        Assertions.assertTrue(d.isEmpty());
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
    void enqueueMassiveFirstItemsAndRemoveFirst(int amount) {
        Deque<String> d = new Deque<>();
        for (int i = 0 ; i < amount ; i++) {
            d.addFirst("Item " + i);
        }
        Assertions.assertEquals(amount, d.size());
        for (int i = amount - 1 ; i >= 0 ; i--) {
            Assertions.assertEquals("Item " + i, d.removeFirst());
        }
        Assertions.assertTrue(d.isEmpty());
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
    void enqueueMassiveLastItemsAndRemoveFirst(int amount) {
        Deque<String> d = new Deque<>();
        for (int i = 0 ; i < amount ; i++) {
            d.addLast("Item " + i);
        }
        Assertions.assertEquals(amount, d.size());
        for (int i = 0 ; i < amount ; i++) {
            Assertions.assertEquals("Item " + i, d.removeFirst());
        }
        Assertions.assertTrue(d.isEmpty());
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
    void enqueueMassiveLastItemsAndRemoveLast(int amount) {
        Deque<String> d = new Deque<>();
        for (int i = 0 ; i < amount ; i++) {
            d.addLast("Item " + i);
        }
        Assertions.assertEquals(amount, d.size());
        for (int i = amount - 1 ; i >= 0 ; i--) {
            Assertions.assertEquals("Item " + i, d.removeLast());
        }
        Assertions.assertTrue(d.isEmpty());
    }
}
