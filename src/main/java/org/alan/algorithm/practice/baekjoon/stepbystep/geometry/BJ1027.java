package org.alan.algorithm.practice.baekjoon.stepbystep.geometry;

import java.util.regex.Pattern;

public class BJ1027 {
    public String solve(String input) {
        double[] buildings = input.lines().skip(1).flatMapToDouble(s ->
                Pattern.compile(" ").splitAsStream(s).mapToDouble(Double::parseDouble)).toArray();
        if (buildings.length < 3) return String.valueOf(buildings.length - 1);

        int max = 0;
        for (int t = 0; t < buildings.length; t++) {
            int lCount = 0;
            double now = Double.POSITIVE_INFINITY;
            for (int i = t - 1; i >= 0; i--) {
                double next = (buildings[i] - buildings[t]) / (i - t);
                if (next >= now) continue;
                lCount++;
                now = next;
            }

            int rCount = 0;
            now = Double.NEGATIVE_INFINITY;
            for (int i = t + 1; i < buildings.length; i++) {
                double next = (buildings[i] - buildings[t]) / (i - t);
                if (next <= now) continue;
                rCount++;
                now = next;
            }

            max = Math.max(lCount + rCount, max);
        }
        return String.valueOf(max);
    }
}
