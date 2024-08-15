package org.alan.algorithm.practice.baekjoon.stepbystep.rectangletriangle;

public class BJ27323 {
    public String solve(String input) {
        String[] s = input.split("\n");
        return String.valueOf(Integer.parseInt(s[0]) * Integer.parseInt(s[1]));
    }
}
