package org.alan.algorithm.practice.baekjoon.clazz.two;

public class BJ15829 {
    public String solve(String input) {
        char[] chars = input.split("\n")[1].toCharArray();
        long sum = 0;
        long power = 1;
        long divisor = 1234567891;
        for (char aChar : chars) {
            sum += (aChar - 96) * power;
            power = (power * 31) % divisor;
        }

        return String.valueOf(sum % divisor);
    }
}
