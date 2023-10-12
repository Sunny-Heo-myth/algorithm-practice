package org.alan.algorithm.practice.baekjoon.level.three;

public class BJ2630 {
    private boolean[][] square;
    private int one = 0;
    private int zero = 0;

    public String solve(String input) {
        String[] s = input.split("\n");
        int n = Integer.parseInt(s[0]);

        square = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] ss = s[i + 1].split(" ");
            for (int j = 0; j < ss.length; j++) if (ss[j].equals("1")) square[i][j] = true;
        }

        recursive(0, 0, n);
        return zero + "\n" + one;
    }

    // get input as x, y, length
    private void recursive(int x, int y, int length) {
        if (length == 1) {
            if (square[x][y]) one++;
            else zero++;
            return;
        }

        // if color is same, increment the color and return
        boolean splitFlag = false;
        boolean first = square[x][y];

        loop:
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (first != square[i][j]) {
                    splitFlag = true;
                    break loop;
                }
            }
        }

        if (!splitFlag) {
            if (first) one++;
            else zero++;
            return;
        }

        int half = length / 2;
        recursive(x, y, half);
        recursive(x, y + half, half);
        recursive(x + half, y, half);
        recursive(x + half, y + half, half);
    }
}
