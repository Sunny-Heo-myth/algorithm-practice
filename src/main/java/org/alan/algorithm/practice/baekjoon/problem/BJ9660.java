package org.alan.algorithm.practice.baekjoon.problem;

import java.util.stream.Stream;

public class BJ9660 {
    public String solve(String input) {
        Boolean[] circle = Stream.of(false, true, false, true, true, true, true).toArray(Boolean[]::new);
        return circle[(int) (Long.parseLong(input) % 7)] ? "SK" : "CY";
    }
}
