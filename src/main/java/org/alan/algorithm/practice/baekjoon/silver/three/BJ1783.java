package org.alan.algorithm.practice.baekjoon.silver.three;

public class BJ1783 {
    public String solve(String input) {
        String[] s = input.split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        if (N == 1) return "1";
        if (N == 2) return String.valueOf(Math.min((M + 1) / 2, 4));
        if (M < 7) return String.valueOf(Math.min(M , 4));
        return String.valueOf(M - 2);
    }
}
