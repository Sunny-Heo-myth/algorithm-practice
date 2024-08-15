package org.alan.algorithm.practice.baekjoon.stepbystep.math.one;

public class BJ2903 {
    public String solve(String input) {
        int count = Integer.parseInt(input);
        if (count < 1 || count > 15) {
            throw new IllegalArgumentException();
        }

        int length = 2;
        for (int i = 0; i < count; i++) {
            length += Math.pow(2, i);
        }
        return String.valueOf((int) Math.pow(length, 2));
    }
}
