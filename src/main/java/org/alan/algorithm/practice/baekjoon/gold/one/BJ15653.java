package org.alan.algorithm.practice.baekjoon.gold.one;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ15653 {
    private final int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    private char[][] board;
    private int[][][][] shortest;
    private final PriorityQueue<SnapShot> q = new PriorityQueue<>(Comparator.comparingInt(s -> shortest[s.rx][s.ry][s.bx][s.by]));
    private int hx, hy;

    public String solve(String input) {
        board = input.lines().skip(1).map(String::toCharArray).toArray(char[][]::new);
        int m = board.length, n = board[0].length;
        shortest = new int[m][n][m][n];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) for (int k = 0; k < m; k++) for (int l = 0; l < n; l++)
            shortest[i][j][k][l] = Integer.MAX_VALUE;

        int irx = -1, iry = -1, ibx = -1, iby = -1;
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++)
            if (board[i][j] == 'O') { hx = i; hy = j; }
            else if (board[i][j] == 'R') { irx = i; iry = j; }
            else if (board[i][j] == 'B') { ibx = i; iby = j; }

        q.offer(new SnapShot(irx, iry, ibx, iby, 0));
        while (!q.isEmpty()) {
            SnapShot now = q.poll();
            if (now.rx == hx && now.ry == hy) return String.valueOf(now.t);

            for (int dir = 0; dir < 4; dir++)
                if (dx[dir] > 0) offer(now, dir, now.ry == now.by && now.rx > now.bx);
                else if (dx[dir] < 0) offer(now, dir, now.ry == now.by && now.rx < now.bx);
                else if (dy[dir] > 0) offer(now, dir, now.rx == now.bx && now.ry > now.by);
                else offer(now, dir, now.rx == now.bx && now.ry < now.by);
        }
        return "-1";
    }

    private void offer(SnapShot shot, int dir, boolean isRedFirst) {
        int[] r, b;
        if (isRedFirst) {
            r = move(shot.rx, shot.ry, 999, 999, dir);
            b = move(shot.bx, shot.by, r[0], r[1], dir);
        } else {
            b = move(shot.bx, shot.by, 999, 999, dir);
            r = move(shot.rx, shot.ry, b[0], b[1], dir);
        }
        if ((shot.rx == r[0] && shot.ry == r[1] && shot.bx == b[0] && shot.by == b[1])
                || (b[0] == hx && b[1] == hy)
                || shortest[r[0]][r[1]][b[0]][b[1]] <= shot.t + 1) return;
        shortest[r[0]][r[1]][b[0]][b[1]] = shot.t + 1;
        q.offer(new SnapShot(r[0], r[1], b[0], b[1], shot.t + 1));
    }

    private int[] move(int x, int y, int blockX, int blockY, int dir) {
        while (true) {
            x += dx[dir]; y += dy[dir];
            if (x == hx && y == hy) return new int[]{hx, hy};
            else if (board[x][y] == '#' || (x == blockX && y == blockY)) return new int[]{x - dx[dir], y - dy[dir]};
        }
    }

    private static class SnapShot {
        private final int rx, ry, bx, by, t;

        public SnapShot(int rx, int ry, int bx, int by, int t) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.t = t;
        }
    }
}
