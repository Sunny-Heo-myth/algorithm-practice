package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.regex.Pattern;

public class BJ1890 {
    private int[][] bd;
    private long[][] memo;

    public String solve(String input) {
        bd = input.lines().skip(1).map(s ->
                Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray()
        ).toArray(int[][]::new);
        memo = new long[bd.length][bd.length];
        return String.valueOf(recur(0, 0));
    }

    private long recur(int x, int y) {
        if (x == bd.length - 1 && y == bd.length - 1) return 1;
        if (x >= bd.length || y >= bd.length || bd[x][y] == 0) return 0;
        if (memo[x][y] != 0) return memo[x][y];
        return memo[x][y] = recur(x, y + bd[x][y]) + recur(x + bd[x][y], y);
    }

}
