package org.alan.algorithm.practice.baekjoon.gold.five;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ2493 {
    public String solve(String input) {
        int[] towers = Pattern.compile(" ").splitAsStream(input.split("\n")[1]).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[towers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < towers.length; i++) {
            while (!stack.isEmpty() && towers[stack.peek()] <= towers[i]) stack.pop();
            if (!stack.isEmpty()) answer[i] = stack.peek() + 1;
            else answer[i] = 0;
            stack.push(i);
        }
        return Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
