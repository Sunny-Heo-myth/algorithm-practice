package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Stack;

public class BJ10799 {

    private static final char LEFT = '(';

    public String solve(String input) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        boolean isPreviousLeft = true;
        for (char ch : input.toCharArray()) {
            if (ch == LEFT) {
                stack.push(LEFT);
                isPreviousLeft = true;
            } else {
                stack.pop();
                count += isPreviousLeft ? stack.size() : 1;
                isPreviousLeft = false;
            }
        }
        return String.valueOf(count);
    }
}
