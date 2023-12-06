package org.alan.algorithm.practice.baekjoon.clazz.one;

import java.util.Arrays;

public class BJ2475 {
    public String solve(String input) {
        return String.valueOf(Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).map(i -> i * i).sum() % 10);
    }
}
