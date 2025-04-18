package org.alan.algorithm.practice.baekjoon.stepbystep.dynamic;

public class BJ9658 {
    public String solve(String input) {
        int n = Integer.parseInt(input);
        boolean[] memo = new boolean[n + 1];    // SK가 이기면 true, CY가 이기면 false.
        if (n >= 2) memo[2] = true;
        if (n >= 4) memo[4] = true;
        for (int i = 5; i <= n; i++) memo[i] = !memo[i - 1] || !memo[i - 3] || !memo[i - 4];
        return memo[n] ? "SK" : "CY";
    }
}
