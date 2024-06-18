package org.alan.algorithm.practice.baekjoon.problem;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BJ2446 {
    public String solve(String input) {
        int n = Integer.parseInt(input);
        return Stream.concat(IntStream.iterate(n, i -> i > 1, i -> i - 1).mapToObj(i -> " ".repeat(n - i) + "*".repeat(i * 2 - 1)),
                        IntStream.iterate(1, i -> i <= n, i -> i + 1).mapToObj(i -> " ".repeat(n - i) + "*".repeat(i * 2 - 1)))
                .collect(Collectors.joining("\n"));
    }
}
