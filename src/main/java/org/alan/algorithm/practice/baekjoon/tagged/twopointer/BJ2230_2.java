package org.alan.algorithm.practice.baekjoon.tagged.twopointer;

import java.util.Arrays;

public class BJ2230_2 {
    private final int M;
    private final int[] arr;

    public BJ2230_2(String input) {
        String[] lines = input.split("\n");
        M = Integer.parseInt(lines[0].split(" ")[1]);
        arr = Arrays.stream(lines).skip(1).mapToInt(Integer::parseInt).sorted().toArray();
    }

    public String solve() {
        int i = 0, j = 0, result = Integer.MAX_VALUE;
        while (j < arr.length && i <= j) {
            int diff = arr[j] - arr[i];
            if (diff == M) return String.valueOf(M);
            else if (diff < M) j++;
            else {
                result = Math.min(result, diff);
                i++;
            }
        }
        return String.valueOf(result);
    }
}
