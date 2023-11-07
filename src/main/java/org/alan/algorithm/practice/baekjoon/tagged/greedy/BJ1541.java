package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import java.util.Arrays;

public class BJ1541 {

    public String solve(String input) {
        String MINUS = "-";
        String[] s = input.split(MINUS);
        int result = parse(s[0]);
        for (int i = 1; i < s.length; i++) result -= parse(s[i]);
        return String.valueOf(result);
    }

    private int parse(String chunk) {
        return Arrays.stream(chunk.split("\\+")).mapToInt(Integer::parseInt).sum();
    }

}
