package org.alan.algorithm.practice.baekjoon.stepbystep.deepstep.one;

public class BJ10988 {
    public int solve(String input) {
        int length = input.length();
        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - i - 1)) {
                return 0;
            }
        }
        return 1;
    }
}
