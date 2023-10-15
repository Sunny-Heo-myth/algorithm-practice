package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import java.util.Arrays;

public class BJ1541 {
    private final String MINUS = "-";
    private final char PLUS = '+';

    public String solve(String input) {
        String[] s = input.split(MINUS);
        int result = parse2(s[0]);
        for (int i = 1; i < s.length; i++) result -= parse2(s[i]);
        return String.valueOf(result);
    }

    private int parse(String chunk) {
        chunk += PLUS;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : chunk.toCharArray())
            if (c == PLUS) {
                sum += Integer.parseInt(sb.toString());
                sb = new StringBuilder();
            }
            else sb.append(c);
        return sum;
    }

    private int parse2(String chunk) {
        return Arrays.stream(chunk.split("\\+")).mapToInt(Integer::parseInt).sum();
    }

}
