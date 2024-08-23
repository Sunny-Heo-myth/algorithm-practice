package org.alan.algorithm.practice.baekjoon.tagged.bsearch;

import java.util.regex.Pattern;

public class BJ12738 {
    private int[] memo;

    public String solve(String input) {
        int[] arr = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();
        memo = new int[arr.length]; memo[0] = arr[0];

        int at = 1;
        for (int i = 1; i < memo.length; i++) {
            int v = arr[i];
            if (memo[at - 1] < v) memo[at++] = v;
            else memo[bSearch(i, v)] = v;
        }
        return String.valueOf(at);
    }

    private int bSearch(int right, int v) {
        int left = 0;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (memo[mid] < v) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
