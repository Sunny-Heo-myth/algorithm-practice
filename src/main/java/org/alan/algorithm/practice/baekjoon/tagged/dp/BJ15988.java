package org.alan.algorithm.practice.baekjoon.tagged.dp;

public class BJ15988 {
    private final long[] memo;

    public BJ15988(String input) {
        memo = new long[Integer.parseInt(input) + 1];
    }

    public String solve() {
        int n = memo.length - 1;
        if (n <= 3) return String.valueOf(switch (n) {
            case 1 -> 1;
            case 2 -> 2;
            case 3 -> 4;
            default -> throw new IllegalArgumentException();
        });

        memo[1] = 1; memo[2] = 2; memo[3] = 4;
        for (int i = 4; i < memo.length; i++) memo[i] = (memo[i - 1] + memo[i - 2] +memo[i - 3]) % 1_000_000_009;
        return String.valueOf(memo[n]);
    }
}
