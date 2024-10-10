package org.algorithms.algs4.module4.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque implements Iterable<String> {

    private Item<String> first;
    private Item<String> last;
    private int size = 0;

    public boolean isEmpty() {
        return size < 1;
    }

    public int size() {
        return size;
    }

    public void addFirst(String item) {
        if (item == null) throw new IllegalArgumentException();
        if (first == null) {
            first = new Item<>(null, item, null);
            last = first;
        }
        else {
            first.previous = new Item<>(null, item, first);
            first = first.previous;
        }
        size++;
    }

    public void addLast(String item) {
        if (item == null) throw new IllegalArgumentException();
        if (first == null) {
            first = new Item<>(null, item, null);
            last = first;
        }
        else {
            last.next = new Item<>(last, item, null);
            last = last.next;
        }
        size++;
    }

    public String removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        String current = first.current;
        if (first.next == null) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        size--;
        return current;
    }

    public String removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        String current = last.current;
        if (last.previous == null) {
            last = null;
            first = null;
        } else {
            last = last.previous;
            last.next = null;
        }
        size--;
        return current;
    }

    @Override
    public Iterator<String> iterator() {
        return new DequeIterator(this);
    }

    protected String sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.current;
    }

    public static class DequeIterator implements Iterator<String> {
        private final Deque deque;

        protected DequeIterator(Deque deque) {
            this.deque = deque;
        }
        @Override
        public boolean hasNext() {
            return !deque.isEmpty();
        }

        @Override
        public String next() {
            if (deque.isEmpty()) {
                throw new NoSuchElementException();
            }
            return deque.removeFirst();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
