package org.alan.algorithm.practice.baekjoon.barkingdog.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BJ2577 {
    public String solve(String input) {
        int[] numbers = new int[10];
        int multiple = input.lines().mapToInt(Integer::parseInt).reduce(1, (i, j) -> i * j);
        String.valueOf(multiple).chars().map(i -> i - '0').forEach(i -> numbers[i]++);
        return Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
    }
}
