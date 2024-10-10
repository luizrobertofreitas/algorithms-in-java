package org.algorithms.algs4.module4.assignment;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue implements Iterable<String> {
    private final Deque deque = new Deque();

    public int size() {
        return deque.size();
    }

    public void enqueue(String s) {
        if (StdRandom.uniformInt(0, 2) == 0) deque.addLast(s);
        else deque.addFirst(s);
    }

    public String dequeue() {
        return deque.removeFirst();
    }

    public String sample() {
        return deque.sample();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public Iterator<String> iterator() {
        return new RandomizedQueueIterator(deque);
    }

    public static class RandomizedQueueIterator implements Iterator<String> {

        private final Iterator<String> iterator;

        protected RandomizedQueueIterator(final Deque deque) {
            this.iterator = deque.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public String next() {
            return iterator.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
