package org.alan.algorithm.practice.baekjoon.stepbystep.timecomplexity;

public class BJ24267 {
    public String solve(String input) {
        long l = Long.parseLong(input) - 2;
        return ((l * l * l) + (l * l * 3) + (l * 2)) / 6 + "\n3";
    }
}
