package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.LinkedList;
import java.util.Queue;

public class BJ13460 {
    private char[][] board;
    private final Queue<int[]> q = new LinkedList<>();
    private int hx, hy;

    public String solve(String input) {
        int[] dxArr = {1, -1, 0, 0}, dyArr = {0, 0, -1, 1};
        board = input.lines().skip(1).map(String::toCharArray).toArray(char[][]::new);
        int m = board.length, n = board[0].length;

        int irx = -1, iry = -1, ibx = -1, iby = -1; hx = -1; hy = -1;
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            if (board[i][j] == 'R') { irx = i; iry = j; }
            else if (board[i][j] == 'B') { ibx = i; iby = j; }
            else if (board[i][j] == 'O') { hx = i; hy = j; }
        }
        q.offer(new int[]{irx, iry, ibx, iby, 0});

        while (!q.isEmpty()) {
            int[] popped = q.poll();
            int rx = popped[0], ry = popped[1], bx = popped[2], by = popped[3], t = popped[4];
            if (t > 10) return "-1";
            if (rx == hx && ry == hy && !(bx == hx && by == hy)) return String.valueOf(t);

            for (int i = 0; i < 4; i++) {
                int dx = dxArr[i], dy = dyArr[i];

                if (dx > 0) {   // lean down
                    if (ry == by) {
                        if (rx > bx) offer(rx, ry, dx, dy, bx, by, t, true);
                        else if (rx < bx) offer(rx, ry, dx, dy, bx, by, t, false);
                    } else offer(rx, ry, dx, dy, bx, by, t, false);
                } else if (dx < 0) {    // lean up
                    if (ry == by) {
                        if (rx > bx) offer(rx, ry, dx, dy, bx, by, t, false);
                        else if (rx < bx) offer(rx, ry, dx, dy, bx, by, t, true);
                    } else offer(rx, ry, dx, dy, bx, by, t, false);
                } else if (dy > 0) {   // lean right
                    if (rx == bx) {
                        if (ry > by) offer(rx, ry, dx, dy, bx, by, t, true);
                        else if (ry < by) offer(rx, ry, dx, dy, bx, by, t, false);
                    } else offer(rx, ry, dx, dy, bx, by, t, false);
                } else if (dy < 0) {   // lean left
                    if (rx == bx) {
                        if (ry > by) offer(rx, ry, dx, dy, bx, by, t, false);
                        else if (ry < by) offer(rx, ry, dx, dy, bx, by, t, true);
                    } else offer(rx, ry, dx, dy, bx, by, t, false);
                }

            }
        }
        return "-1";
    }

    private void offer(int rx, int ry, int dx, int dy, int bx, int by, int t, boolean rFirst) {
        int[] r, b;
        if (rFirst) {
            r = moveUntil(rx, ry, dx, dy, 999, 999);
            b = moveUntil(bx, by, dx, dy, r[0], r[1]);
        } else {
            b = moveUntil(bx, by, dx, dy, 999, 999);
            r = moveUntil(rx, ry, dx, dy, b[0], b[1]);
        }
        if ((b[0] == hx && b[1] == hy) || (rx == r[0] && ry == r[1] && bx == b[0] && by == b[1])) return;
        q.offer(new int[]{r[0], r[1], b[0], b[1], t + 1});
    }

    private int[] moveUntil(int x, int y, int dx, int dy, int xBlock, int yBlock) {
        while (true) {
            x += dx; y += dy;
            if (board[x][y] == 'O') return new int[]{x, y};
            else if (board[x][y] == '#' || (x == xBlock && y == yBlock)) return new int[]{x - dx, y - dy};
        }
    }
}
