package org.alan.algorithm.practice.baekjoon.level.three;

import java.util.Arrays;

public class BJ11399 {
    public String solve(String input) {
        int[] ints = Arrays.stream(input.split("\n")[1].split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        merge_sort(ints, 0, ints.length);

        int sum = 0;
        for (int i = 0; i < ints.length; i++) sum += ints[i] * (ints.length - i);
        return String.valueOf(sum);
    }

    // Always, I prefer "from" index is covered, "to" index is not.
    private void merge_sort(int[] ints, int from, int to) {
        if (from >= to - 1) return;
        int mid = (from + to) / 2;
        merge_sort(ints, from, mid);
        merge_sort(ints, mid, to);
        merge(ints, from, mid, to);
    }

    private void merge(int[] ints, int from, int mid, int to) {
        int[] left = new int[mid - from];
        int[] right = new int[to - mid];
        System.arraycopy(ints, from, left, 0, left.length);
        System.arraycopy(ints, mid, right, 0, right.length);

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length)
            if (left[i] < right[j]) ints[from + k++] = left[i++];
            else ints[from + k++] = right[j++];

        while (i < left.length) ints[from + k++] = left[i++];
        while (j < right.length) ints[from + k++] = right[j++];
    }

}
