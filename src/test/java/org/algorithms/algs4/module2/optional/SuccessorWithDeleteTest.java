package org.algorithms.algs4.module2.optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuccessorWithDeleteTest {

    @Test
    void test1() {
        final SuccessorWithDelete swd = new SuccessorWithDelete(new int[] {0,3,1,7,5,10,1,23,12,90,65,78,34,53,21});
        swd.remove(90);
        assertEquals(21, swd.findSmallestSuccessor(90));

        swd.remove(23);
        assertEquals(12, swd.findSmallestSuccessor(23));
    }
}
