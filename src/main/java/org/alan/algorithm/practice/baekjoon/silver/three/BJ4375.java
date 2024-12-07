package org.alan.algorithm.practice.baekjoon.silver.three;

public class BJ4375 {
    public String solve(String input) {
        int i = Integer.parseInt(input), digit = 1, remainder = 1;
        while (remainder % i != 0) {
            remainder = (remainder * 10 + 1) % i;
            digit++;
        }
        return String.valueOf(digit);
    }
}
