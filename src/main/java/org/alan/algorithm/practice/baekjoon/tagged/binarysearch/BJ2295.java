package org.alan.algorithm.practice.baekjoon.tagged.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ2295 {
    private final int[] arr;

    public BJ2295(String input) {
        arr = input.lines().skip(1).mapToInt(Integer::parseInt).sorted().toArray();
    }

    public String solve() {
        List<Integer> sums = new ArrayList<>(); // s-complexity: O(N^2)
        for (int i = 0; i < arr.length; i++) for (int j = 0; j <= i; j++) sums.add(arr[i] + arr[j]);
        Collections.sort(sums); // t-complexity O(N^2 log N^2)

        for (int i = arr.length - 1; i >= 0; i--) for (int j = 0; j < i; j++) {
            int targetSum = arr[i] - arr[j];
            if (Collections.binarySearch(sums, targetSum) >= 0) return String.valueOf(arr[i]);  // t-complexity O(log N^2)
        }
        return "invalid";
    }
}
