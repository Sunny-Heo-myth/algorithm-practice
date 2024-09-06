package org.alan.algorithm.practice.baekjoon.silver.five;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ2167 {
    public String solve(String input) {
        int[][] arr = input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);

        return input.lines()
                .skip(Integer.parseInt(input.split("\n")[0].split(" ")[0]) + 2)
                .map(s -> Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray())
                .mapToInt(ints -> IntStream.range(ints[0] - 1, ints[2]).map(i ->
                        Arrays.stream(arr[i], ints[1] - 1, ints[3]).sum()).sum())
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("\n"));
    }
}
