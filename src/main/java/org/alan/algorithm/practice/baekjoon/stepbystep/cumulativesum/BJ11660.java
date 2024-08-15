package org.alan.algorithm.practice.baekjoon.stepbystep.cumulativesum;

import java.util.Arrays;

public class BJ11660 {
    public String solve(String input) {
        String[] s = input.split("\n");
        String[] firstLine = s[0].split(" ");
        int n = Integer.parseInt(firstLine[0]) + 1;

        int[][] array = new int[n][n];
        for (int i = 1; i < n; i++) array[i] = Arrays.stream(("0 " + s[i]).split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i < n; i++) for (int j = 1; j < n; j++) array[i][j] += array[i][j - 1];
        for (int j = 1; j < n; j++) for (int i = 1; i < n; i++) array[j][i] += array[j - 1][i];

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(firstLine[1]);
        for (int i = n; i < n + m; i++) {
            int[] xy = Arrays.stream(s[i].split(" ")).mapToInt(Integer::parseInt).toArray();
            int sx = xy[0] - 1;
            int sy = xy[1] - 1;
            int bx = xy[2];
            int by = xy[3];
            sb.append(array[bx][by] - (array[bx][sy] + array[sx][by] - array[sx][sy])).append("\n");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
