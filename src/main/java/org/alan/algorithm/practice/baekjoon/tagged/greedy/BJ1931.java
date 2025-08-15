package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import java.util.Arrays;

public class BJ1931 {
    private final int[][] sorted;

    public BJ1931(String input) {
        sorted = input.lines().skip(1)
                .map(s -> Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray())
                .sorted((clz1, clz2) -> clz1[1] == clz2[1] ? clz1[0] - clz2[1] : clz1[1] - clz2[1])
                .toArray(int[][]::new);
    }

    public String solve() {
        int count = 0, lastEnd = 0;
        for (int[] clazz : sorted) {
            int start = clazz[0], end = clazz[1];
            if (start >= lastEnd) {
                count++;
                lastEnd = end;
            }
        }
        return String.valueOf(count);
    }
    
}
