package org.alan.algorithm.practice.baekjoon.stepbystep.setandmapstep;

public class BJ19532 {
    public String solve(String input) {
        String[] s = input.split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);
        int d = Integer.parseInt(s[3]);
        int e = Integer.parseInt(s[4]);
        int f = Integer.parseInt(s[5]);

        int x;
        int y = 0;
        outer:
        for (x = -999; x <= 999; x++) {
            for (y = -999; y <= 999; y++) {
                if (a*x + b*y == c && d*x + e*y == f) {
                    break outer;
                }
            }
        }

        return x + " " + y;
    }
}
