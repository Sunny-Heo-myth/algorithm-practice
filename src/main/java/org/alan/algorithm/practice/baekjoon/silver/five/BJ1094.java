package org.alan.algorithm.practice.baekjoon.silver.five;

import java.util.Stack;

public class BJ1094 {
    public String solve(String input) {
        int i = Integer.parseInt(input);
        Stack<Integer> stack = new Stack<>();
        stack.push(64);

        while (true) {
            int sum = stack.stream().reduce(Integer::sum).orElse(-1);
            if (sum == i) {
                return String.valueOf(stack.size());
            }

            int half = stack.pop() / 2;
            int nextSum = sum - half;
            if (nextSum < i) {
                stack.push(half);
            }
            stack.push(half);
        }
    }
}
