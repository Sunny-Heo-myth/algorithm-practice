package org.alan.algorithm.practice.baekjoon.tagged.binarysearch;

import java.util.Arrays;

public class BJ2352 {
    private final int[] arr;

    public BJ2352(String input) {
        arr = Arrays.stream(input.split("\n")[1].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public String solve() {
        int[] memo = new int[arr.length];
        int length = 0;

        for (int port : arr) {
            int left = 0, right = length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (memo[mid] < port) left = mid + 1;
                else right = mid;
            }

            memo[left] = port;
            if (left == length) length++;
        }
        return String.valueOf(length);
    }

}
