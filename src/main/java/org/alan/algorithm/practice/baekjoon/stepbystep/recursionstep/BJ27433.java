package org.alan.algorithm.practice.baekjoon.stepbystep.recursionstep;

public class BJ27433 {
    public String solve(String input) {
        long n = Long.parseLong(input);
        long result = factorial(n);
        return String.valueOf(result);
    }

    private long factorial(long n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
