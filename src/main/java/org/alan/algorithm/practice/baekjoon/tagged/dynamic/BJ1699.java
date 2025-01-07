package org.alan.algorithm.practice.baekjoon.tagged.dynamic;

import java.util.stream.IntStream;

public class BJ1699 {

    public String solve(String input) {
        int n = Integer.parseInt(input);
        int[] memo = new int[n + 1];
        IntStream.rangeClosed(1, n).forEach(i ->
                memo[i] = IntStream.range(1, i)
                        .takeWhile(j -> j * j <= i)
                        .map(j -> memo[i - j * j] + 1) // j * j can be counted as 1 thus we add 1
                        .min().orElse(i));
        return String.valueOf(memo[n]);
    }

}
