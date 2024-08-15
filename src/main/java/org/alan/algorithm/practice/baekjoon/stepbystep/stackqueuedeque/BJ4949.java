package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedeque;

import java.util.Stack;

public class BJ4949 {

    private static final char LEFT_PARENTHESES = '(';
    private static final char RIGHT_PARENTHESES = ')';
    private static final char LEFT_SQUARE_BRACKETS = '[';
    private static final char RIGHT_SQUARE_BRACKETS = ']';

    public String solve2(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {

            if (c == '.') {
                break;
            }

            if (c == LEFT_PARENTHESES || c == LEFT_SQUARE_BRACKETS) {
                stack.push(c);
                continue;
            }

            if (c == RIGHT_PARENTHESES) {
                if (!stack.isEmpty() && stack.peek() == LEFT_PARENTHESES) {
                    stack.pop();
                    continue;
                } else {
                    return "no";
                }
            }

            if (c == RIGHT_SQUARE_BRACKETS) {
                if (!stack.isEmpty() && stack.peek().equals(LEFT_SQUARE_BRACKETS)) {
                    stack.pop();
                } else {
                    return "no";
                }
            }
        }

        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
