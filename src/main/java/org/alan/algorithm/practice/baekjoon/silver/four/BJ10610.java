package org.alan.algorithm.practice.baekjoon.silver.four;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BJ10610 {
    public String solve(String input) {
        int[] intArray = input.chars().map(i -> i - '0').map(i -> -i).sorted().map(i -> -i).toArray();
        if (intArray[intArray.length - 1] != 0) return "-1";
        return Arrays.stream(intArray).sum() % 3 == 0 ?
                Arrays.stream(intArray).mapToObj(String::valueOf).collect(Collectors.joining()) : "-1";
    }
}
