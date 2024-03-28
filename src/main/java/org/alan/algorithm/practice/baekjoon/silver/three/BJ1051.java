package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ1051 {
    public String solve(String input) {
        int[][] ints = Pattern.compile("\n").splitAsStream(input).skip(1).map(s ->
                s.chars().map(i -> i - '0').toArray()).toArray(int[][]::new);
        int max = IntStream.range(0, ints.length).map(i -> IntStream.range(0, ints[0].length).map(j ->
                IntStream.range(0, Integer.min(ints[0].length - j, ints.length - i))
                        .filter(k -> ints[i][j] == ints[i + k][j] && ints[i + k][j] == ints[i][j + k] && ints[i][j + k] == ints[i + k][j + k])
                        .max().orElse(-1)).max().orElse(-1)).max().orElse(-1);
        return String.valueOf((int) Math.pow(max + 1, 2));
    }
}
