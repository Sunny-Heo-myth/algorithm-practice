package org.alan.algorithm.practice.baekjoon.tagged.sqdl;

import java.util.Stack;
import java.util.regex.Pattern;

public class BJ12846 {
    public String solve(String input) {
        int[] WAGES = Pattern.compile(" ").splitAsStream(input.split("\n")[1] + " 0")
                .mapToInt(Integer::parseInt).toArray();

        long max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < WAGES.length; i++) {
            while (!stack.isEmpty() && WAGES[stack.peek()] > WAGES[i]) {
                int height = WAGES[stack.pop()], width = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
                max = Math.max(max, (long) height * width);
            }
            stack.push(i);
        }

        return String.valueOf(max);
    }

}
