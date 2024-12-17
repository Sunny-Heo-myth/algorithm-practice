package org.alan.algorithm.practice.baekjoon.problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BJ16933 {
    public String solve(String input) {
        int bomb = Integer.parseInt(input.split("\n")[0].split(" ")[2]), WALL = Integer.MAX_VALUE, NOT_VISITED = 0;
        int[][][][] map = Stream.generate(() -> input.lines().skip(1).map(line -> line.chars()
                                .mapToObj(i -> IntStream.generate(() -> i == '1' ? WALL : NOT_VISITED).limit(bomb + 1).toArray())
                                .toArray(int[][]::new))
                        .toArray(int[][][]::new))
                .limit(2)
                .toArray(int[][][][]::new);
        int xx = map[0].length, yy = map[0][0].length;
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 0, 0});
        map[0][0][0][0] = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int half = poll[0], x = poll[1], y = poll[2], used = poll[3], nextHalf = half == 0 ? 1 : 0;
            if (x == xx - 1 && y == yy - 1) return String.valueOf(map[half][x][y][used]);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= xx || ny >= yy) continue;

                if (map[nextHalf][nx][ny][used] != WALL
                        && (map[nextHalf][nx][ny][used] == NOT_VISITED || map[nextHalf][nx][ny][used] > map[half][x][y][used] + 1)) {
                    map[nextHalf][nx][ny][used] = map[half][x][y][used] + 1;
                    queue.offer(new int[]{nextHalf, nx, ny, used});

                } else if (used + 1 <= bomb && map[nextHalf][nx][ny][used + 1] == WALL) {
                    if (half == 0) {
                        queue.offer(new int[]{nextHalf, nx, ny, used + 1});
                        map[nextHalf][nx][ny][used + 1] = map[half][x][y][used] + 1;
                    } else {
                        queue.offer(new int[]{nextHalf, x, y, used});
                        map[nextHalf][x][y][used] = map[half][x][y][used] + 1;
                    }
                }
            }
        }
        return "-1";
    }

}
