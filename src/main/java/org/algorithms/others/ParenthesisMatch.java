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

    public static final Predicate<String> SOLUTION_2 = input -> {
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                else {
                    char popped = stack.pop();
                    if (
                        (c == ')' && popped != '(') ||
                        (c == ']' && popped != '[') ||
                        (c == '}' && popped != '{')
                    ) return false;
                }
            }
        }
        return stack.isEmpty();
    };
}
