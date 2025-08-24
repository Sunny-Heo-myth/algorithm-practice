package org.alan.algorithm.practice.baekjoon.tagged.dp;

public class BJ2302 {
    private final boolean[] isFixed;
    private final int[] memo;

    public BJ2302(String input) {
        int n = Integer.parseInt(input.split("\n")[0]) + 1;
        isFixed = new boolean[n];
        memo = new int[n];
        input.lines().skip(2).mapToInt(Integer::parseInt).forEach(i -> isFixed[i] = true);
    }

    public String solve() {
        memo[0] = 1; memo[1] = 1;
        for (int seat = 2; seat < memo.length; seat++) {
            memo[seat] = memo[seat - 1] + (isFixed[seat] || isFixed[seat - 1] ? 0 : memo[seat - 2]);
        }
        return String.valueOf(memo[memo.length - 1]);
    }
}
