package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.stream.IntStream;

public class BJ1915 {
    public String solve(String input) {
        int[][] X = input.lines().skip(1).map(s -> s.chars().map(i -> i - '0').toArray()).toArray(int[][]::new);
        int n = X.length; int m = X[0].length; int[][] memo = new int[n][m];

        int max = 0;
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) if (X[i][j] == 1) {
            if (i == 0 || j == 0) memo[i][j] = 1;
            else memo[i][j] = IntStream.of(memo[i - 1][j], memo[i][j - 1], memo[i - 1][j - 1]).min().orElse(-1) + 1;
            max = Math.max(max, memo[i][j]);
        }
        return String.valueOf(max * max);
    }
}
