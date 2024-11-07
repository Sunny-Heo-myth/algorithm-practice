package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Stack;

public class BJ3986 {
    public String solve(String input) {
        return String.valueOf(input.lines().skip(1)
                .filter(s -> {
                    Stack<Character> stack = new Stack<>();
                    for (char c : s.toCharArray()) {
                        if (!stack.isEmpty() && stack.peek() == c) stack.pop();
                        else stack.push(c);
                    }
                    return stack.isEmpty();
                })
                .count());
    }
}
