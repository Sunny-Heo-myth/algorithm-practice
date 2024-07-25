package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.regex.Pattern;

public class BJ17387 {
    public String solve(String input) {
        int[][] seg = input.lines().map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        int x1 = seg[0][0], x2 = seg[0][2], x3 = seg[1][0], x4 = seg[1][2];
        int y1 = seg[0][1], y2 = seg[0][3], y3 = seg[1][1], y4 = seg[1][3];

        int f1 = ccw(x1, y1, x2, y2, x3, y3), f2 = ccw(x1, y1, x2, y2, x4, y4);
        int f3 = ccw(x3, y3, x4, y4, x1, y1), f4 = ccw(x3, y3, x4, y4, x2, y2);
        boolean cx1 = Math.min(x1, x2) <= Math.max(x3, x4), cx2 = Math.min(x3, x4) <= Math.max(x1, x2);
        boolean cy1 = Math.min(y1, y2) <= Math.max(y3, y4), cy2 = Math.min(y3, y4) <= Math.max(y1, y2);

        boolean allInLine = false;
        if (f1 * f2 == 0 && f3 * f4 == 0) {
            allInLine = true;
            if (cx1 && cx2 && cy1 && cy2) return "1";
        }

        if (f1 * f2 <= 0 && f3 * f4 <= 0 && !allInLine) return "1";
        else return "0";
    }

    public int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long value = x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1;
        if (value < 0) return 1;
        else if (value == 0) return 0;
        else return -1;
    }
}
