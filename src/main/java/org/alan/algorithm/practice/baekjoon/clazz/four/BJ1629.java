package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.Arrays;

/*
(a * b) % c = (a % c * b % c) % c
 */
public class BJ1629 {
    private long base = 0;
    private long divisor = 0;
    public String solve(String input) {
        long[] longs = Arrays.stream(input.split(" ")).mapToLong(Long::parseLong).toArray();
        base = longs[0];
        if (base == divisor) return "0";
        if (base == 1 && divisor > 1) return "1";

        long power = longs[1];
        divisor = longs[2];
        return String.valueOf(recur(power));
    }

    private long recur(long power) {
        if (power == 1) return base;
        long half = recur(power / 2);
        if (power % 2 == 0) return (half % divisor * half % divisor) % divisor;
        else return ((half * half) % divisor * (base % divisor)) % divisor;
    }
}
