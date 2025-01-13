package org.alan.algorithm.practice.baekjoon.stepbystep.dynamic;

public class BJ9656 {
    public String solve(String input) {
        int n = Integer.parseInt(input);
        boolean[] memo = new boolean[n + 1];
        if (n >= 2) memo[2] = true;
        for (int i = 4; i <= n; i++) memo[i] = !memo[i - 1] || !memo[i - 3];
        return memo[n] ? "SK" : "CY";
    }
}
