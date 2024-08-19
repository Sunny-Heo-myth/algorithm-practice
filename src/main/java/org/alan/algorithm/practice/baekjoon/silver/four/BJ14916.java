package org.alan.algorithm.practice.baekjoon.silver.four;

public class BJ14916 {
    public String solve(String input) {
        int n = Integer.parseInt(input);
        int count = 0;
        while (n > 1 && n % 5 != 0) {
            count++;
            n -= 2;
        }

        count += (n / 5);
        return n % 5 != 0 ? "-1" : String.valueOf(count);
    }
}
