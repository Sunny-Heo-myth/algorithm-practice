package org.alan.algorithm.practice.baekjoon.tagged.twopointer;

import java.util.Arrays;

public class BJ2230 {
    private final int M;
    private final int[] arr;

    public BJ2230(String input) {
        String[] lines = input.split("\n");
        M = Integer.parseInt(lines[0].split(" ")[1]);
        arr = Arrays.stream(lines).skip(1).mapToInt(Integer::parseInt).sorted().toArray();
    }

    public String solve() {
        int i = 0, j = 0, result = Integer.MAX_VALUE;
        while (j < arr.length) {
            int diff = arr[j] - arr[i];

            if (diff < M) {
                j++;
            } else if (diff > M) {
                result = Math.min(result, diff);
                i++;
            } else {
                return String.valueOf(M);
            }
        }
        return String.valueOf(result);
    }
}
