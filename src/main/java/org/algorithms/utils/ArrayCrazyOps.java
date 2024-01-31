package org.algorithms.utils;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class ArrayCrazyOps {

    private ArrayCrazyOps() {}

    public static final Function<int[][], Integer[][]> CONVERT_PRIMITIVE_INT_MATRIX_TO_INTEGER_MATRIX = matrix ->
        Arrays.stream(matrix).map(arr -> IntStream.of(arr).boxed().toArray(Integer[]::new)).toArray(Integer[][]::new);

    public static final Function<Integer[][], Integer[]> INTEGER_ARRAY_CONCAT = arrays ->
            Stream.of(arrays).flatMap(Stream::of).toArray(Integer[]::new);

    public static final Function<String, Integer[]> CONVERT_STRING_TO_INTEGER_ARRAY = str ->
            Stream.of(str.split(",")).map(Integer::valueOf).toArray(Integer[]::new);

    public static final Function<Integer[][], Integer[]> FLATTEN_INTEGER_MATRIX = matrix ->
            Arrays.stream(matrix).flatMap(Stream::of).toArray(Integer[]::new);

    public static <A> A[] deleteFromArray(A[] array, Integer index) {
        final A[] newArray = Arrays.copyOf(array, array.length - 1);
        int newArrayIdx = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == index) continue;
            newArray[newArrayIdx] = array[i];
            newArrayIdx++;
        }
        return newArray;
    }

    public static Integer[] integerArrayConcat(Integer[] ... arrays) {
        return Stream.of(arrays).flatMap(Stream::of).toArray(Integer[]::new);
    }

    public static <A> void printMatrix(A[][] matrix) {
        Arrays.stream(matrix).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    public static void printIntMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}
