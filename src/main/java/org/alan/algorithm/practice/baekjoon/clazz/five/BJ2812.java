package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Stack;
import java.util.stream.Collectors;

public class BJ2812 {
    private final int k;
    private final String chars;

    public BJ2812(String input) {
        String[] lines = input.split("\n");
        k = Integer.parseInt(lines[0].split(" ")[1]);
        chars = lines[1];
    }

    public String solve() {
        int erasable = k;
        Stack<Character> stack = new Stack<>();
        for (char ch : chars.toCharArray()) {
            while (!stack.isEmpty() && ch > stack.peek() && erasable > 0) {
                erasable--;
                stack.pop();
            }
            stack.push(ch);
        }

        int length = chars.length() - k;
        while (stack.size() > length) stack.pop();
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
