package org.alan.algorithm.practice.baekjoon.topic.greedy;

import java.util.Arrays;

public class BJ1026 {
    public String solve(String input) {
        String[] s = input.split("\n");
        int[] a = Arrays.stream(s[1].split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int[] b = Arrays.stream(s[2].split(" ")).mapToInt(Integer::parseInt).map(i -> -i).sorted().map(i -> -i).toArray();
        int sum = 0;
        for (int i = 0; i < a.length; i++) sum += a[i] * b[i];
        return String.valueOf(sum);
    }
}
