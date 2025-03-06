package org.alan.algorithm.practice.baekjoon.tagged.dp;

import java.util.Arrays;

public class BJ1328 {
    private final int N, L, R;

    public BJ1328(String input) {
        int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        N = arr[0]; L = arr[1]; R = arr[2];
    }

    public String solve() {
        long[][][] memo = new long[N + 1][N + 1][N + 1];

        memo[1][1][1] = 1;
        for (int i = 2; i <= N; i++) for (int j = 1; j <= i; j++) for (int k = 1; k <= i; k++)
            memo[i][j][k] = (memo[i - 1][j - 1][k] + memo[i - 1][j][k - 1] + (i - 2) * memo[i - 1][j][k]) % 1_000_000_007;
        return String.valueOf(memo[N][L][R]);
    }
}
