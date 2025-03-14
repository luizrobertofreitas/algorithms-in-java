package org.algorithms.algs4.module6;

import java.util.function.*;

public final class MergeSorter implements Function<Integer[], Integer[]> {
    private MergeSorter() {}

    @Override
    public Integer[] apply(Integer[] arr) {
        return this.sort(arr);
    }

    private Integer[] sort(Integer[] arr) {
        return arr;
    }
}
