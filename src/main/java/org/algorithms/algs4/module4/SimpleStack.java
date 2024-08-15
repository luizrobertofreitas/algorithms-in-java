package org.algorithms.algs4.module4;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SimpleStack<E> {
    private final List<E> arr;
    private int i = 0;

    public SimpleStack() {
        arr = new ArrayList<>();
    }

    public void push(E e) {
        if (i + 1 == arr.size()) throw new StackOverflowError();
        arr.set(i++, e);
    }

    public E pop() {
        if (i - 1 < 0) throw new EmptyStackException();
        return arr.get(--i);
    }

    public E peek() {
        if (i - 1 < 0) throw new EmptyStackException();
        return arr.get(i-1);
    }

    public boolean isEmpty() {
        return i < 0;
    }
}
