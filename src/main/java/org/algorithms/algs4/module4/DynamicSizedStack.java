package org.algorithms.algs4.module4;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class DynamicSizedStack<E> implements BasicStack<E> {
    private final List<E> arr;
    private int i = 0;

    public DynamicSizedStack() {
        arr = new ArrayList<>();
    }

    public void push(E e) {
        if (arr.size() == i) {
            arr.add(e);
            i++;
        } else {
            arr.set(i++, e);
        }
    }

    public E pop() {
        if (arr.isEmpty()) throw new EmptyStackException();
        else if (i - 1 < 0) return arr.get(i--);
        else return arr.get(--i);
    }

    public E peek() {
        if (arr.isEmpty()) throw new EmptyStackException();
        return arr.get(i-1);
    }

    public boolean isEmpty() {
        return i <= 0;
    }
}
