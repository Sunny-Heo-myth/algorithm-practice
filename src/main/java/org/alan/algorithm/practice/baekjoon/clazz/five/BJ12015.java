package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.regex.Pattern;

public class BJ12015 {
    private int[] memo;

    public String solve(String input) {
        int[] arr = input.lines().skip(1).flatMapToInt(s ->
                Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt)).toArray();
        memo = new int[arr.length]; memo[0] = arr[0];

        int length = 1;
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            if (memo[length - 1] < key) {
                length++;
                memo[length - 1] = key;
            } else {
                int idx = bSearch(length, key);
                memo[idx] = key;
            }
        }

        return String.valueOf(length);
    }

    private int bSearch(int right, int key) {
        int left = 0;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (memo[mid] < key) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
