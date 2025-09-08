package org.alan.algorithm.practice.baekjoon.tagged.backtracking;

import java.util.stream.IntStream;

public class BJ9663 {
    private final int N;
    private final int[] board;
    private int count = 0;

    public BJ9663(String input) {
        N = Integer.parseInt(input);
        board = new int[N * N];
    }

    public String solve() {
        recur(0, -1);
        return String.valueOf(count);
    }

    private void recur(int n, int start) {
        if (n == N + 1) { count++; return; }

        for (int i = start + 1; i < board.length; i++) if (board[i] == 0) {
            mark(i, 1);
            recur(n + 1, i);
            mark(i, -1);
        }
    }

    private void mark(int i, int count) {
        IntStream.iterate((i / N) * N, p -> p < (i / N + 1) * N, p -> p + 1).forEach(p -> board[p] = Math.min(0, board[p] + count));
        IntStream.iterate(i % N, p -> p < board.length, p -> p + N).forEach(p -> board[p] = Math.min(0, board[p] + count));


        IntStream.iterate(i % (N + 1), p -> p < board.length, p -> p + (N + 1)).forEach(p -> board[p] = Math.min(0, board[p] + count));
        IntStream.iterate(i % (N - 1), p -> p < board.length, p -> p + (N - 1)).forEach(p -> board[p] = Math.min(0, board[p] + count));
    }

}
