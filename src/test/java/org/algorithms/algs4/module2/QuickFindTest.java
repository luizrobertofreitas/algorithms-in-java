package org.algorithms.algs4.module2;

import org.junit.jupiter.api.Test;

class QuickFindTest {

    @Test
    void test() {
        final int[] array = UnionFind.REFLEXIVE_ARRAY_GENERATOR.apply(30);
        final QuickFind qf = new QuickFind(array);
        UnionFindHelperTest.test(qf);

    }
}
