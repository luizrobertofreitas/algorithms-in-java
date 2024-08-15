package org.algorithms.algs4.module4;

public class QueueWithTwoStacks<E> {
    private final SimpleStack<E> s1 = new SimpleStack<>();
    private final SimpleStack<E> s2 = new SimpleStack<>();

    public void enqueue(E e) {
        while (!s1.isEmpty()) s2.push(s1.pop());
        s1.push(e);
        while (!s2.isEmpty()) s1.push(s2.pop());
    }

    public E dequeue() {
        if (s1.isEmpty()) throw new RuntimeException("No elements remaining");
        return s1.pop();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }
}
