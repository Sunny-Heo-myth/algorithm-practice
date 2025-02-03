package org.alan.algorithm.practice.baekjoon.stepbystep.dp;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;

public class BJ1912 {

    public String solve(String input) {
        int[] arr = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();
        if (arr.length == 1) return String.valueOf(arr[0]);

        int[] memo = new int[arr.length];
        int INVALID = Integer.MAX_VALUE;
        Arrays.fill(memo, INVALID);
        Stack<Integer> subProblems = new Stack<>();

        memo[0] = arr[0];
        subProblems.push(arr.length - 1);
        while (!subProblems.isEmpty()) {
            int peek = subProblems.peek();
            if (memo[peek - 1] == INVALID) {
                subProblems.push(peek - 1);
                continue;
            }

            int pop = subProblems.pop();
            memo[pop] = Math.max(memo[pop - 1] + arr[pop], arr[pop]);
        }

        return String.valueOf(Arrays.stream(memo).max().orElse(INVALID));
    }

    public String solve2(String input) {
        int[] arr = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();
        if (arr.length == 1) return String.valueOf(arr[0]);

        int[] memo = new int[arr.length];

        memo[0] = arr[0];
        int max = memo[0];
        for (int i = 1; i < arr.length; i++) {
            memo[i] = Math.max(memo[i - 1] + arr[i], arr[i]);
            max = Math.max(max, memo[i]);
        }
        return String.valueOf(max);
    }

}
