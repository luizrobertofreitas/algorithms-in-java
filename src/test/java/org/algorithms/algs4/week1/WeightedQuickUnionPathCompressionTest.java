package org.algorithms.algs4.week1;

import org.junit.jupiter.api.Test;

class WeightedQuickUnionPathCompressionTest {

    @Test
    void test() {
        final int[] array = UnionFind.REFLEXIVE_ARRAY_GENERATOR.apply(30);
        final WeightedQuickUnionPathCompression wqupc = new WeightedQuickUnionPathCompression(array);
        UnionFindHelperTest.test(wqupc);
    }
}
