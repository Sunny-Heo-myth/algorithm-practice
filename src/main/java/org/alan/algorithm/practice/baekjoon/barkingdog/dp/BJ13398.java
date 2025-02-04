package org.alan.algorithm.practice.baekjoon.barkingdog.dp;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ13398 {
    public String solve(String input) {
        int[] arr = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();
        if (arr.length == 1) return String.valueOf(arr[0]);

        int max = arr[0];
        int[][] memo = new int[arr.length][2];
        memo[0][0] = memo[0][1] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            memo[i][0] = Math.max(memo[i - 1][0] + arr[i], arr[i]);
            memo[i][1] = Math.max(memo[i - 1][0], memo[i - 1][1] + arr[i]);
            max = IntStream.of(max, memo[i][0], memo[i][1]).max().orElse(Integer.MIN_VALUE);
        }
        return String.valueOf(max);
    }
}
