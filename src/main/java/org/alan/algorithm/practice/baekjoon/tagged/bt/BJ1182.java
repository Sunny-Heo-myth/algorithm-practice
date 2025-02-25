package org.alan.algorithm.practice.baekjoon.tagged.bt;

import java.util.Stack;
import java.util.regex.Pattern;

public class BJ1182 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int S = Integer.parseInt(lines[0].split(" ")[1]);
        int[] ARR = Pattern.compile(" ").splitAsStream(lines[1]).mapToInt(Integer::parseInt).toArray();

        int count = 0;
        for (int start = 0; start < ARR.length; start++) {
            Stack<int[]> stack = new Stack<>();

            stack.push(new int[]{start, ARR[start]});
            while (!stack.isEmpty()) {
                int[] pop = stack.pop();
                int i = pop[0], sum = pop[1];
                if (sum == S) count++;

                for (int j = i + 1; j < ARR.length; j++) {
                    stack.push(new int[]{j, sum + ARR[j]});
                }
            }
        }
        return String.valueOf(count);
    }
}
