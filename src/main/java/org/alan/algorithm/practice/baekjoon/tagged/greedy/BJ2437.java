package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import java.util.regex.Pattern;

public class BJ2437 {
    public String solve(String input) {
        long[] weights = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToLong(Long::parseLong).sorted().toArray();

        long sum = 0;   // maximum weight that can be created CONTINUOUSLY
        for (long weight : weights) {
            if (weight > sum + 1) break;
            sum += weight;
        }
        return String.valueOf(sum + 1);
    }
}
