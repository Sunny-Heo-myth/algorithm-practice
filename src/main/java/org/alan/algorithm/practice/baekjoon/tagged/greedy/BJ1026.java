package org.alan.algorithm.practice.baekjoon.topic.greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BJ1026 {
    public String solve(String input) {
        String[] s = input.split("\n");
        int[] a = Arrays.stream(s[1].split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int[] b = Arrays.stream(s[2].split(" ")).mapToInt(Integer::parseInt).map(i -> -i).sorted().map(i -> -i).toArray();
        return String.valueOf(IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum());
    }
}
