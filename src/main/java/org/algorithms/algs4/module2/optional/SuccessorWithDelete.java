package org.algorithms.algs4.module2.optional;

import java.util.Arrays;

public class SuccessorWithDelete {
    private final int[] array;

    public SuccessorWithDelete(int[] array) {
        this.array = array;
    }

    public void remove(int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                array[i] *= 10000;
                return;
            }
        }
    }

    public int findSmallestSuccessor(int number) {
        int nextIdx = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number * 10000) {
                nextIdx = i+1;
                break;
            }
        }
        if (nextIdx == -1) return nextIdx;
        int smallest = array[nextIdx];
        for (int i = nextIdx; i < array.length; i++) {
            if (array[i] < smallest) smallest = array[i];
        }
        return smallest;
    }


    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
