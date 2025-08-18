package org.alan.algorithm.practice.baekjoon.tagged.dp;

import java.util.Arrays;

public class BJ2240 {
    private final int[] drop;
    private final int[][] memo;

    public BJ2240(String input) {
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        int T = Integer.parseInt(firstLine[0]), M = Integer.parseInt(firstLine[1]);

        drop = new int[T + 1];
        for (int t = 1; t <= T; t++) drop[t] = Integer.parseInt(lines[t]);

        memo = new int[T + 1][M + 1];
        int count = 0;
        for (int t = 0; t <= T; t++) memo[t][0] = drop[t] == 1 ? ++count : count;
    }

    public String solve() {
        int T = memo.length, M = memo[0].length;
        for (int t = 1; t < T; t++) for (int m = 1; m < M; m++) {
            int position = m % 2 == 0 ? 1 : 2;
            int dropAt = drop[t];
            memo[t][m] = Math.max(memo[t - 1][m], memo[t - 1][m - 1]) + (position == dropAt ? 1 : 0);
        }
        return String.valueOf(Arrays.stream(memo[T - 1]).max().orElse(0));
    }
}
