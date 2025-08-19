package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import java.util.Stack;
import java.util.regex.Pattern;

public class BJ11501 {
    private final int[] days;
    private final Stack<Integer> stack = new Stack<>();

    public BJ11501(String input) {
        days = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();
    }

    public String solve() {
        int highest = 0;
        for (int i = days.length - 1; i >= 0; i--) {
            if (highest < days[i]) {
                highest = days[i];
                stack.push(i);
            }
        }

        long sum = 0;
        for (int i = 0; i < days.length; i++) {
            if (stack.peek() == i) {
                stack.pop();
                continue;
            }

            sum += (days[stack.peek()] - days[i]);
        }
        return String.valueOf(sum);
    }
}
