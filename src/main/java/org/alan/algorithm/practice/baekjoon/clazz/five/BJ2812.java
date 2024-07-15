package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Stack;
import java.util.stream.Collectors;

public class BJ2812 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int k = Integer.parseInt(lines[0].split(" ")[1]);

        int count = k;
        Stack<Character> stack = new Stack<>();
        for (char ch : lines[1].toCharArray()) {
            while (!stack.isEmpty() && count > 0 && stack.peek() < ch) {
                stack.pop();
                count--;
            }
            stack.push(ch);
        }

        while (stack.size() > lines[1].length() - k) stack.pop();
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
