package org.alan.algorithm.practice.baekjoon.stepbystep.math.one;

public class BJ2745 {
    public int solve(String input) {
        String[] strings = input.split(" ");
        int base = Integer.parseInt(strings[1]);
        String number = strings[0];
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            double pow = Math.pow(base, number.length() - 1 - i);
            if (digit >= 65) {
                sum += (digit - 55) * pow;
            } else {
                sum += (digit - 48) * pow;
            }

        }
        return sum;
    }

}
