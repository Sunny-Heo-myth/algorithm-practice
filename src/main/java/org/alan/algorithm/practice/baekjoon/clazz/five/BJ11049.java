package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.regex.Pattern;

public class BJ11049 {
    public String solve(String input) {
        int[][] mx = input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);

        int[][] memo = new int[mx.length][mx.length];
        for (int i = 0; i < mx.length - 1; i++) memo[i][i + 1] = mx[i][0] * mx[i][1] * mx[i + 1][1];

        for (int itv = 2; itv < mx.length; itv++) for (int i = 0; i + itv < mx.length; i++) {
            int j = i + itv; memo[i][j] = Integer.MAX_VALUE;
            for (int k = i; k < j; k++) memo[i][j] = Math.min(memo[i][j], memo[i][k] + memo[k + 1][j] + mx[i][0] * mx[k][1] * mx[j][1]);
        }
        return String.valueOf(memo[0][mx.length - 1]);
    }
}
