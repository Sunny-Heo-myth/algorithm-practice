package org.alan.algorithm.practice.baekjoon.problem;

import java.util.LinkedList;
import java.util.Queue;

public class BJ4179 {
    public String solve(String input) {
        char WALL = '#', FIRE = 'F', JIHOON = 'J';
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        char[][] mx = input.lines().skip(1).map(String::toCharArray).toArray(char[][]::new);

        Queue<int[]> fQueue = new LinkedList<>(), jQueue = new LinkedList<>();
        for (int i = 0; i < mx.length; i++) for (int j = 0; j < mx[0].length; j++) {
            if (mx[i][j] == FIRE) fQueue.offer(new int[]{i, j, 0});
            else if (mx[i][j] == JIHOON) jQueue.offer(new int[]{i, j, 0});
        }

        while (!jQueue.isEmpty() || !fQueue.isEmpty()) {

            int jSize = jQueue.size();
            while (jSize-- > 0) {
                int[] jh = jQueue.poll();
                int x = jh[0], y = jh[1];
                if (mx[x][y] == FIRE) continue;
                if (x == 0 || x == mx.length - 1 || y == 0 || y == mx[0].length - 1) return String.valueOf(jh[2] + 1);

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (mx[nx][ny] == FIRE || mx[nx][ny] == WALL || mx[nx][ny] == JIHOON) continue;
                    mx[nx][ny] = JIHOON;
                    jQueue.offer(new int[]{nx, ny, jh[2] + 1});
                }
            }

            int fSize = fQueue.size();
            while (fSize-- > 0) {
                int[] f = fQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = f[0] + dx[i], ny = f[1] + dy[i];
                    if (nx < 0 || nx >= mx.length || ny < 0 || ny >= mx[0].length
                            || mx[nx][ny] == WALL || mx[nx][ny] == FIRE) continue;
                    mx[nx][ny] = FIRE;
                    fQueue.offer(new int[]{nx, ny, f[2] + 1});
                }
            }

        }

        return "IMPOSSIBLE";
    }
}
