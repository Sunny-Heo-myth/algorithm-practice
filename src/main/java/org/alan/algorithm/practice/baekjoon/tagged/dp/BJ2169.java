package org.alan.algorithm.practice.baekjoon.tagged.dp;

import java.util.regex.Pattern;

public class BJ2169 {
    public String solve(String input) {
        int[][] MAP = input.lines().skip(1).map(s -> Pattern.compile(" ")
                .splitAsStream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        int N = MAP.length, M = MAP[0].length;

        int[][] memo = new int[N][M];
        int sum = 0;
        for (int i = 0; i < M; i++) memo[0][i] = sum += MAP[0][i];

        for (int i = 1; i < N; i++) {
            int[] left = new int[M], right = new int[M];

            left[0] = memo[i - 1][0] + MAP[i][0];
            for (int j = 1; j < M; j++) left[j] = Math.max(left[j - 1], memo[i - 1][j]) + MAP[i][j];

            right[M - 1] = memo[i - 1][M - 1] + MAP[i][M - 1];
            for (int j = M - 2; j >= 0; j--) right[j] = Math.max(right[j + 1], memo[i - 1][j]) + MAP[i][j];

            for (int j = 0; j < M; j++) memo[i][j] = Math.max(left[j], right[j]);
        }
        return String.valueOf(memo[N - 1][M - 1]);
    }
}
