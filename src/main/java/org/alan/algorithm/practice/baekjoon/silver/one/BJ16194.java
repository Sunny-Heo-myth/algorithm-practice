package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ16194 {
    public String solve(String input) {
        int[] arr = Pattern.compile(" ").splitAsStream("0 " + input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();
        int[] memo = new int[arr.length]; System.arraycopy(arr, 0, memo, 0, memo.length);
        IntStream.range(1, arr.length).forEach(i -> IntStream.rangeClosed(1, i).forEach(j ->
                memo[i] = Math.min(memo[i], memo[j] + arr[i - j])));
        return String.valueOf(memo[memo.length - 1]);
    }
}
