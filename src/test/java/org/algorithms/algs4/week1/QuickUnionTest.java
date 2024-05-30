package org.algorithms.algs4.week1;

import org.junit.jupiter.api.Test;

class QuickUnionTest {

    @Test
    void test() {
        final int[] array = UnionFind.REFLEXIVE_ARRAY_GENERATOR.apply(30);
        final QuickUnion qu = new QuickUnion(array);
        UnionFindHelperTest.test(qu);
    }
}
