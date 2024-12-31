package org.alan.algorithm.practice.baekjoon.tagged.dynamic;

import java.util.Arrays;

public class BJ2240 {
    public String solve(String input) {
        int move = Integer.parseInt(input.split("\n")[0].split(" ")[1]);
        int[] dropAt = input.lines().skip(1).mapToInt(Integer::parseInt).toArray();
        int[][] memo = new int[dropAt.length + 1][move + 1];

        for (int t = 1; t <= dropAt.length; t++) for (int m = 0; m <= move; m++) {
            int currentTree = (m % 2 == 0) ? 1 : 2;
            memo[t][m] = memo[t - 1][m] + (dropAt[t - 1] == currentTree ? 1 : 0);
            if (m > 0) memo[t][m] = Math.max(memo[t][m], memo[t - 1][m - 1] + (dropAt[t - 1] == currentTree ? 1 : 0));
        }
        return String.valueOf(Arrays.stream(memo[dropAt.length]).max().orElse(-1));
    }
}
