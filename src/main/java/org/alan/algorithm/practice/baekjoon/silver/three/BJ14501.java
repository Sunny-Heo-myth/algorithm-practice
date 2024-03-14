package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.Arrays;
import java.util.regex.Pattern;

public class BJ14501 {
    public String solve(String input) {
        int[][] timePrice = Pattern.compile("\n").splitAsStream(input).skip(1).map(s ->
                Arrays.stream((s).split(" ")).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        // memo is max money array that he can get when calculated until i.
        int[] memo = new int[timePrice.length + 1];

        // index refers calculation index.
        for (int i = 0; i < timePrice.length; i++) {
            int duration = i + timePrice[i][0];
            if (duration <= timePrice.length) {
                // The max price that BJ can get is maximum between
                // max by far and maximum of index plus price of index which is the price will be added.
                memo[duration] = Integer.max(memo[duration], memo[i] + timePrice[i][1]);
            }
            memo[i + 1] = Integer.max(memo[i], memo[i + 1]);
        }

        return String.valueOf(memo[timePrice.length]);
    }

}
