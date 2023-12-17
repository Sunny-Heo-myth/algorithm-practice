package org.alan.algorithm.practice.baekjoon.clazz.three;

public class BJ11727 {
    private final int[] memo = new int[1001];
    public String solve(String input) {
        memo[1] = 1;
        memo[2] = 3;
        int n = Integer.parseInt(input);
        for (int i = 3; i <= n; i++) memo[i] = (memo[i - 1] + 2 * memo[i - 2]) % 10007;
        return String.valueOf(memo[n]);
    }

}
