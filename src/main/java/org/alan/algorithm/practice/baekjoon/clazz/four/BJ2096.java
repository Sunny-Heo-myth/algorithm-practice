package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.Arrays;
import java.util.regex.Pattern;

public class BJ2096 {
    public String solve(String input) {
        int[][] pillow = Pattern.compile("\n").splitAsStream(input).skip(1)
                .map(s -> Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);

        int[] max = new int[3];
        int[] min = new int[3];
        max[0] = min[0] = pillow[0][0];
        max[1] = min[1] = pillow[0][1];
        max[2] = min[2] = pillow[0][2];

        for (int i = 1; i < pillow.length; i++) {
            int maxTemp0 = max[0];
            int maxTemp2 = max[2];
            max[0] = Math.max(max[0], max[1]) + pillow[i][0];
            max[2] = Math.max(max[1], max[2]) + pillow[i][2];
            max[1] = Math.max(Math.max(maxTemp0, max[1]), maxTemp2) + pillow[i][1];

            int minTemp0 = min[0];
            int minTemp2 = min[2];
            min[0] = Math.min(min[0], min[1]) + pillow[i][0];
            min[2] = Math.min(min[1], min[2]) + pillow[i][2];
            min[1] = Math.min(Math.min(minTemp0, min[1]), minTemp2) + pillow[i][1];
        }
        return Arrays.stream(max).max().orElse(0) + " " + Arrays.stream(min).min().orElse(0);
    }
}
