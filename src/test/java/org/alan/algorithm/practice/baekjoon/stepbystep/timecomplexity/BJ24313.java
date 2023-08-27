package org.alan.algorithm.practice.baekjoon.stepbystep.timecomplexity;

public class BJ24313 {
    public String solve(String input) {
        String[] s = input.split("\n");
        String[] firstLine = s[0].split(" ");
        int x = Integer.parseInt(firstLine[0]);
        int y = Integer.parseInt(firstLine[1]);
        int c = Integer.parseInt(s[1]);
        int n0 = Integer.parseInt(s[2]);

        if (f(x, y, n0) <= c * n0) {
            return "1";
        } else {
            return "0";
        }
    }

    private int f(int x, int y, int n0) {
        return n0 * x + y;
    }
}
