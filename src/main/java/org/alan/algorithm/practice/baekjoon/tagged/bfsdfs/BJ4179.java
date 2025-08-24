package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class BJ4179 {
    private final char[][] map;
    private final Queue<int[]> jQ = new LinkedList<>(), fQ = new LinkedList<>();
    private static final int[] DX = {1, -1, 0, 0}, DY = {0, 0, -1, 1};
    private static final char JH = 'J', FIRE = 'F', WALL = '#';

    public BJ4179(String input) {
        map = input.lines().skip(1).map(String::toCharArray).toArray(char[][]::new);
        for (int i = 0; i < map.length; i++) for (int j = 0; j < map[0].length; j++) {
            if (map[i][j] == JH) jQ.offer(new int[]{i, j});
            else if (map[i][j] == FIRE) fQ.offer(new int[]{i, j});
        }
    }

    public String solve() {
        int day = 0;
        while (!jQ.isEmpty()) {

            int jMove = jQ.size();
            while (jMove-- > 0) {
                int[] jPoll = jQ.poll();
                int jx = jPoll[0], jy = jPoll[1];
                if (map[jx][jy] == FIRE) continue;

                for (int i = 0; i < 4; i++) {
                    int nx = jx + DX[i], ny = jy + DY[i];
                    if (!withinEdge(nx, ny)) return String.valueOf(day + 1);
                    if (map[nx][ny] != JH && map[nx][ny] != WALL && map[nx][ny] != FIRE) {
                        jQ.offer(new int[]{nx, ny});
                        map[nx][ny] = JH;
                    }
                }
            }

            int fMove = fQ.size();
            while (fMove-- > 0) {
                int[] fPoll = fQ.poll();
                int fx = fPoll[0], fy = fPoll[1];

                for (int i = 0; i < 4; i++) {
                    int nx = fx + DX[i], ny = fy + DY[i];
                    if (withinEdge(nx, ny) && map[nx][ny] != WALL && map[nx][ny] != FIRE) {
                        fQ.offer(new int[]{nx, ny});
                        map[nx][ny] = FIRE;
                    }
                }
            }

            day++;
        }
        return "IMPOSSIBLE";
    }

    private boolean withinEdge(int x, int y) {
        return 0 <= x && x < map.length && 0 <= y && y < map[0].length;
    }
}
