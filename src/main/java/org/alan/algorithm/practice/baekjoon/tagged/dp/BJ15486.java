package org.alan.algorithm.practice.baekjoon.tagged.dp;

import java.util.regex.Pattern;

public class BJ15486 {
    private final int[] durations, profits, memo;   // acc profit addable to calculate next acc profit

    public BJ15486(String input) {
        int[][] ints = input.lines().skip(1).map(s ->
                Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);

        durations = new int[ints.length];
        profits = new int[ints.length];
        memo = new int[ints.length + 1];

        for (int i = 0; i < ints.length; i++) {
            durations[i] = ints[i][0];
            profits[i] = ints[i][1];
        }
    }

    public String solve() {
        int resign = memo.length;
        for (int today = 0; today < resign - 1; today++) {
            int mature = today + durations[today];
            if (mature < resign) memo[mature] = Math.max(memo[mature], memo[today] + profits[today]);
            memo[today + 1] = Math.max(memo[today + 1], memo[today]);
        }
        return String.valueOf(memo[resign - 1]);
    }
}
