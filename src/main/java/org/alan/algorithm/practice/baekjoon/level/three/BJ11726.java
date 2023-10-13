package org.alan.algorithm.practice.baekjoon.level.three;

public class BJ11726 {
    private final int[] memo = new int[1001];   // index refers n
    public String solve(String input) {
        int n = Integer.parseInt(input);
        memo[1] = 1;
        memo[2] = 2;
        return String.valueOf(recur(n));
    }

    private int recur(int n) {
        if (memo[n] != 0) return memo[n];

        int result = (recur(n - 1) + recur(n - 2)) % 10007;
        memo[n] = result;

        return result;
    }
}
