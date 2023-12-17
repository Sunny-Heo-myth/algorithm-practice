package org.alan.algorithm.practice.baekjoon.clazz.three;

public class BJ17626 {
    public String solve(String input) {
        int n = Integer.parseInt(input);
        int[] memo = new int[n + 1];
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) min = Math.min(min, memo[i - j * j]);
            memo[i] = min + 1;
        }
        return String.valueOf(memo[n]);
    }
}
