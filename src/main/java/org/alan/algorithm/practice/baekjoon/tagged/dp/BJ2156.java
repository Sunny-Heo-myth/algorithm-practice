package org.alan.algorithm.practice.baekjoon.tagged.dp;

import java.util.stream.IntStream;

public class BJ2156 {
    private final int[] arr, memo;

    public BJ2156(String input) {
        String[] lines = input.split("\n");
        int n = Integer.parseInt(lines[0]);
        arr =  new int[n + 3];
        // The maximum amount that I can drink,
        // when there is a drink sequence with the length of i from the first one.
        memo = new int[n + 3];
        for (int i = 1; i < lines.length;i++) arr[i + 2] = Integer.parseInt(lines[i]);
    }

    public String solve() {
        for (int i = 3; i < memo.length; i++) memo[i] = IntStream.of(
                memo[i - 1],
                        memo[i - 2] + arr[i],
                        memo[i - 3] + arr[i] + arr[i - 1])
                .max().orElse(0);
        return String.valueOf(memo[memo.length - 1]);
    }
}
