package org.alan.algorithm.practice.baekjoon.tagged.geometry;

import java.util.regex.Pattern;
import java.util.stream.DoubleStream;

public class BJ1069 {
    public String solve(String input) {
        int[] nmdt = Pattern.compile(" ").splitAsStream(input).mapToInt(Integer::parseInt).toArray();
        int n = nmdt[0], m = nmdt[1], d = nmdt[2], t = nmdt[3];

        double length = Math.sqrt(n * n + m* m), walkT, jumpWalkT, jumpJumpT;
        walkT = length;
        if (length >= d) {
            int jumpCount = (int) (length / d);
            jumpWalkT = jumpCount * t + (length - jumpCount * d);
            jumpJumpT = t * (jumpCount + 1);
        } else {
            jumpWalkT = t + (d - length);
            jumpJumpT = t * 2;
        }
        return String.valueOf(DoubleStream.of(walkT, jumpWalkT, jumpJumpT).min().orElse(-1));
    }
}
