package org.algorithms.algs4.module4.assignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Iterator;
import java.util.NoSuchElementException;

class DequeIteratorTest {

    @Test
    void unsupportedIteratorRemoveOperationTest() {
        final Deque<String> d = new Deque<>();
        final Iterator<String> di = d.iterator();
        Assertions.assertThrows(UnsupportedOperationException.class, di::remove);
    }

    @Test
    void emptyIteratorTest() {
        final Deque<String> d = new Deque<>();
        final Iterator<String> di = d.iterator();
        Assertions.assertFalse(di.hasNext());
        Assertions.assertThrows(NoSuchElementException.class, di::next);
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
    void massiveIteratorItemsOnEnqueueLastTest(int amount) {
        final Deque<String> d = new Deque<>();
        for (int i = 0; i < amount; i++) {
            d.addLast(String.valueOf(i));
        }
        final Iterator<String> di = d.iterator();
        int count = 0;
        while(di.hasNext()) {
            Assertions.assertEquals(String.valueOf(count++), di.next());
        }
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
    void massiveIteratorItemsOnEnqueueFirstTest(int amount) {
        final Deque<String> d = new Deque<>();
        for (int i = 0; i < amount; i++) {
            d.addFirst(String.valueOf(i));
        }
        final Iterator<String> di = d.iterator();
        int count = amount - 1;
        while(di.hasNext()) {
            Assertions.assertEquals(String.valueOf(count--), di.next());
        }
    }
}
