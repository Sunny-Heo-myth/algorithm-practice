package org.alan.algorithm.practice.baekjoon.stepbystep.cumulativesum;

import java.util.Arrays;

public class BJ2559 {
    public String solve(String input) {
        String[] s = input.split("\n");
        int count = Integer.parseInt(s[0].split(" ")[1]);
        int[] array = Arrays.stream(s[1].split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        int[] sums = new int[array.length];
        for (int i = 0; i < sums.length; i++) sums[i] = sum += array[i];

        int max = sums[count - 1];
        for (int i = count; i < sums.length; i++) max = Integer.max(max, sums[i] - sums[i - count]);

        return String.valueOf(max);
    }
}
