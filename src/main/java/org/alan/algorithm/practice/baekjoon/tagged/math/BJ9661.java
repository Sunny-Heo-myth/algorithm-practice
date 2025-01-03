package org.alan.algorithm.practice.baekjoon.tagged.math;

public class BJ9661 {
    public String solve(String input) {
        long remainder = Long.parseLong(input) % 5;
        return (remainder == 2 || remainder == 0) ? "CY" : "SK";
    }
}
