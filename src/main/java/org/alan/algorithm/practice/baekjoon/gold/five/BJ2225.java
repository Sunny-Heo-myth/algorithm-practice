package org.alan.algorithm.practice.baekjoon.gold.five;

import java.util.stream.IntStream;

public class BJ2225 {

    public String solve(String input) {
        String[] s = input.split(" "); int n = Integer.parseInt(s[0]); int k = Integer.parseInt(s[1]);
        int[][] memo = new int[n + 1][k + 1];
        memo[1] = IntStream.rangeClosed(0, k).toArray();
        for (int i = 1; i <= n; i++) memo[i][1] = 1;
        for (int i = 2; i <= n; i++) for (int j = 2; j <= k; j++) memo[i][j] = (memo[i][j - 1] + memo[i - 1][j]) % 1_000_000_000;
        return String.valueOf(memo[n][k]);
    }
}
