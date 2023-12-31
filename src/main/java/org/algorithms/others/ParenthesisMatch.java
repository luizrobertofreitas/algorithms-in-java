package org.algorithms.others;

import java.util.Stack;
import java.util.function.Predicate;

public final class ParenthesisMatch {

    private ParenthesisMatch() {}

    public static final Predicate<String> SOLUTION = input -> {
        final Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else if (c == ')')
                stack.pop();
        }
        return stack.isEmpty();
    };
}
