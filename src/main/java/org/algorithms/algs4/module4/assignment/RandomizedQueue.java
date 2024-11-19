package org.algorithms.algs4.module4.assignment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Performance requirements.
 * Your randomized queue implementation must support each randomized queue operation (besides creating an iterator) in constant amortized time.
 * That is, any intermixed sequence of m randomized queue operations (starting from an empty queue) must take at most cm steps in the worst case,
 *      for some constant c. A randomized queue containing n items must use at most 48n + 192 bytes of memory.
 * Additionally, your iterator implementation must support operations next() and hasNext() in constant worst-case time;
 *      and construction in linear time; you may (and will need to) use a linear amount of extra memory per iterator.
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private final DequeRandom<Item> deque = new DequeRandom<>();

    public int size() {
        return deque.size();
    }

    public void enqueue(Item item) {
        if (StdRandom.uniformInt(0, 2) == 0) deque.addLast(item);
        else deque.addFirst(item);
    }

    public Item dequeue() {
        return deque.removeFirst();
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return deque.sample();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator<>(deque);
    }

    private static class DequeRandom<Item> implements Iterable<Item> {

        private Node<Item> first;
        private Node<Item> last;
        private int size = 0;

        public boolean isEmpty() {
            return size < 1;
        }

        public int size() {
            return size;
        }

        public void addFirst(Item item) {
            if (item == null) throw new IllegalArgumentException();
            if (first == null) {
                first = new Node<>(null, item, null);
                last = first;
            } else {
                first.previous = new Node<>(null, item, first);
                first = first.previous;
            }
            size++;
        }

        public void addLast(Item item) {
            if (item == null) throw new IllegalArgumentException();
            if (first == null) {
                first = new Node<>(null, item, null);
                last = first;
            } else {
                last.next = new Node<>(last, item, null);
                last = last.next;
            }
            size++;
        }

        public Item removeFirst() {
            if (isEmpty()) throw new NoSuchElementException();
            Item current = first.current;
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

        public Item sample() {
            if (isEmpty()) throw new NoSuchElementException();
            return first.current;
        }

        @Override
        public Iterator<Item> iterator() {
            return new DequeRandomIterator<>(this);
        }

        private static class Node<Item> {
            Item current;
            Node<Item> previous;
            Node<Item> next;

            public Node(Node<Item> previous, Item current, Node<Item> next) {
                this.previous = previous;
                this.current = current;
                this.next = next;
            }
        }

        public static class DequeRandomIterator<Item> implements Iterator<Item> {
            private final DequeRandom<Item> deque;

            public DequeRandomIterator(DequeRandom<Item> deque) {
                this.deque = deque;
            }
            @Override
            public boolean hasNext() {
                return !deque.isEmpty();
            }

            @Override
            public Item next() {
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

    private static class RandomizedQueueIterator<Item> implements Iterator<Item> {

        private final Iterator<Item> iterator;

        public RandomizedQueueIterator(final DequeRandom<Item> deque) {
            this.iterator = deque.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Item next() {
            return iterator.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        final RandomizedQueue<String> q = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) q.enqueue(StdIn.readString());
        while (!q.isEmpty()) System.out.println(q.dequeue());
    }
}
