package org.alan.algorithm.practice.baekjoon.tagged.binarysearch;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class BJ2295_2 {
    private final int[] arr;
    private final Set<Integer> sums = new HashSet<>();

    public BJ2295_2(String input) {
        arr = Pattern.compile("\n").splitAsStream(input).skip(1)
                .mapToInt(Integer::parseInt).sorted().toArray();
        for (int i : arr) for (int j : arr) sums.add(i + j);
    }

    public String solve() {
        for (int k = arr.length - 1; k >= 0; k--) for (int z = k - 1; z >= 0; z--)
            if (sums.contains(arr[k] - arr[z])) return String.valueOf(arr[k]);
        return null;
    }
}
