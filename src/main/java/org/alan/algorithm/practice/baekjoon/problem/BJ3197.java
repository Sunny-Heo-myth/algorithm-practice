package org.alan.algorithm.practice.baekjoon.problem;

import java.util.LinkedList;
import java.util.Queue;

public class BJ3197 {

    public String solve(String input) {
        char[][] map = input.lines().skip(1).map(String::toCharArray).toArray(char[][]::new);
        int xx = map.length, yy = map[0].length;
        char ICE = 'X', WATER = '.', SWAN = 'L', VISITED = 'V';
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

        Queue<int[]> waterQ = new LinkedList<>(), visitQ = new LinkedList<>();
        boolean seen = false;
        for (int i = 0; i < xx; i++) for (int j = 0; j < yy; j++) {
            if (map[i][j] == SWAN) {
                if (!seen) {
                    visitQ.offer(new int[]{i, j});
                    map[i][j] = VISITED;
                    seen = true;
                }
                waterQ.offer(new int[]{i, j});
            } else if (map[i][j] == WATER) {
                waterQ.offer(new int[]{i, j});
            }
        }

        int day = 0;
        while (!visitQ.isEmpty() && !waterQ.isEmpty()) {
            while (!visitQ.isEmpty()) {
                int[] poll = visitQ.poll();
                int x = poll[0], y = poll[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= xx || ny >= yy) continue;
                    if (map[nx][ny] == SWAN) return String.valueOf(day);
                    else if (map[nx][ny] == WATER) {
                        visitQ.offer(new int[]{nx, ny});
                        map[nx][ny] = VISITED;
                    }
                }
            }
            int size = waterQ.size();
            while (size-- > 0) {
                int[] poll = waterQ.poll();
                int x = poll[0], y = poll[1];

                loop: for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= xx || ny >= yy || map[nx][ny] != ICE) continue;

                    int[] melt = {nx, ny};
                    waterQ.offer(melt);
                    for (int j = 0; j < 4; j++) {
                        int nnx = nx + dx[j], nny = ny + dy[j];
                        if (nnx < 0 || nny < 0 || nnx >= xx || nny >= yy || map[nnx][nny] != VISITED) continue;
                        visitQ.offer(melt);
                        map[nx][ny] = VISITED;
                        continue loop;
                    }
                    map[nx][ny] = WATER;
                }
            }
            day++;
        }
        return String.valueOf(day);
    }

}
