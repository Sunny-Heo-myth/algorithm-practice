package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.stream.IntStream;

public class BJ1992 {
    private int[][] block;
    private final StringBuilder answer = new StringBuilder();

    public String solve(String input) {
        block = input.lines().skip(1).map(s -> s.chars().toArray()).toArray(int[][]::new);
        recur(0, 0, block.length);
        return answer.toString();
    }

    private void recur(int x, int y, int length) {
        int n = block[x][y];

        if (length == 1) {
            answer.append(n - '0');
            return;
        }

        if (IntStream.range(x, x + length).filter(i -> IntStream.range(y, y + length)
                .filter(j -> block[i][j] != n).findAny().isPresent()).findAny().isPresent()) {

            int half = length / 2;
            int xx = x + half;
            int yy = y + half;

            answer.append("(");
            recur(x, y, half);
            recur(x, yy, half);
            recur(xx, y, half);
            recur(xx, yy, half);
            answer.append(")");

        } else {
            answer.append(n - '0');
        }
    }
}
