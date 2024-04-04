package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ1431 {

    public String solve(String input) {
        return Pattern.compile("\n").splitAsStream(input).skip(1).sorted((s, t) -> {
            if (s.length() != t.length()) return s.length() - t.length();
            long tSum = t.chars().filter(i -> i < 65).map(i -> i - '0').sum();
            long sSum = s.chars().filter(i -> i < 65).map(i -> i - '0').sum();
            if (tSum != sSum) return Math.toIntExact(sSum - tSum);
            return s.compareTo(t);
        }).collect(Collectors.joining("\n"));
    }
}
