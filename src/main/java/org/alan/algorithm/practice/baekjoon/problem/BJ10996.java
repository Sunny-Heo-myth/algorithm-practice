package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ10996 {
    public String solve(String input) {
        if (Objects.equals(input, "1")) return "*";
        int n = Integer.parseInt(input);

        String x = IntStream.range(0, n).mapToObj(i -> {
            if (i % 2 == 0) return "*";
            else return " ";
        }).collect(Collectors.joining());

        String y = x.substring(1) + (x.charAt(x.length() - 1) == '*' ? " " : "*");

        return IntStream.range(0, n * 2).mapToObj(i -> {
            if (i % 2 == 0) return x;
            else return y;
        }).collect(Collectors.joining("\n"));
    }
}
