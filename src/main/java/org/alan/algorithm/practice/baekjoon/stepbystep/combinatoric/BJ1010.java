package org.alan.algorithm.practice.baekjoon.stepbystep.combinatoric;

public class BJ1010 {
    public String solve(String input) {
        String[] s = input.split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int result = 1;
        for (int x = m; x > m - n; x--) {
            result *= x;
            result /= (m + 1 - x);
        }
        return String.valueOf(result);
    }
}
