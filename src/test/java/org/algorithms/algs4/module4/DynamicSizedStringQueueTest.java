package org.algorithms.algs4.module4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class DynamicSizedStringQueueTest {

    @Test
    void queueInitializationTest() {
        final DynamicSizedStringQueue q = new DynamicSizedStringQueue();
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
        final DynamicSizedStringQueue q = new DynamicSizedStringQueue();
        q.push("AA");
        Assertions.assertEquals(1, q.size());
        Assertions.assertEquals(0, q.headIndex());
        Assertions.assertEquals(1, q.tailIndex());
        for (int i = 1; i <= 10; i++) {
            q.push("BB" + i);
        }
        Assertions.assertEquals(11, q.size());
        Assertions.assertEquals("BB10", q.tail());
        Assertions.assertEquals("AA", q.peek());
    }

}
