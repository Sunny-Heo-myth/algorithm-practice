package org.alan.algorithm.practice.baekjoon.bronze.four;

import java.util.stream.Collectors;

public class BJ1264 {
    public String solve(String input) {
        return input.lines().takeWhile(s -> !s.equals("#"))
                .mapToLong(s -> s.chars().filter(ch -> ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
                        || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u').count())
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("\n"));
    }
}
