package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import java.util.regex.Pattern;

public class BJ13305 {
    public String solve(String input) {
        String[] s = input.split("\n");
        long[] distances = Pattern.compile(" ").splitAsStream(s[1] + " 0").mapToLong(Long::parseLong).toArray();
        long[] cities = Pattern.compile(" ").splitAsStream(s[2] + " 0").mapToLong(Long::parseLong).toArray();

        long total = 0;
        long cheapest = cities[0];
        long cumulatedDistance = 0;
        for (int i = 1; i < cities.length; i++) {
            cumulatedDistance += distances[i - 1];
            if (cheapest > cities[i]) {
                total += cumulatedDistance * cheapest;
                cheapest = cities[i];
                cumulatedDistance = 0;
            }
        }
        return String.valueOf(total);
    }
}
