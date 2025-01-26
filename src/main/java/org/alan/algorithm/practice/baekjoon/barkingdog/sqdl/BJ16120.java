package org.alan.algorithm.practice.baekjoon.barkingdog.sqdl;

import java.util.Stack;

public class BJ16120 {
    private static final char P = 'P', A = 'A';
    public String solve(String input) {
        Stack<Character> stack = new Stack<>();
        for (char fourth : input.toCharArray()) {
            if (fourth == A || stack.isEmpty()) {
                stack.push(fourth);
                continue;
            }

            char third = stack.pop();
            if (stack.isEmpty()) {
                stack.push(third);
                stack.push(fourth);
                continue;
            }

            char second = stack.pop();
            if (stack.isEmpty()) {
                stack.push(second);
                stack.push(third);
                stack.push(fourth);
                continue;
            }

            char first = stack.pop();
            if (first != P || second != P || third != A || fourth != P) {
                stack.push(first);
                stack.push(second);
                stack.push(third);
            }

            stack.push(fourth);
        }
        return stack.size() == 1 && stack.peek() == P ? "PPAP" : "NP";
    }
}
