package org.alan.algorithm.practice.baekjoon.clazz.three;

public class BJ9095 {
    private final int[] memo = new int[11];   // index refer n

    public String solve(String input) {
        int n = Integer.parseInt(input);
        return String.valueOf(recur(n, 0));
    }

    private int recur(int n, int count) {
        if (n == 0) {
            return ++count;
        }

        if (n < 0) {
            return count;
        }

        if (memo[n] != 0) {
            return count + memo[n];
        }

        return memo[n] = recur(n - 1, count) + recur(n - 2, count) + recur(n - 3, count);
    }
}
