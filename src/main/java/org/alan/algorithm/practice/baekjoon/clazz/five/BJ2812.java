package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Stack;

public class BJ2812 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int k = Integer.parseInt(lines[0].split(" ")[1]);

        int deletableCount = k;
        String str = lines[1];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (!stack.isEmpty()) while (deletableCount > 0 && !stack.empty() && str.charAt(i) > stack.peek()) {
                stack.pop();
                deletableCount--;
            }
            stack.push(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() != str.length() - k) stack.pop();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
