package org.algorithms.algs4.module4.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<T> implements Iterable<T> {

    private Item<T> first;
    private Item<T> last;
    private int size = 0;

    public boolean isEmpty() {
        return size < 1;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
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

    public void addLast(T item) {
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

    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        T current = first.current;
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

    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        T current = last.current;
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
    public Iterator<T> iterator() {
        return new DequeIterator<>(this);
    }

    public static class DequeIterator<T> implements Iterator<T> {
        private final Deque<T> deque;

        protected DequeIterator(Deque<T> deque) {
            this.deque = deque;
        }
        @Override
        public boolean hasNext() {
            return !deque.isEmpty();
        }

        @Override
        public T next() {
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
