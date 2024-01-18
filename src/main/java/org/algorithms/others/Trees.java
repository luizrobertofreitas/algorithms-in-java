package org.algorithms.others;

import org.algorithms.utils.ArrayCrazyOps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public final class Trees {
    private Trees() {}

    public static final Function<Integer[], Tree> GENERATE_TREE_FROM_ORDERED_ARRAY = arr -> {
        if (arr.length == 0) return new Tree(null);
        else if (arr.length == 1) return new Tree(arr[0]);
        else if (arr.length == 2) return new Tree(arr[1], new Tree(arr[0]), null);
        else if (arr.length == 3) return new Tree(arr[1], new Tree(arr[0]), new Tree(arr[2]));
        int mid = arr.length / 2;
        Integer[] left = Arrays.copyOfRange(arr, 0, mid);
        Integer[] right = Arrays.copyOfRange(arr, mid + 1, arr.length);
        return new Tree(
                arr[mid],
                Trees.GENERATE_TREE_FROM_ORDERED_ARRAY.apply(left),
                Trees.GENERATE_TREE_FROM_ORDERED_ARRAY.apply(right)
        );
    };

    public record Tree(Integer value, Tree left, Tree right) {
        Tree(Integer value) {
            this(value, null, null);
        }

        public Integer[] asArray() {
            Integer[] leftArray = left != null ? left.asArray() : new Integer[0];
            Integer[] rightArray = right != null ? right.asArray() : new Integer[0];
            return ArrayCrazyOps.integerFlatten(
                    Stream.of(
                        leftArray,
                        new Integer[]{value},
                        rightArray
                    ).toArray(Integer[][]::new)
            );
        }

        public void print() {
            if (left != null) left.print();
            System.out.print(value + " ");
            System.out.println();
            if (right != null) right.print();
        }
    }
}
