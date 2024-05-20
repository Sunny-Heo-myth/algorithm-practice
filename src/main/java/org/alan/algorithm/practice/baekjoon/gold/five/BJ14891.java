package org.alan.algorithm.practice.baekjoon.gold.five;

import java.util.regex.Pattern;

public class BJ14891 {
    public String solve(String input) {
        int[][] gears = input.lines().limit(4).map(s -> s.chars().map(ch -> ch - '0').toArray()).toArray(int[][]::new);
        int[][] ops = input.lines().skip(5).map(s -> Pattern.compile(" ")
                .splitAsStream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);

        for (int[] op : ops) {
            int t = op[0] - 1; int w = op[1]; int base;
            int two = gears[t][2]; int six = gears[t][6];
            rotate(gears[t], w);

            base = two; int rw = w;
            for (int rt = t + 1; rt < gears.length; rt++) {
                if (base == gears[rt][6]) break;
                base = gears[rt][2];
                rotate(gears[rt], rw *= -1);
            }

            base = six; int lw = w;
            for (int lt = t - 1; lt >= 0; lt--) {
                if (base == gears[lt][2]) break;
                base = gears[lt][6];
                rotate(gears[lt], lw *= -1);
            }
        }
        return String.valueOf((gears[0][0] == 0 ? 0 : 1)
                + (gears[1][0] == 0 ? 0 : 2)
                + (gears[2][0] == 0 ? 0 : 4)
                + (gears[3][0] == 0 ? 0 : 8));
    }

    private void rotate(int[] t, int wise) {
        if (wise == 1) {
            int seven = t[7];
            for (int i = 6; i >= 0; i--) t[i + 1] = t[i];
            t[0] = seven;
        } else {
            int zero = t[0];
            for (int i = 0; i < 7; i++) t[i] = t[i + 1];
            t[7] = zero;
        }
    }

}
