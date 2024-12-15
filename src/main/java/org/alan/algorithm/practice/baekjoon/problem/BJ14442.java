package org.alan.algorithm.practice.baekjoon.problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class BJ14442 {
    public String solve(String input) {
        int bomb = Integer.parseInt(input.split("\n")[0].split(" ")[2]), WALL = Integer.MAX_VALUE;
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        int[][][] map = input.lines().skip(1)
                .map(line -> line.chars()
                        .mapToObj(ch -> IntStream.generate(() -> ch == '1' ? WALL : 0).limit(bomb + 1).toArray())
                        .toArray(int[][]::new))
                .toArray(int[][][]::new);
        int xx = map.length, yy = map[0].length, zz = map[0][0].length, bombUsed = 0;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 0});
        map[0][0][0] = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], z = poll[2];
            if (x == xx - 1 && y == yy - 1) return String.valueOf(map[x][y][z]);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= xx || ny >= yy) continue;

                if (map[nx][ny][z] != WALL && (map[nx][ny][z] == 0 || map[nx][ny][z] > map[x][y][z] + 1)) {
                    queue.offer(new int[]{nx, ny, z});
                    map[nx][ny][z] = map[x][y][z] + 1;
                } else if (map[nx][ny][z] == WALL && z + 1 < zz && map[nx][ny][z + 1] > map[x][y][z] + 1) {
                    queue.offer(new int[]{nx, ny, z + 1});
                    map[nx][ny][z + 1] = map[x][y][z] + 1;
                }

            }
        }
        return "-1";
    }
}
