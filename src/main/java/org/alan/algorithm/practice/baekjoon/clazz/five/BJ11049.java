package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.regex.Pattern;

public class BJ11049 {
    public String solve(String input) {
        int[][] rc = input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);

        int[][] memo = new int[rc.length][rc.length];
        return null;
    }
}
