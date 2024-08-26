package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.regex.Pattern;

public class BJ12015 {
    private int[] memo;

    public String solve(String input) {
        int[] arr = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();
        int l = arr.length;
        memo = new int[l]; memo[0] = arr[0];

        int size = 1;
        for (int i = 1; i < l; i++) {
            int key = arr[i];
            if (memo[size - 1] < key) memo[size++] = key;
            else memo[bSearch(i, key)] = key;
        }
        return String.valueOf(size);
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
