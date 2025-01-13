package org.alan.algorithm.practice.baekjoon.barkingdog.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BJ10808 {
    public String solve(String input) {
        int[] alpha = new int[26];
        input.chars().forEach(i -> alpha[i - 97]++);
        return Arrays.stream(alpha).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
