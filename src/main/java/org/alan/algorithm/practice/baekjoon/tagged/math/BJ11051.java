package org.alan.algorithm.practice.baekjoon.tagged.math;

public class BJ11051 {
    private final int n, k;
    private final int[] memo;

    public BJ11051(String input) {
        String[] ss = input.split(" ");
        n = Integer.parseInt(ss[0]); k = Integer.parseInt(ss[1]);
        memo = new int[n + 1];
    }

    public String solve() {
        for (int i = 1; i <= n; i++) for (int j = i; j >= 0; j--)
            memo[j] = (j == i || j == 0) ? 1 : (memo[j] + memo[j - 1]) % 10_007;
        return String.valueOf(memo[k]);
    }

}
