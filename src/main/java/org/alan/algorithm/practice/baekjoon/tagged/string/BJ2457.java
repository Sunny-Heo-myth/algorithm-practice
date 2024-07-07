package org.alan.algorithm.practice.baekjoon.tagged.string;

import java.util.regex.Pattern;

public class BJ2457 {
    public String solve(String input) {
        int[][] flowers = input.lines().skip(1)
                .map(s -> {
                    int[] fromTo = Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray();
                    return new int[]{fromTo[0] * 100 + fromTo[1], fromTo[2] * 100 + fromTo[3]};
                })
                .sorted((flower1, flower2) -> flower1[0] == flower2[0] ? flower2[1] - flower1[1] : flower1[0] - flower2[0])
                .toArray(int[][]::new);

        int now = 301, end = 1130;
        int idx = 0, nowEnd = 0, count = 0;
        while (now <= end) {
            boolean found = false;
            while (idx < flowers.length && flowers[idx][0] <= now) {
                if (flowers[idx][1] > nowEnd) {
                    nowEnd = flowers[idx][1];
                    found = true;
                }
                idx++;
            }
            if (!found) return "0";

            count++;
            now = nowEnd;
        }
        return String.valueOf(count);
    }
}
