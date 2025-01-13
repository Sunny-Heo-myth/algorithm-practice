package org.alan.algorithm.practice.baekjoon.barkingdog.array;

import java.util.regex.Pattern;

public class BJ10807 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int v = Integer.parseInt(lines[2]);
        return String.valueOf(Pattern.compile(" ").splitAsStream(lines[1])
                .mapToInt(Integer::parseInt)
                .filter(i -> i == v)
                .count());
    }
}
