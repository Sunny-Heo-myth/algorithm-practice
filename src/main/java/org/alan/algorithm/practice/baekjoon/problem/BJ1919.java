package org.alan.algorithm.practice.baekjoon.problem;

import java.util.stream.IntStream;

public class BJ1919 {
    public String solve(String input) {
        String[] s = input.split("\n");
        int[] up = new int[26];
        int[] down = new int[26];
        s[0].chars().map(i -> i - 'a').forEach(i -> up[i]++);
        s[1].chars().map(i -> i - 'a').forEach(i -> down[i]++);

        return String.valueOf(IntStream.range(0, 26).map(i -> Math.abs(up[i] - down[i])).sum());
    }
}
