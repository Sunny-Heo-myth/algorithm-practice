package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ11052 {
    public String solve(String input) {
        int[] arr = Pattern.compile(" ").splitAsStream("0 " + input.split("\n")[1]).mapToInt(Integer::parseInt).toArray();
        int[] memo = new int[arr.length];
        IntStream.range(0, arr.length).forEach(i -> IntStream.rangeClosed(0, i).forEach(j -> memo[i] = Math.max(memo[i], memo[j] + arr[i - j])));
        return String.valueOf(memo[arr.length - 1]);
    }
}
