package org.algorithms.algs4.module4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class DynamicSizedStringQueueTest {

    @Test
    void queueInitializationTest() {
        final DynamicSizedStringQueue q = new DynamicSizedStringQueue();
        Assertions.assertEquals(0, q.size());
        Assertions.assertTrue(q.isEmpty());
        Assertions.assertThrows(NoSuchElementException.class, q::dequeue);
        Assertions.assertThrows(NoSuchElementException.class, q::peek);
        Assertions.assertThrows(IllegalArgumentException.class, () -> q.enqueue(null));
    }

    @Test
    void simplePushesPeeksAndPopsTest() {
        final DynamicSizedStringQueue q = new DynamicSizedStringQueue();
        q.enqueue("AA");
        Assertions.assertEquals(1, q.size());
        for (int i = 1; i <= 10; i++) {
            q.enqueue("BB" + i);
        }
        Assertions.assertEquals(11, q.size());
        Assertions.assertEquals("AA", q.peek());
        Assertions.assertEquals("AA", q.dequeue());
        int count = 1;
        while(!q.isEmpty()) {
            Assertions.assertEquals("BB" + count++, q.dequeue());
        }

        Assertions.assertEquals(0, q.size());
        Assertions.assertTrue(q.arraySize() < 2);
    }
}
