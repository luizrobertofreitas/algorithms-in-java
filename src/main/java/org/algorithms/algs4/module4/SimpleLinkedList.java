package org.algorithms.algs4.module4;

public class SimpleLinkedList<E> {

    private SimpleLinkedNode<E> first;
    private SimpleLinkedNode<E> last;

    public void addFirst(E e) {
        if (first == null) {
            first = new SimpleLinkedNode<>(null, e, null);
            last = first;
        } else {
            final SimpleLinkedNode<E> next = first.copyWithPrevious(new SimpleLinkedNode<>(null, e, first));
            first = next.previous;
        }
    }

    public void addLast(E e) {
        if (first == null) {
            first = new SimpleLinkedNode<>(null, e, null);
            last = first;
        } else {
            final SimpleLinkedNode<E> previous = last.copyWithNext(new SimpleLinkedNode<>(last, e, null));
            last = previous.next;
        }
    }

    public E first() {
        return first.e;
    }

    public E last() {
        return last.e;
    }

    public E removeLast() {
        validate();
        E e;
        if (first == last) {
            e = first.e;
            first = null;
            last = null;
        } else {
            e = last.e;
            last = last.previous;
        }
        return e;
    }

    public E removeFirst() {
        validate();
        E e;
        if (first == last) {
            e = first.e;
            first = null;
            last = null;
        } else {
            e = first.e;
            first = first.next;
        }
        return e;
    }

    public boolean isEmpty() {
        return first == null & first == last;
    }

    private void validate() {
        if (isEmpty()) throw new RuntimeException("List is already empty");
    }

    public record SimpleLinkedNode<E>(SimpleLinkedNode<E> previous, E e, SimpleLinkedNode<E> next) {
        public SimpleLinkedNode<E> copyWithPrevious(SimpleLinkedNode<E> previous) {
            return new SimpleLinkedNode<>(previous, e, next);
        }

        public SimpleLinkedNode<E> copyWithNext(SimpleLinkedNode<E> next) {
            return new SimpleLinkedNode<>(previous, e, next);
        }
    }
}
