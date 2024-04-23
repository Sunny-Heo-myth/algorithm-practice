package org.alan.algorithm.practice.baekjoon.silver.one;

public class BJ1309 {
    private int[][] memo;
    public String solve(String input) {
        int n = Integer.parseInt(input);
        memo = new int[n + 1][3];
        memo[0][0] = memo[0][1] = memo[0][2] = 1;
        return String.valueOf(recur(n, 0) % 9901);
    }

    private int recur(int n, int i) {
        if (memo[n][i] != 0) return memo[n][i];

        return switch (i) {
            case 0 -> memo[n][i] = (recur(n - 1, 0) + recur(n - 1, 1) + recur(n - 1, 2)) % 9901;
            case 1 -> memo[n][i] = (recur(n - 1, 0) + recur(n - 1, 2)) % 9901;
            case 2 -> memo[n][i] = (recur(n - 1, 0) + recur(n - 1, 1)) % 9901;
            default -> throw new RuntimeException();
        };
    }
}
