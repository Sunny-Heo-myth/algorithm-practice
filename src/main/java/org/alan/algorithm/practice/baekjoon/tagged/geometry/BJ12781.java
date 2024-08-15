package org.alan.algorithm.practice.baekjoon.tagged.geometry;

import java.util.regex.Pattern;

public class BJ12781 {
    public String solve(String input) {
        int[] ints = Pattern.compile(" ").splitAsStream(input).mapToInt(Integer::parseInt).toArray();
        int x1 = ints[0], y1 = ints[1], x2 = ints[2], y2 = ints[3], x3 = ints[4], y3 = ints[5], x4 = ints[6], y4 = ints[7];
        return ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) < 0 &&
                ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) < 0 ? "1" : "0";
    }

    private int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Integer.compare((x1 * y2 + x2 * y3 + x3 * y1) - (x1 * y3 + x3 * y2 + x2 * y1), 0);
    }
}
