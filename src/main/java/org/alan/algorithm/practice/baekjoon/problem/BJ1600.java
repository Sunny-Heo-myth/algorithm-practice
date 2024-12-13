package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ1600 {
    private int[][][] map;
    private final Queue<int[]> queue = new LinkedList<>();
    private final int WALL = Integer.MAX_VALUE;
    private final int[]
            dx = {1, -1, 0, 0}, dkx = {1, 1, -1, -1, 2, 2, -2, -2},
            dy = {0, 0, 1, -1}, dky = {2, -2, 2, -2, 1, -1, 1, -1};

    public String solve(String input) {
        String[] lines = input.split("\n");
        int jump = Integer.parseInt(lines[0]);
        map = Arrays.stream(lines).skip(2)
                .map(line -> Pattern.compile(" ").splitAsStream(line)
                        .map(s -> {
                            int i = Integer.parseInt(s);
                            return IntStream.generate(() -> i == 1 ? WALL : i).limit(jump + 1).toArray();
                        })
                        .toArray(int[][]::new))
                .toArray(int[][][]::new);

        queue.offer(new int[]{0, 0, 0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], z = poll[2], move = poll[3];
            if (x == map.length - 1 && y == map[0].length - 1) return String.valueOf(move);

            for (int i = 0; i < 8; i++) {
                int nx = x + dkx[i], ny = y + dky[i], nz = z + 1;
                if (cannotGo(nx, ny, nz, move)) continue;
                map[nx][ny][nz] = move + 1;
                queue.offer(new int[]{nx, ny, nz, move + 1});
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (cannotGo(nx, ny, z, move)) continue;
                map[nx][ny][z] = move + 1;
                queue.offer(new int[]{nx, ny, z, move + 1});
            }
        }
        return "-1";
    }

    private boolean cannotGo(int nx, int ny, int nz, int move) {
        return nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || nz >= map[0][0].length
                || map[nx][ny][nz] == WALL
                || (map[nx][ny][nz] != 0 && map[nx][ny][nz] <= move + 1);
    }

}
