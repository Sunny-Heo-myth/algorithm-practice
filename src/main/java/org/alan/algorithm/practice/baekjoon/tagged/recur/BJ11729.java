package org.alan.algorithm.practice.baekjoon.tagged.recur;

public class BJ11729 {
    private final int n;

    public BJ11729(String input) {
        n = Integer.parseInt(input);
    }

    public String solve() {
        String result = recur(n, 1, 3);
        return result.split("\n").length + "\n" + result;
    }

    private String recur(int stack, int from, int to) {
        String mid = from + " " + to;
        if (stack == 1) return mid;
        int midIdx = 6 - from - to;
        return recur(stack - 1, from, midIdx) + "\n" + mid + "\n" + recur(stack - 1, midIdx, to);
    }

}
