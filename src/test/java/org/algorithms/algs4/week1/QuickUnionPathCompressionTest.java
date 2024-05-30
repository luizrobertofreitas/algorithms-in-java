package org.algorithms.algs4.week1;

import org.junit.jupiter.api.Test;

class QuickUnionPathCompressionTest {

    @Test
    void test() {
        final int[] array = UnionFind.REFLEXIVE_ARRAY_GENERATOR.apply(30);
        final QuickUnionPathCompression qupc = new QuickUnionPathCompression(array);
        UnionFindHelperTest.test(qupc);
    }
}
