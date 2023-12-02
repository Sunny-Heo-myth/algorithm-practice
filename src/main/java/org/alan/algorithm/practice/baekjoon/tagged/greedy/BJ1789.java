package org.alan.algorithm.practice.baekjoon.tagged.greedy;

public class BJ1789 {
    public String solve(String input) {
        long n = Long.parseLong(input);
        long i = 1;
        while (n >= 0) n -= i++;
        return String.valueOf(i - 2);
    }
}
