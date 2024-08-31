package org.algorithms.algs4.module4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FixedSizedStackTest {
    @Test
    void testPeek() {
        final FixedSizedStack<Integer> dss = new FixedSizedStack<>(Integer.class, 10);
        Assertions.assertTrue(dss.isEmpty());
        dss.push(4);
        Assertions.assertEquals(4, dss.peek());
        Assertions.assertFalse(dss.isEmpty());
    }

    @Test
    void testPushesAndPops() {
        final FixedSizedStack<Integer> dss = new FixedSizedStack<>(Integer.class, 10);
        Assertions.assertTrue(dss.isEmpty());
        dss.push(1);
        dss.push(2);
        dss.push(3);
        Assertions.assertEquals(3, dss.pop());
        Assertions.assertEquals(2, dss.peek());
        Assertions.assertEquals(2, dss.peek());
        Assertions.assertEquals(2, dss.pop());
        Assertions.assertFalse(dss.isEmpty());
        Assertions.assertEquals(1, dss.pop());
        Assertions.assertTrue(dss.isEmpty());
        dss.push(4);
        Assertions.assertFalse(dss.isEmpty());
        Assertions.assertEquals(4, dss.pop());
        Assertions.assertTrue(dss.isEmpty());
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
        final FixedSizedStack<Integer> dss = new FixedSizedStack<>(Integer.class, size);
        Assertions.assertTrue(dss.isEmpty());
        for (int i = 1; i < size; i++) {
            dss.push(i);
            Assertions.assertEquals(i, dss.peek());
        }
        Assertions.assertFalse(dss.isEmpty());
        for (int i = size - 1; i > 0; i--) {
            Assertions.assertEquals(i, dss.peek());
            Assertions.assertEquals(i, dss.pop());
        }
        Assertions.assertTrue(dss.isEmpty());
    }
}
