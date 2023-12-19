package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ20529 {
    private String[] s;
    public String solve(String input) {
        s = input.lines().skip(1).flatMap(ss -> Pattern.compile(" ").splitAsStream(ss)).sorted().toArray(String[]::new);
        if (s.length > 32) return "0";

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length; i++) for (int j = i + 1; j < s.length; j++) for (int k = j + 1; k < s.length; k++)
            min = Math.min(min, getDistance(i, j ,k));
        return String.valueOf(min);
    }

    private int getDistance(int i, int j, int k) {
        return IntStream.range(0, 4).map(n ->
                (s[i].charAt(n) == s[j].charAt(n) ? 0 : 1) + (s[j].charAt(n) == s[k].charAt(n) ? 0 : 1) + (s[k].charAt(n) == s[i].charAt(n) ? 0 : 1)).sum();
    }
}
