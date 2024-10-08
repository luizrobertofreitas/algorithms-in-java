package org.algorithms.algs4.module4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class DynamicSizedIntegerQueueTest {

    @Test
    void queueInitializationTest() {
        final DynamicSizedIntegerQueue q = new DynamicSizedIntegerQueue();
        Assertions.assertEquals(0, q.size());
        Assertions.assertEquals(0, q.headIndex());
        Assertions.assertEquals(0, q.tailIndex());
        Assertions.assertThrows(NoSuchElementException.class, q::pop);
        Assertions.assertThrows(NoSuchElementException.class, q::peek);
        Assertions.assertThrows(NoSuchElementException.class, q::head);
        Assertions.assertThrows(NoSuchElementException.class, q::tail);
        Assertions.assertThrows(IllegalArgumentException.class, () -> q.push(null));
    }

    @Test
    void simplePushesPeeksAndPopsTest() {
        final DynamicSizedIntegerQueue q = new DynamicSizedIntegerQueue();
        q.push(11);
        Assertions.assertEquals(1, q.size());
        Assertions.assertEquals(0, q.headIndex());
        Assertions.assertEquals(1, q.tailIndex());
        for (int i = 1; i <= 10; i++) {
            q.push(11 + i);
        }
        Assertions.assertEquals(11, q.size());
        Assertions.assertEquals(21, q.tail());
        Assertions.assertEquals(21, q.peek());
    }

}
