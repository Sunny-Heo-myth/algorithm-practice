package org.alan.algorithm.practice.baekjoon.problem;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ2440 {
    public String solve(String input) {
        return IntStream.range(0, Integer.parseInt(input)).mapToObj(i -> "*".repeat(Integer.parseInt(input) - i)).collect(Collectors.joining("\n"));
    }
}
