package org.alan.algorithm.practice.baekjoon.tagged.dynamic;

public class BJ2011 {
    public String solve(String input) {
        int[] arr = input.chars().map(i -> i - '0').toArray();
        if (arr[0] == 0) return "0";

        int[] memo = new int[arr.length + 1];

        memo[0] = 1; memo[1] = 1;
        for (int i = 2; i < memo.length; i++) {
            int oneDigit = arr[i - 1];
            if (oneDigit >= 1) {
                memo[i] += memo[i - 1];
                memo[i] %= 1_000_000;
            }

            int twoDigit = arr[i - 2] * 10 + arr[i - 1];
            if (twoDigit >= 10 && twoDigit <= 26) {
                memo[i] += memo[i - 2];
                memo[i] %= 1_000_000;
            }
        }
        return String.valueOf(memo[memo.length - 1]);
    }
}
