package org.algorithms.codesignal;

import java.util.Stack;
import java.util.function.UnaryOperator;

/*
    Write a function that reverses characters in (possibly nested) parentheses in the input string.

    Input strings will always be well-formed with matching ()s.

    Example

        For inputString = "(bar)", the output should be
        solution(inputString) = "rab";

        For inputString = "foo(bar)baz", the output should be
        solution(inputString) = "foorabbaz";

        For inputString = "foo(bar)baz(blim)", the output should be
        solution(inputString) = "foorabbazmilb";

        For inputString = "foo(bar(baz))blim", the output should be
        solution(inputString) = "foobazrabblim".
        Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and then "foobazrabblim"
*/
public final class ReverseInParenthesis {

    private ReverseInParenthesis() {}

    public static final UnaryOperator<String> SOLUTION = input -> {
        if (input == null) return "";
        if (!input.contains("(")) return input;
        while (input.contains("(")) {
            Stack<Character> stack = new Stack<>();
            String wordAux = "";
            boolean parenthesisOpen = false;
            for (char c : input.toCharArray()) {
                if (c == '(') {
                    parenthesisOpen = true;
                    wordAux = "(";
                    stack = new Stack<>();
                } else if (c == ')') {
                    wordAux += c;
                    String reversed = "";
                    while (!stack.isEmpty()) {
                        reversed += stack.pop();
                    }
                    input = input.replace(wordAux, reversed);
                    break;
                } else if (parenthesisOpen) {
                    stack.push(c);
                    wordAux += c;
                }
            }
        }
        return input;
    };
}
