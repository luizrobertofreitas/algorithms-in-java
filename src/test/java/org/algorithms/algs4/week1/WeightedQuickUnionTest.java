package org.algorithms.algs4.week1;

import org.junit.jupiter.api.Test;

class WeightedQuickUnionTest {

    @Test
    void test() {
        final int[] array = UnionFind.REFLEXIVE_ARRAY_GENERATOR.apply(30);
        final WeightedQuickUnion wqu = new WeightedQuickUnion(array);
        UnionFindHelperTest.test(wqu);
    }
}
