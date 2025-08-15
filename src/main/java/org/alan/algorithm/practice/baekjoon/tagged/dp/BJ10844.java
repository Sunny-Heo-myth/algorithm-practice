package org.alan.algorithm.practice.baekjoon.tagged.dp;

import java.util.Arrays;

public class BJ10844 {
    private final long[][] memo; // length, prefix memo
    private static final long DIV = 1_000_000_000;

    public BJ10844(String input) {
        memo = new long[Integer.parseInt(input) + 1][10];
        for (int i = 0; i <= 9; i++) memo[1][i] = 1;
    }

    public String solve() {
        for (int l = 2; l < memo.length; l++) for (int prefix = 0; prefix <= 9; prefix++) {
            memo[l][prefix] = (
                    (prefix + 1 > 9 ? 0 : memo[l - 1][prefix + 1]) +
                    (prefix - 1 < 0 ? 0 : memo[l - 1][prefix - 1])
            ) % DIV;
        }

        return String.valueOf(Arrays.stream(memo[memo.length - 1]).skip(1).sum() % DIV);
    }
}
