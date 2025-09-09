package org.alan.algorithm.practice.baekjoon.tagged.bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class BJ15683_2 {
    private long min = Long.MAX_VALUE;
    private final int[][] map;
    private final List<int[]> camera = new ArrayList<>();
    private static final int[][][]
            CAMERA_DX = {{{1}, {-1}, {0}, {0}}, {{1, -1}, {0, 0}}, {{1, 0}, {1, 0}, {-1, 0}, {-1, 0}}, {{1, -1, 0}, {1, -1, 0}, {0, 0, 1}, {0, 0, -1}}, {{1, -1, 0, 0}}},
            CAMERA_DY = {{{0}, {0}, {1}, {-1}}, {{0, 0}, {1, -1}}, {{0, 1}, {0, -1}, {0, 1}, {0, -1}}, {{0, 0, 1}, {0, 0, -1}, {1, -1, 0}, {1, -1, 0}}, {{0, 0, 1, -1}}};

    public BJ15683_2(String input) {
        map = input.lines().skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
        for (int i = 0; i < map.length; i++) for (int j = 0; j < map[0].length; j++) {
            if (map[i][j] == 0) continue;
            map[i][j] += 10000;
            if (map[i][j] == 10006) continue;
            camera.add(new int[]{i, j});
        }
    }

    public String solve() {
        recur(0);
        return String.valueOf(min);
    }

    private void recur(int n) {
        if (n == camera.size()) {
            min = Math.min(min, Arrays.stream(map)
                    .mapToLong(l -> java.util.Arrays.stream(l).filter(i -> i == 0).count()).sum());
            return;
        }

        int[] c = camera.get(n);
        int rotations = CAMERA_DX[map[c[0]][c[1]] - 10001].length;
        for (int r = 0; r < rotations; r++) {
            check(c, r, 1);
            recur(n + 1);
            check(c, r, -1);
        }
    }

    private void check(int[] camera, int r, int v) {
        int cx = camera[0], cy = camera[1], type = map[cx][cy] - 10001;
        int[] dxs = CAMERA_DX[type][r], dys = CAMERA_DY[type][r];
        for (int i = 0; i < dxs.length; i++) {
            int dx = dxs[i], dy = dys[i];   // for each direction
            for (int j = 1; j < 100; j++) { // stretch sight until a wall comes up
                int nx = cx + dx * j, ny = cy + dy * j;
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length || map[nx][ny] == 10006) break;
                if (map[nx][ny] >= 10000) continue;
                map[nx][ny] += v;
            }
        }
    }
}
