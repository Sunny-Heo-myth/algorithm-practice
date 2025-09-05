package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class BJ5427 {
    public String solve(String input) {
        char WALL = '#', ME = '@', FIRE = '*';
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        char[][] map = input.lines().skip(1).map(String::toCharArray).toArray(char[][]::new);

        Queue<int[]> mQueue = new LinkedList<>(), fQueue = new LinkedList<>();
        for (int i = 0; i < map.length; i++) for (int j = 0; j < map[0].length; j++) {
            if (map[i][j] == ME) mQueue.offer(new int[]{i, j, 0});
            else if (map[i][j] == FIRE) fQueue.offer(new int[]{i, j, 0});
        }

        while (!mQueue.isEmpty() || !fQueue.isEmpty()) {

            int mSize = mQueue.size();
            while (mSize-- > 0) {
                int[] m = mQueue.poll();
                int x = m[0], y = m[1];
                if (map[x][y] == FIRE) continue;
                if (x == 0 || x == map.length - 1 || y == 0 || y == map[0].length - 1) return String.valueOf(m[2] + 1);

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length
                            || map[nx][ny] == ME || map[nx][ny] == FIRE || map[nx][ny] == WALL) continue;

                    map[nx][ny] = ME;
                    mQueue.offer(new int[]{nx, ny, m[2] + 1});
                }
            }

            int fSize = fQueue.size();
            while (fSize-- > 0) {
                int[] f = fQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = f[0] + dx[i], ny = f[1] + dy[i];
                    if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length
                            || map[nx][ny] == FIRE || map[nx][ny] == WALL) continue;

                    map[nx][ny] = FIRE;
                    fQueue.offer(new int[]{nx, ny, f[2] + 1});
                }
            }

        }
        return "IMPOSSIBLE";
    }
}
