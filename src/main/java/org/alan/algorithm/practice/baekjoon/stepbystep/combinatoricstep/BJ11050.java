package org.alan.algorithm.practice.baekjoon.stepbystep.combinatoricstep;

public class BJ11050 {
    public String solve(String input) {
        String[] s = input.split(" ");
        int x = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int result  = 1;
        for (int i = x; i > x - n; i--) {
            result *= i;
        }
        for (int i = 1; i <= n; i++) {
            result /= i;
        }
        return String.valueOf(result);
    }
}
