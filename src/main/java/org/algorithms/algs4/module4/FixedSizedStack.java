package org.algorithms.algs4.module4;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class FixedSizedStack<E> implements BasicStack<E> {

    private final E[] arr;
    private int i = 0;

    public FixedSizedStack(Class<E> clazz, int size) {
        arr = (E[]) Array.newInstance(clazz, size);
    }

    @Override
    public void push(E e) {
        if (i == arr.length) throw new RuntimeException(String.format("Fixed sized stack of size %d is full", arr.length));
        else arr[i++] = e;
    }

    @Override
    public E pop() {
        if (i - 1 < 0) throw new EmptyStackException();
        else return arr[--i];
    }

    @Override
    public E peek() {
        if (i - 1 < 0) throw new EmptyStackException();
        else return arr[i-1];
    }

    @Override
    public boolean isEmpty() {
        return i <= 0;
    }
}
