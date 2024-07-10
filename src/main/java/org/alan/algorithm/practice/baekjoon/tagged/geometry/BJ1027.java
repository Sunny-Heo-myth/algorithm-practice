package org.alan.algorithm.practice.baekjoon.tagged.geometry;

import java.util.regex.Pattern;

public class BJ1027 {
    public String solve(String input) {
        double[] buildings = input.lines().skip(1).flatMapToDouble(s ->
                Pattern.compile(" ").splitAsStream(s).mapToDouble(Double::parseDouble)).toArray();
        if (buildings.length < 3) return String.valueOf(buildings.length - 1);

        int max = 0;
        for (int t = 0; t < buildings.length; t++) {
            int lMax = 0;
            int cMax = 0;
            double now = Double.NEGATIVE_INFINITY;
            for (int i = 0; i < t; i++) {
                double next = (buildings[t] - buildings[i]) / (t - i);
                if (next > now) cMax++;
                else {
                    lMax = Math.max(lMax, cMax);
                    cMax = 0;
                }
                now = next;
            }

            int rMax = 0;
            cMax = 0;
            now = Double.NEGATIVE_INFINITY;
            for (int i = t + 1; i < buildings.length; i++) {
                double next = (buildings[i] - buildings[t]) / (i - t);
                if (next > now) cMax++;
                else {
                    rMax = Math.max(rMax, cMax);
                    cMax = 0;
                }
                now = next;
            }

            max = Math.max(lMax + rMax, max);
        }
        return String.valueOf(max);
    }
}
