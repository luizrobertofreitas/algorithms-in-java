package org.algorithms.algs4.module4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DynamicSizedStackTest {

    @Test
    void testPeek() {
        final DynamicSizedStack<Integer> ss = new DynamicSizedStack<>();
        Assertions.assertTrue(ss.isEmpty());
        ss.push(4);
        Assertions.assertEquals(4, ss.peek());
        Assertions.assertFalse(ss.isEmpty());
    }

    @Test
    void testPushesAndPops() {
        final DynamicSizedStack<Integer> ss = new DynamicSizedStack<>();
        Assertions.assertTrue(ss.isEmpty());
        ss.push(1);
        ss.push(2);
        ss.push(3);
        Assertions.assertEquals(3, ss.pop());
        Assertions.assertEquals(2, ss.peek());
        Assertions.assertEquals(2, ss.peek());
        Assertions.assertEquals(2, ss.pop());
        Assertions.assertFalse(ss.isEmpty());
        Assertions.assertEquals(1, ss.pop());
        Assertions.assertTrue(ss.isEmpty());
        ss.push(4);
        Assertions.assertFalse(ss.isEmpty());
        Assertions.assertEquals(4, ss.pop());
        Assertions.assertTrue(ss.isEmpty());
    }

    @ParameterizedTest
    @CsvSource({
            "100",
            "1000",
            "10000",
            "100000",
            "1000000",
            "10000000",
            "100000000",
    })
    void massivePushesPeeksAndPops(Integer size) {
        final DynamicSizedStack<Integer> sdss = new DynamicSizedStack<>();
        Assertions.assertTrue(sdss.isEmpty());
        for (int i = 1; i < size; i++) {
            sdss.push(i);
            Assertions.assertEquals(i, sdss.peek());
        }
        Assertions.assertFalse(sdss.isEmpty());
        for (int i = size - 1; i > 0; i--) {
            Assertions.assertEquals(i, sdss.peek());
            Assertions.assertEquals(i, sdss.pop());
        }
        Assertions.assertTrue(sdss.isEmpty());
    }
}
