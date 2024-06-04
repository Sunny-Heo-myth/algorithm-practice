package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.regex.Pattern;

public class BJ17404 {
    public String solve(String input) {
        int INF = 1_000_000;
        int[][] costs = input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);

        int answer = INF;
        int[][] memo = new int[costs.length][3];
        for (int k = 0; k < 3; k++) {
            memo[0][k] = costs[0][k]; memo[0][(k + 1) % 3] = INF; memo[0][(k + 2) % 3] = INF;

            for (int i = 1; i < costs.length; i++) for (int j = 0; j < 3; j++)
                memo[i][j] = Math.min(memo[i - 1][(j + 1) % 3], memo[i - 1][(j + 2) % 3]) + costs[i][j];

            for (int j = 0; j < 3; j++) if (k != j) answer = Math.min(answer, memo[memo.length - 1][j]);
        }
        return String.valueOf(answer);
    }
}
