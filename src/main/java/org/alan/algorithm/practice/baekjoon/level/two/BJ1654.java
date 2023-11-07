package org.alan.algorithm.practice.baekjoon.level.two;

import java.util.Arrays;

public class BJ1654 {
    public String solve(String input) {
        String[] line = input.split("\n");
        int numberNeeded = Integer.parseInt(line[0].split(" ")[1]);
        int[] lan = Arrays.stream(line).skip(1).mapToInt(Integer::parseInt).toArray();
        long max = Arrays.stream(lan).mapToLong(Long::valueOf).max().orElse(0);
        long min = 0;
        long mid;
        while (min < max) {
            mid = (min + max) / 2;
            long finalMid = mid;
            long count = Arrays.stream(lan).mapToLong(i -> i / finalMid).sum();

            if (count < numberNeeded) max = mid;
            else min = mid + 1;
        }
        return String.valueOf(min - 1);
    }

}
