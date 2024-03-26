package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ1024 {

    public String solve(String input) {
        String[] s = input.split(" ");
        int N = Integer.parseInt(s[0]); int L = Integer.parseInt(s[1]);

        int dividend;
        int half;
        int startInclusive;
        int sum = 0;

        while (L <= 100 && sum <= 1000_000_000) {
            dividend = N / L;
            half = L / 2;
            startInclusive = dividend - half;

            sum = IntStream.range(startInclusive, startInclusive + L).sum();
            if ((N - sum) % L != 0) {
                L++;
                continue;
            }

            startInclusive += ((N - sum) / L);
            if (startInclusive < 0) return "-1";

            return IntStream.range(startInclusive, startInclusive + L).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        }

        return "-1";
    }
}
