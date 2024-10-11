package org.algorithms.algs4.module5;

import java.util.function.Consumer;

public final class Sorters {

    private Sorters() {}

    public static final Consumer<Comparable[]> SELECTION_SORT = a -> {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                if (SortersUtils.less(a[j], a[min])) min = j;
            SortersUtils.exchange(a, i, min);
        }
    };
}
