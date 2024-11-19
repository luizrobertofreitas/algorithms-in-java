package org.algorithms.algs4.module5.assignment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class UngradedAssignment {
    private UngradedAssignment() {}

    /*
        The implementation relies completely on set big O runtime. The code iterates the whole s1 and, for
        each item, checks whether s2 contains that integer. If so, keep that guy in the result set.

        Since contains on HashSet is constant time O(1), we only have the s1 performing an O(n) iteration.
        Ignoring the constant terms, this algorithm is O(n).

        Considerations:
                                  add      contains next     notes
            HashSet               O(1)     O(1)     O(h/n)   h is the table capacity
            LinkedHashSet         O(1)     O(1)     O(1)
            CopyOnWriteArraySet   O(n)     O(n)     O(1)
            EnumSet               O(1)     O(1)     O(1)
            TreeSet               O(log n) O(log n) O(log n)
            ConcurrentSkipListSet O(log n) O(log n) O(1)

    */
    public static final BinaryOperator<Set<Integer>> INTERSECT = (s1, s2) ->
        s1.stream().filter(s2::contains).collect(Collectors.toSet());

    public static final BiPredicate<int[], int[]> PERMUTATION = (a1, a2) -> {
        int a1S = IntStream.of(a1).sum();
        int a1M = IntStream.of(a1).reduce(1, (i, acc) -> i * acc);
        int a2S = IntStream.of(a2).sum();
        int a2M = IntStream.of(a2).reduce(1, (i, acc) -> i * acc);
        return a1S == a2S && a1M == a2M;
    };

    public static final Function<int[], int[]> DUTCH_NATIONAL_FLAG = (a1) -> {
        return a1;
    };
}
