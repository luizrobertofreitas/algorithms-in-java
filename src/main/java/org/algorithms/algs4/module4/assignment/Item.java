package org.algorithms.algs4.module4.assignment;

public class Item<T> {
    T current;
    Item<T> previous, next;

    public Item() {}

    public Item(Item<T> previous, T current, Item<T> next) {
        this.previous = previous;
        this.current = current;
        this.next = next;
    }
}
