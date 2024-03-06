package org.alan.algorithm.practice.baekjoon.silver.five;

import java.util.Stack;

public class BJ1094 {
    public String solve(String input) {
        int i = Integer.parseInt(input);
        Stack<Integer> stack = new Stack<>();
        stack.push(64);

        while (stack.stream().reduce(Integer::sum).orElse(0) != i) {
            int popped = stack.pop();
            int half = popped / 2;
            if (half + stack.stream().reduce(Integer::sum).orElse(0) < i) {
                stack.push(half);
            }
            stack.push(half);
        }

        return String.valueOf(stack.size());
    }
}
