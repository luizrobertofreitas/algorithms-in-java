package org.algorithms.algs4.module4;

import java.util.NoSuchElementException;

public class DynamicSizedIntegerQueue {

    private static final int SIZE_DOWN_THRESHOLD = 25;
    private static final int REBALANCE_THRESHOLD = 50;
    private Integer[] arr = new Integer[1];
    private int head = 0;
    private int tail = 0;

    private int size = 0;

    public void push(Integer i) {
        if (i == null) throw new IllegalArgumentException();
        arr[tail++] = i;
        size++;
        sizeUp();
    }

    public Integer pop() {
        if (size < 1) throw new NoSuchElementException();
        Integer r = arr[head];
        arr[head--] = null;
        size--;
        sizeDown();
        return r;
    }

    public Integer peek() {
        if (size < 1) throw new NoSuchElementException();
        return arr[head];
    }

    public int size() {
        return size;
    }

    public int headIndex() {
        return head;
    }

    public int tailIndex() {
        return tail;
    }

    public Integer head() {
        if (size == 0) throw new NoSuchElementException();
        return arr[head];
    }

    public Integer tail() {
        if (size == 0) throw new NoSuchElementException();
        return arr[tail];
    }

    private void sizeDown() {
        /*
         TODO make a calculation about the remaining items in queue, by formula: f(head, tail) = (tail - head) * 100
         For:
           f(head, tail) <= 25%, then shrink to half (arr.length / 2)
           also bring all items from head -> tail to the start of new array... update head and tail
       */

        if (size <= arr.length / 4) {
            Integer[] aux = new Integer[arr.length - arr.length / 2];
            for (int i = 0; i < aux.length; aux[i] = arr[i], i++);
            arr = aux;
        }
    }

    private void sizeUp() {
        /*
         TODO make a calculation about the items in queue, by formula: f(head, tail) = (tail - head) * 100
         For:
           f(head, tail) <= 75%, then bring all items to the start of this array... update head and tail
       */
        if (size == arr.length) {
            Integer[] aux = new Integer[arr.length * 2];
            for (int i = 0; i < arr.length; aux[i] = arr[i], i++) ;
            arr = aux;
        }
    }
}
