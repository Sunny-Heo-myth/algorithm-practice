package org.alan.algorithm.practice.baekjoon.problem;

public class BJ9659 {
    public String solve(String input) {
        return Long.parseLong(input) % 2 == 0 ? "CY" : "SK";
    }
}
