package org.algorithms.algs4.module4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleLinkedListTest {

    @Test
    void test1() {
        SimpleLinkedList<String> sll = new SimpleLinkedList<>();
        sll.addFirst("Noa");
        sll.addLast("Mary");
        sll.addLast("Peter");
        sll.addFirst("Bruce");
        sll.addLast("Clark");
        sll.addLast("Barry");
        sll.addFirst("Diana");
        sll.addLast("Robin");
        sll.addLast("Tony");
        sll.addFirst("Steve");
        sll.addFirst("Stephen");
        Assertions.assertEquals("Stephen", sll.first());
        Assertions.assertEquals("Tony", sll.last());
        Assertions.assertEquals("Stephen", sll.removeFirst());
        Assertions.assertEquals("Tony", sll.removeLast());
        Assertions.assertEquals("Steve", sll.removeFirst());
        Assertions.assertEquals("Robin", sll.removeLast());
        Assertions.assertEquals("Diana", sll.removeFirst());
        Assertions.assertEquals("Barry", sll.removeLast());
        Assertions.assertEquals("Clark", sll.removeLast());
        Assertions.assertEquals("Bruce", sll.removeFirst());
        Assertions.assertEquals("Peter", sll.removeLast());
        Assertions.assertEquals("Mary", sll.removeLast());
        Assertions.assertEquals("Noa", sll.removeFirst());
        Assertions.assertTrue(sll.isEmpty());
        Assertions.assertThrows(RuntimeException.class, sll::removeFirst);
        Assertions.assertThrows(RuntimeException.class, sll::removeLast);
    }
}
