package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;

public class BJ6198 {

    public String solve(String input) {
        int[] buildings = Pattern.compile("\n").splitAsStream(input).skip(1).mapToInt(Integer::parseInt).toArray();
        int[] watchables = new int[buildings.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = buildings.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && buildings[i] > buildings[stack.peek()]) stack.pop();
            watchables[i] = (stack.isEmpty() ? buildings.length : stack.peek()) - i - 1;
            stack.push(i);
        }

        return String.valueOf(Arrays.stream(watchables).mapToLong(Long::valueOf).sum());
    }
}
