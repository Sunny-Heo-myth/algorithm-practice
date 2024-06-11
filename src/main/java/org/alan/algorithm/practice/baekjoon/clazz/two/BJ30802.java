package org.alan.algorithm.practice.baekjoon.clazz.two;

import java.util.Arrays;

public class BJ30802 {
    public String solve(String input) {
        String[] lines = input.split("\n"); String[] third = lines[2].split(" ");
        int N = Integer.parseInt(lines[0]); int T = Integer.parseInt(third[0]); int P = Integer.parseInt(third[1]);
        return Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt)
                .map(i -> i % T == 0 ? i / T : i / T + 1).sum() + "\n" + N / P + " " + N % P;
    }
}
