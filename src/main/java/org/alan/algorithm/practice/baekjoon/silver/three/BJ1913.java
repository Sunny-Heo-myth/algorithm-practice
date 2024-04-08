package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BJ1913 {
    private int x = 0;
    private int y = 0;
    private int t;

    public String solve(String input) {
        String[] s = input.split("\n");
        int n = Integer.parseInt(s[0]);
        int half = n / 2;
        t = Integer.parseInt(s[1]);

        int m = 1;
        int[][] array = new int[n][n];
        for (int i = 0; i <= half; i++) {
            int bic = m * m;
            int xy = half - i;
            array[xy][xy] = bic;
            check(bic--, xy, xy);

            for (int j = 1; j < m; j++) {
                int x = xy + j;
                array[x][xy] = bic;
                check(bic--, x, xy);
            }
            for (int j = 1; j < m; j++) {
                int x = xy + m - 1;
                int y = xy + j;
                array[x][y] = bic;
                check(bic--, x, y);
            }
            for (int j = 1; j < m; j++) {
                int y = xy + m - 1;
                array[y - j][y] = bic;
                check(bic--, y - j, y);
            }
            for (int j = 1; j < m - 1; j++) {
                int y = xy + m - 1 - j;
                array[xy][y] = bic;
                check(bic--, xy, y);
            }

            m += 2;
        }

        return Arrays.stream(array).map(ints ->
                        Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n")) + "\n" + x + " " + y;
    }

    private void check(int bic, int i, int j) {
        if (bic != t) return;
        x = i + 1;
        y = j + 1;
    }
}