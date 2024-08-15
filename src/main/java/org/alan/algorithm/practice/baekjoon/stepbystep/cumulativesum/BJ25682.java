package org.alan.algorithm.practice.baekjoon.stepbystep.cumulativesum;

import java.util.stream.IntStream;

public class BJ25682 {
    public String solve(String input) {
        String[] s = input.split("\n")[0].split(" "); char BLACK = 'B'; char WHITE = 'W';
        int N = Integer.parseInt(s[0]); int M = Integer.parseInt(s[1]); int K = Integer.parseInt(s[2]);

        int[][] cut1 = target(K, BLACK, WHITE);
        int[][] cut2 = target(K, WHITE, BLACK);

        int[][] board = input.lines().skip(1).map(ss -> ss.chars().toArray()).toArray(int[][]::new);
        int answer1 = calculate(N, M, K, board, cut1);
        int answer2 = calculate(N, M, K, board, cut2);

        return String.valueOf(Math.min(answer1, answer2));
    }

    private int[][] target(int k, char BLACK, char WHITE) {
        return IntStream.range(0, k).mapToObj(i -> {
            if (i % 2 == 0) return IntStream.range(0, k).map(j -> j % 2 == 0 ? BLACK : WHITE).toArray();
            else return IntStream.range(0, k).map(j -> j % 2 == 0 ? WHITE : BLACK).toArray();
        }).toArray(int[][]::new);
    }

    private int calculate(int n, int m, int k, int[][] board, int[][] cut) {
        return IntStream.rangeClosed(0, n - k).map(i -> IntStream.rangeClosed(0, m - k).map(j ->
                        IntStream.range(0, k).map(x -> (int) IntStream.range(0, k).filter(y -> board[i + x][j + y] != cut[x][y]).count()).sum())
                .min().orElse(-1)).min().orElse(-1);
    }
}
