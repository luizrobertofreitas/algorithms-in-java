package org.algorithms.algs4.module4.assignment;

import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

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
        }
        else {
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
        }
        else {
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

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item current = last.current;
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
    public Iterator<Item> iterator() {
        return new DequeIterator<>(this);
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

    private static class DequeIterator<Item> implements Iterator<Item> {
        private final Deque<Item> deque;

        public DequeIterator(Deque<Item> deque) {
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

    public static void main(String[] args) {
        final Deque<String> q = new Deque<>();
        while (!StdIn.isEmpty()) q.addFirst(StdIn.readString());
        while (!q.isEmpty()) System.out.println(q.removeFirst());
    }
}
