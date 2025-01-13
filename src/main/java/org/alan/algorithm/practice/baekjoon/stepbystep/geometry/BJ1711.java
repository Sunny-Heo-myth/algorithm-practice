package org.alan.algorithm.practice.baekjoon.stepbystep.geometry;

import java.util.regex.Pattern;

public class BJ1711 {
    public String solve(String input) {
        long[][] dots = input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToLong(Long::parseLong).toArray()).toArray(long[][]::new);

        long answer = 0;
        for (int i = 0; i < dots.length; i++) for (int j = i + 1; j < dots.length; j++) for (int k = j + 1; k < dots.length; k++) {
            long x1 = dots[i][0], y1 = dots[i][1], x2 = dots[j][0], y2 = dots[j][1], x3 = dots[k][0], y3 = dots[k][1];
            long d1 = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
            long d2 = (x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3);
            long d3 = (x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3);
            if (d1 + d2 == d3 || d1 + d3 == d2 || d2 + d3 == d1) answer++;
        }
        return String.valueOf(answer);
    }
}
