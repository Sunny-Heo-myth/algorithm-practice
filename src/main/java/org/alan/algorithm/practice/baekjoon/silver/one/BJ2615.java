package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.regex.Pattern;

public class BJ2615 {
    public String solve(String input) {
        int[] dx = {1, 0, 1, 1}; int[] dy = {0, 1, 1, -1};
        int[][] board = input.lines().map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);

        for (int x = 0; x < 19; x++) point: for (int y = 0; y < 19; y++) {
            if (board[x][y] == 0) continue;

            direction: for (int d = 0; d < 3; d++) {
                for (int n = 1; n < 5; n++) {
                    int nx = x + dx[d] * n; int ny = y + dy[d] * n;
                    if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19 || board[nx][ny] != board[x][y]) continue direction;
                }
                int x6 = x + dx[d] * 5; int y6 = y + dy[d] * 5;
                int xm = x + dx[d] * -1; int ym = y + dy[d] * -1;
                if ((x6 >= 19 || y6 >= 19 || board[x6][y6] != board[x][y])
                        && (xm < 0 || ym < 0 || board[xm][ym] != board[x][y]))
                    return board[x][y] + "\n" + (x + 1) + " " + (y + 1);
            }

            for (int n = 1; n < 5; n++) {
                int nx = x + dx[3] * n; int ny = y + dy[3] * n;
                if (nx >= 19 || ny < 0 || board[nx][ny] != board[x][y]) continue point;
            }
            int x6 = x + dx[3] * 5; int y6 = y + dy[3] * 5;
            int xm = x + dx[3] * -1; int ym = y + dy[3] * -1;
            if ((x6 >= 19 || y6 < 0 || board[x6][y6] != board[x][y])
                    && (xm < 0 || ym >= 19 || board[xm][ym] != board[x][y]))
                return board[x][y] + "\n" + (x + 5) + " " + (y - 3);
        }

        return "0";
    }
}
