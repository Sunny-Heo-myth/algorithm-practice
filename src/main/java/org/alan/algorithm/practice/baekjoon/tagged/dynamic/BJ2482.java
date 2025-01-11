package org.alan.algorithm.practice.baekjoon.tagged.dynamic;

public class BJ2482 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int N = Integer.parseInt(lines[0]), K = Integer.parseInt(lines[1]);
        if (N / 2 < K) return "0";

        int DIVISOR = 1_000_000_003;
        int[][] memo = new int[N + 1][K + 1];

        for (int i = 0; i <= N; i++) {
            memo[i][0] = 1;
            memo[i][1] = i;
        }
        for (int i = 2; i <= N; i++) for (int j = 2; j <= K; j++) memo[i][j] = (memo[i - 2][j - 1] + memo[i - 1][j]) % DIVISOR;
        memo[N][K] = (memo[N - 3][K - 1] + memo[N - 1][K]) % DIVISOR;
        return String.valueOf(memo[N][K]);
    }
}
