package org.algorithms.algs4.module4.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<T> implements Iterable<T> {

    private Item<T> first;
    private Item<T> last;
    private int size = 0;

    private final Random r = new Random();

    public boolean isEmpty() {
        return size < 1;
    }

    public int size() {
        return size;
    }

    public void enqueue(T t) {
        if (t == null) throw new IllegalArgumentException();
        if (first == null) {
            first = new Item<>(null, t, null);
            last = first;
        } else {
            last.next = new Item<>(last, t, null);
            last = last.next;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        final Item<T> s = randomItem();
        s.previous = s.next;
        size--;
        return s.current;
    }

    public T sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return randomItem().current;
    }

    private Item<T> randomItem() {
        int rand = r.nextInt(0, size());
        Item<T> f = first;
        for (int i = 0; i < rand; i++) {
            f = f.next;
        }
        return f;
    }

    @Override
    public Iterator<T> iterator() {
        final RandomizedQueue<T> i = new RandomizedQueue<>();
        final RandomizedQueue<T> aux = new RandomizedQueue<>();
        aux.first = first;
        aux.last = last;
        aux.size = size;
        while(!aux.isEmpty()) {
            i.enqueue(aux.dequeue());
        }

        return new RandomizedQueueIterator<>(i);
    }

    public static class RandomizedQueueIterator<T> implements Iterator<T> {

        private final RandomizedQueue<T> randomizedQueue;

        protected RandomizedQueueIterator(RandomizedQueue<T> randomizedQueue) {
            this.randomizedQueue = randomizedQueue;
        }

        @Override
        public boolean hasNext() {
            return !randomizedQueue.isEmpty();
        }

        @Override
        public T next() {
            if (randomizedQueue.isEmpty()) throw new NoSuchElementException();
            return randomizedQueue.dequeue();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
