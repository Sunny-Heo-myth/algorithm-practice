package org.alan.algorithm.practice.baekjoon.tagged.dynamic;

public class BJ1788 {
    public String solve(String input) {
        int n = Integer.parseInt(input);
        if (n == 0) return """
                0
                0""";

        int abs = Math.abs(n);
        int[] memo = new int[abs + 1]; memo[1] = 1;
        for (int i = 2; i <= abs; i++) memo[i] = (memo[i - 1] + memo[i - 2]) % 1_000_000_000;

        return (n < 0 && abs % 2 == 0 ? "-1" : "1") + "\n" + memo[abs];
    }
}
