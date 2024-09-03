package org.alan.algorithm.practice.baekjoon.bronze.one;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BJ9093 {
    public String solve(String input) {
        return Arrays.stream(input.split(" "))
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}
