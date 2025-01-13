package org.alan.algorithm.practice.baekjoon.stepbystep.dynamic;

public class BJ9657 {
    public String solve(String input) {
        int n = Integer.parseInt(input);
        boolean[] memo = new boolean[n + 1];    // whoever it is, winning or losing has been determined with remaining n stones
        memo[1] = true;
        if (n >= 2) memo[2] = false;
        if (n >= 3) memo[3] = true;
        if (n >= 4) memo[4] = true;

        for (int i = 5; i <= n; i++) memo[i] = !memo[i - 1] || !memo[i - 3] || !memo[i - 4];
        return memo[n] ? "SK" : "CY";
    }
}
