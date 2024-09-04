package org.algorithms.algs4.module4.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<T> implements Iterable<T> {

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    public void enqueue(T t) {
        if (t == null) throw new IllegalArgumentException();
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        return null;
    }

    public T sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomizedQueueIterator<>(this);
    }

    public static class RandomizedQueueIterator<T> implements Iterator<T> {

        private final RandomizedQueue<T> randomizedQueue;

        protected RandomizedQueueIterator(RandomizedQueue<T> randomizedQueue) {
            this.randomizedQueue = randomizedQueue;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            if (randomizedQueue.isEmpty()) throw new NoSuchElementException();
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
