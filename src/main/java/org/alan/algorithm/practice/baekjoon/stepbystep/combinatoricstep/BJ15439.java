package org.alan.algorithm.practice.baekjoon.stepbystep.combinatoricstep;

public class BJ15439 {
    public String solve(String input) {
        int n = Integer.parseInt(input);
        return String.valueOf(n * (n - 1));
    }
}
