package org.alan.algorithm.practice.baekjoon.stepbystep.string;

import java.util.regex.Pattern;

public class BJ2457 {
    public String solve(String input) {
        int[][] flowers = input.lines().skip(1).map(s -> {
            int[] startEnd = Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray();
            return new int[]{startEnd[0] * 100 + startEnd[1], startEnd[2] * 100 + startEnd[3]};
        }).sorted((f1, f2) -> f1[0] != f2[0] ? f1[0] - f2[0] : f2[1] - f1[1]).toArray(int[][]::new);

        int now = 301, i = 0, end = 0, count = 0;
        while (now <= 1130) {
            boolean found = false;
            while (i < flowers.length && flowers[i][0] <= now) {
                if (flowers[i][1] > end) {
                    end = flowers[i][1];
                    found = true;
                }
                i++;
            }

            if (!found) return "0";
            now = end;
            count++;
        }
        return String.valueOf(count);
    }
}
