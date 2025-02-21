package org.algorithms.other;

import org.algorithms.others.LRUCache;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LRUCacheTest {
    @Test
    void test() {
        final LRUCache lru = new LRUCache(5);
        lru.put(1, 11);
        lru.put(2, 22);
        lru.put(3, 33);
        lru.put(4, 44);
        lru.put(5, 55);

        for (int i = 0; i < 1; lru.get(1), i++);
        for (int i = 0; i < 2; lru.get(2), i++);
        for (int i = 0; i < 3; lru.get(3), i++);
        for (int i = 0; i < 4; lru.get(4), i++);
        for (int i = 0; i < 5; lru.get(5), i++);

        lru.put(6, 66);

        Assertions.assertEquals(-1, lru.get(1));
        Assertions.assertEquals(66, lru.get(6));
        Assertions.assertEquals(55, lru.get(5));
        Assertions.assertEquals(44, lru.get(4));
        Assertions.assertEquals(33, lru.get(3));
        Assertions.assertEquals(22, lru.get(2));
        Assertions.assertTrue(lru.isFull());
    }
}
