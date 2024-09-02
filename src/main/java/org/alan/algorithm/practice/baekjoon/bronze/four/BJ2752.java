package org.alan.algorithm.practice.baekjoon.bronze.four;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BJ2752 {
    public String solve(String input) {
        return Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
