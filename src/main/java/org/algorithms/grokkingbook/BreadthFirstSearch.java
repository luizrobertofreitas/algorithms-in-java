package org.algorithms.grokkingbook;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.ToIntBiFunction;

public final class BreadthFirstSearch {

    private BreadthFirstSearch() {}

    public static final ToIntBiFunction<Person, String> SHORTEST_PATH_TO_NAME_STARTS_WITH = (first, nameStartsWith) -> {
        final Deque<Person> deque = new ArrayDeque<>(first.neighbors);
        int degree = 1;
        List<Person> nextPersonListDegree = new ArrayList<>();
        while (!deque.isEmpty() || !nextPersonListDegree.isEmpty()) {
            if (deque.isEmpty()) {
                deque.addAll(nextPersonListDegree);
                nextPersonListDegree = new ArrayList<>();
                degree++;
            } else {
                var p = deque.pop();
                if (p.name.startsWith(nameStartsWith)) break;
                else {
                    nextPersonListDegree.addAll(p.neighbors);
                }
            }
        }
        return degree;
    };

    public static final BiFunction<Person, String, Person> FIRST_THAT_STARTS_WITH = (first, nameStartsWith) -> {
        final Deque<Person> deque = new ArrayDeque<>(first.neighbors);
        while (!deque.isEmpty()) {
            var p = deque.pop();
            if (p.name.startsWith(nameStartsWith)) return p;
            else deque.addAll(p.neighbors);
        }
        return null;
    };

    public record Person(String name, List<Person> neighbors) {}
}
