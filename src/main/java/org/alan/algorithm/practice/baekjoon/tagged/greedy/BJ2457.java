package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import java.util.regex.Pattern;

public class BJ2457 {
    private final int[][] flowers;

    public BJ2457(String input) {
        flowers = input.lines().skip(1)
                .map(s -> {
                    int[] arr = Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray();
                    return new int[]{arr[0] * 100 + arr[1], arr[2] * 100 + arr[3]};
                })
                .sorted((f1, f2) -> f1[0] != f2[0] ? f1[0] - f2[0] : f2[1] - f1[1])
                .dropWhile(f -> f[1] < 301)
                .toArray(int[][]::new);
    }

    public String solve() {
        int i = 0, count = 0, reach = 301, currentReach = 0;
        while (reach <= 1130) {
            boolean reachFurther = false;
            while (i < flowers.length && flowers[i][0] <= reach) {
                if (flowers[i][1] > currentReach) {
                    reachFurther = true;
                    currentReach = flowers[i][1];
                }
                i++;
            }

            if (!reachFurther) return "0";
            count++;
            reach = currentReach;
        }
        return String.valueOf(count);
    }
}