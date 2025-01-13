package org.alan.algorithm.practice.baekjoon.stepbystep.geometry;

import java.util.regex.Pattern;

public class BJ17386 {
    public String solve(String input) {
        int[][] n = input.lines().map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        int x1 = n[0][0], x2 = n[0][2], x3 = n[1][0], x4 = n[1][2];
        int y1 = n[0][1], y2 = n[0][3], y3 = n[1][1], y4 = n[1][3];

        if (Math.max(x1, x2) <= Math.min(x3, x4) || Math.min(x1, x2) >= Math.max(x3, x4)
                || Math.max(y1, y2) <= Math.min(y3, y4) || Math.min(y1, y2) >= Math.max(y3, y4)) return "0";

        double slope1 = (double) (y2 - y1) / (double) (x2 - x1);
        double slope2 = (double) (y4 - y3) / (double) (x4 - x3);
        if (slope1 == slope2) return "0";

        if (x1 < x2) {
            if (x3 < x4) return y3 > y1 ? "1" : "0";
            if (x3 > x4) return y4 > y1 ? "1" : "0";
        }
        if (x1 > x2) {
            if (x3 < x4) return y3 > y2 ? "1" : "0";
            if (x3 > x4) return y4 > y2 ? "1" : "0";
        }
        return "0";
    }

    public String solve2(String input) {
        int[][] n = input.lines().map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        int x1 = n[0][0], x2 = n[0][2], x3 = n[1][0], x4 = n[1][2];
        int y1 = n[0][1], y2 = n[0][3], y3 = n[1][1], y4 = n[1][3];

        return ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) < 0 &&
                ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) < 0 ? "1" : "0";
    }

    public int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        return x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1 < 0 ? 1 : -1;
    }
}
