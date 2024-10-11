package org.algorithms.algs4.module4;

import java.util.NoSuchElementException;

public class DynamicSizedStringQueue {
    private String[] arr = new String[1];
    private int head = 0;
    private int tail = 0;

    private int size = 0;

    public void enqueue(String s) {
        if (s == null) throw new IllegalArgumentException();
        arr[tail++] = s;
        size++;
        sizeUp();
    }

    public String dequeue() {
        if (size < 1) throw new NoSuchElementException();
        String r = arr[head];
        arr[head++] = null;
        size--;
        sizeDown();
        return r;
    }

    public String peek() {
        if (size < 1) throw new NoSuchElementException();
        return arr[head];
    }

    public int size() {
        return size;
    }

    public int arraySize() {
        return arr.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void sizeDown() {
       int headAndTailDistance = tail - head;

        if (size <= arr.length / 4) {
            String[] aux = new String[arr.length / 2];
            for (int i = 0; i < aux.length; aux[i] = arr[head + i], i++);
            arr = aux;
            head = 0;
            tail = head + headAndTailDistance;
        }
    }

    private void sizeUp() {
        if (size == arr.length) {
            String[] aux = new String[arr.length * 2];
            for (int i = 0; i < arr.length; aux[i] = arr[i], i++) ;
            arr = aux;
        }
    }
}
