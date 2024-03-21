package org.alan.algorithm.practice.baekjoon.silver.three;

import java.math.BigInteger;

public class BJ2407 {
    private final BigInteger[][] pascal = new BigInteger[101][101];

    public String solve(String input) {
        String[] s = input.split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for (int i = 0; i < pascal.length; i++) {
            pascal[i][0] = pascal[i][i] = BigInteger.ONE;
        }

        int small = Integer.min(m, n - m);

        return String.valueOf(recur(n, small));
    }

    private BigInteger recur(int i, int j) {
        if (pascal[i][j] != null) {
            return pascal[i][j];
        }

        pascal[i][j] = recur(i - 1, j - 1).add(recur(i - 1, j));
        return pascal[i][j];

    }
}
