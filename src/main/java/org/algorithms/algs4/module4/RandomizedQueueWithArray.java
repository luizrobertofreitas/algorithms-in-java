package org.algorithms.algs4.module4;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueueWithArray implements Iterable<String> {
    private String[] arr = new String[1];

    private int size = 0;

    public int size() {
        return size;
    }

    public void enqueue(String s) {
        if (s == null) throw new IllegalArgumentException();
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == null) {
                arr[i] = s;
                break;
            }
        size++;
        sizeUp();
    }

    public String dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int i = getRandomIndex();
        String s = arr[i];
        while (s == null) {
            i = getRandomIndex();
            s = arr[i];
        }
        arr[i] = null;
        size--;
        sizeDown();
        return s;
    }

    public String sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return arr[getRandomIndex()];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<String> iterator() {
        final RandomizedQueueWithArray rqi = new RandomizedQueueWithArray();
        rqi.arr = new String[arr.length];
        for (int i = 0 ; i < arr.length ; rqi.arr[i] = arr[i], i++);
        return new RandomizedQueueIterator(rqi);
    }

    private int getRandomIndex() {
        return StdRandom.uniformInt(arr.length);
    }

    private void sizeDown() {
        if (size <= arr.length / 4) {
            resizeArr(arr.length / 2);
        }
    }

    private void sizeUp() {
        if (size == arr.length) {
            resizeArr(arr.length * 2);
        }
    }

    private void resizeArr(int size) {
        String[] aux = new String[size];
        for (int i = 0, j = 0; i < arr.length; i++)
            if (arr[i] != null) aux[j++] = arr[i];
        arr = aux;
    }

    public static class RandomizedQueueIterator implements Iterator<String> {

        private final RandomizedQueueWithArray randomizedQueueWithArray;

        protected RandomizedQueueIterator(RandomizedQueueWithArray randomizedQueueWithArray) {
            this.randomizedQueueWithArray = randomizedQueueWithArray;
        }

        @Override
        public boolean hasNext() {
            return !randomizedQueueWithArray.isEmpty();
        }

        @Override
        public String next() {
            if (randomizedQueueWithArray.isEmpty()) throw new NoSuchElementException();
            return randomizedQueueWithArray.dequeue();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
