package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Arrays;
import java.util.regex.Pattern;

public class BJ2342 {
    private int[] move;
    private int[][][] memo;

    public String solve(String input) {
        move = Pattern.compile(" ").splitAsStream(input.substring(0, input.length() - 2)).mapToInt(Integer::parseInt).toArray();
        memo = new int[5][5][move.length + 1];
        for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) Arrays.fill(memo[i][j], -1);
        return String.valueOf(step(0, 0, 0));
    }

    private int step(int left, int right, int reverseCount) {
        if (reverseCount == move.length) return 0;
        if (memo[left][right][reverseCount] != -1) return memo[left][right][reverseCount];

        memo[left][right][reverseCount] = Math.min(
                step(move[reverseCount], right, reverseCount + 1) + shake(left, move[reverseCount]),
                step(left, move[reverseCount], reverseCount + 1) + shake(right, move[reverseCount]));
        return memo[left][right][reverseCount];
    }

    private int shake(int from, int to) {
        int diff = Math.abs(from - to);
        if (from == 0) return 2;
        else if (diff == 0) return 1;
        else if (diff == 1 || diff == 3) return 3;
        else return 4;
    }
}
