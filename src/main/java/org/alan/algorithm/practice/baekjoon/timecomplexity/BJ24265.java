package org.alan.algorithm.practice.baekjoon.timecomplexity;

public class BJ24265 {

    public String solve(String input) {
        int i = Integer.parseInt(input);
        return ((long) i * (i - 1) / 2) + "\n2";
    }
}
