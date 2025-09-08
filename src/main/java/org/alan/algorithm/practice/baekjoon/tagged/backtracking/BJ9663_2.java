package org.alan.algorithm.practice.baekjoon.tagged.backtracking;

public class BJ9663_2 {
    private final int N;
    private final long fullMask;

    public BJ9663_2(String input) {
        N = Integer.parseInt(input);
        fullMask = (1L << N) - 1;
    }

    public String solve() {
        return String.valueOf(recur(0, 0, 0, 0));
    }

    private int recur(int n, long row, long nw, long ne) {
        if (n == N) return 1;

        int count = 0;
        long available = fullMask & ~(row | nw | ne);
        while (available != 0) {
            long tip = available & -available;
            available -= tip;
            count += recur(n + 1, row | tip, (nw | tip) << 1, (ne | tip) >> 1);
        }
        return count;
    }
}
