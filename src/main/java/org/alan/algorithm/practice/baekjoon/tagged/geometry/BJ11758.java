package org.alan.algorithm.practice.baekjoon.tagged.geometry;

import java.util.regex.Pattern;

public class BJ11758 {
    public String solve(String input) {
        int[][] c = Pattern.compile("\n").splitAsStream(input)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);

        return String.valueOf(Integer.compare(
                c[0][0] * c[1][1] + c[1][0] * c[2][1] + c[2][0] * c[0][1],
                c[0][0] * c[2][1] + c[2][0] * c[1][1] + c[1][0] * c[0][1]
        ));
    }
}
