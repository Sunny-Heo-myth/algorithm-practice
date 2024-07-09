package org.alan.algorithm.practice.baekjoon.tagged.geometry;

import java.util.regex.Pattern;

public class BJ1027 {
    public String solve(String input) {
        double[] buildings = input.lines().skip(1).flatMapToDouble(s ->
                Pattern.compile(" ").splitAsStream(s).mapToDouble(Double::parseDouble)).toArray();
        if (buildings.length < 3) return String.valueOf(buildings.length - 1);

        int max = 0;
        double[] slopes = new double[buildings.length];
        for (int t = 0; t < buildings.length; t++) {
            int cMax = 0;
            double now = (buildings[0] - buildings[t]) / -t;
            boolean increasing = now > 0;
            for (int i = 1; i < t; i++) {
                double next = (buildings[i] - buildings[t]) / -t;
                if (increasing) {

                }

                if (next > )
            }

//            now
            for (int i = t + 2; i < buildings.length; i++) {

            }

            max = Math.max(max, cMax);
        }
        return String.valueOf(max);
    }
}
