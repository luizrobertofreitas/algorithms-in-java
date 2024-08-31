package org.algorithms.other;

import org.algorithms.algs4.module4.QueueWithTwoStacks;
import org.algorithms.algs4.module4.DynamicSizedStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AlgsQueuesAndStacksTest {

    @Test
    void queueWithTwoStacksTest() {
        final QueueWithTwoStacks<Integer> qwts = new QueueWithTwoStacks<>();
        qwts.enqueue(1);
        qwts.enqueue(2);
        qwts.enqueue(3);
        qwts.enqueue(4);

        Assertions.assertEquals(1, qwts.dequeue());
        Assertions.assertEquals(2, qwts.dequeue());
        Assertions.assertEquals(3, qwts.dequeue());

        qwts.enqueue(5);

        Assertions.assertEquals(4, qwts.dequeue());
        Assertions.assertEquals(5, qwts.dequeue());
    }

    @Test
    void stackWithMaximumOperationsTest() {
        final DynamicSizedStack<Integer> swmo = new DynamicSizedStack<>();
        swmo.push(1);
        swmo.push(2);
        swmo.push(3);
        swmo.push(4);
        swmo.push(5);
        swmo.push(6);
        swmo.push(7);

        Assertions.assertEquals(7, swmo.peek());
        Assertions.assertEquals(7, swmo.pop());

        Assertions.assertEquals(6, swmo.pop());
        Assertions.assertEquals(5, swmo.pop());
        Assertions.assertEquals(4, swmo.pop());
        Assertions.assertEquals(3, swmo.pop());
        Assertions.assertEquals(2, swmo.pop());

        swmo.push(8);

        Assertions.assertEquals(8, swmo.pop());
        Assertions.assertEquals(1, swmo.pop());
    }
}
