package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BJ11057 {
    private int N;
    private int count = 0;

    public String solve(String input) {
        N = Integer.parseInt(input);
        for (int i = 0; i < 10; i++) {
            backtrack(i, 1);
        }
        return String.valueOf(count);
    }

    private void backtrack(int n, int at) {
        if (at == N) {
            count = (count + 1) % 1007;
            return;
        }

        for (int i = n; i < 10; i++) {
            backtrack(i, at + 1);
        }
    }

    private int[][] memo;

    public String solve2(String input) {
        int n = Integer.parseInt(input);
        memo = new int[n + 2][10];
        Arrays.fill(memo[1], 1);
        return String.valueOf(calculate(n + 1, 0));
    }

    private int calculate(int n, int m) {
        if (memo[n][m] != 0) return memo[n][m];
        return memo[n][m] = IntStream.range(m , 10).map(i -> calculate(n - 1, i) % 10007).sum() % 10007;
    }
}
