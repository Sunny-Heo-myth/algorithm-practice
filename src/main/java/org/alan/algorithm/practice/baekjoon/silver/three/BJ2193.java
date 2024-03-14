package org.alan.algorithm.practice.baekjoon.silver.three;

public class BJ2193 {
    public String solve(String input) {
        int digit = Integer.parseInt(input);
        if (digit == 1 || digit == 2) return "1";

        long[][] memo = new long[digit][2];
        memo[0][0] = 0;
        memo[0][1] = 1;
        memo[1][0] = 1;
        memo[1][1] = 0;
        for (int i = 2; i < digit; i++) {
            memo[i][0] = memo[i - 1][0] + memo[i - 1][1];
            memo[i][1] = memo[i - 1][0];
        }
        return String.valueOf(memo[digit - 1][0] + memo[digit - 1][1]);
    }
}
