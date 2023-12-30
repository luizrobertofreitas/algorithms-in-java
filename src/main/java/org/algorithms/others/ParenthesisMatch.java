package org.algorithms.others;

import java.util.Stack;
import java.util.function.Function;

public final class ParenthesisMatch {
    public static Function<String, Boolean> SOLUTION = input -> {
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
