package org.alan.algorithm.practice.baekjoon.stepbystep.timecomplexitystep;

public class BJ24313 {
    public String solve(String input) {
        String[] s = input.split("\n");
        String[] firstLine = s[0].split(" ");
        int x = Integer.parseInt(firstLine[0]);
        int y = Integer.parseInt(firstLine[1]);
        int c = Integer.parseInt(s[1]);
        int n0 = Integer.parseInt(s[2]);

        // If n0 is infinitely bigger than x, then the answer is always 1 even though c is smaller than x.
        return f(x, y, n0) <= c * n0 && c >= x ? "1" : "0";
    }

    private int f(int x, int y, int n0) {
        return n0 * x + y;
    }
}
