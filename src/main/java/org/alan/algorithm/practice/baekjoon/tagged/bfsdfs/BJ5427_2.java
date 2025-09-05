package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class BJ5427_2 {
    private final char[][] map;
    private final Queue<int[]> sq = new LinkedList<>(), fq = new LinkedList<>();
    private static final int[] DX = {1, -1, 0, 0}, DY = {0, 0, 1, -1};
    private static final char EMPTY = '.', FIRE = '*', SANG = '@';

    public BJ5427_2(String input) {
        map = input.lines().skip(1).map(String::toCharArray).toArray(char[][]::new);
        for (int i = 0; i < map.length; i++) for (int j = 0; j < map[0].length; j++) {
            int[] xy = {i, j};
            if (map[i][j] == SANG) sq.offer(xy);
            else if (map[i][j] == FIRE) fq.offer(xy);
        }
    }

    public String solve() {
        int time = 0, X = map.length, Y = map[0].length;

        while (!sq.isEmpty()) {

            int n = sq.size();
            while (n-- > 0) {
                int[] xy = sq.poll();
                int x = xy[0], y = xy[1];
                if (map[x][y] == FIRE) continue;

                for (int i = 0; i < 4; i++) {
                    int nx = x + DX[i], ny = y + DY[i];
                    if (nx < 0 || nx >= X || ny < 0 || ny >= Y) return String.valueOf(time + 1);
                    if (map[nx][ny] != EMPTY) continue;

                    map[nx][ny] = SANG;
                    sq.offer(new int[]{nx, ny});
                }
            }

            int m = fq.size();
            while (m-- > 0) {
                int[] xy = fq.poll();
                int x = xy[0], y = xy[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + DX[i], ny = y + DY[i];
                    if (nx < 0 || nx >= X || ny < 0 || ny >= Y
                            || (map[nx][ny] != EMPTY && map[nx][ny] != SANG)) continue;

                    map[nx][ny] = FIRE;
                    fq.offer(new int[]{nx, ny});
                }
            }

            time++;
        }
        return "IMPOSSIBLE";
    }
}
