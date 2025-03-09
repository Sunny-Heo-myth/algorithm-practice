package org.alan.algorithm.practice.baekjoon.tagged.bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BJ15683 {
    private final int M, N;
    private final int[][] map, watched;
    private final List<int[]> cameras = new ArrayList<>();
    private final int[][][]
            dxTypes = {{},
            {{0}, {0}, {1}, {-1}},
            {{1, -1}, {0, 0}},
            {{1, 0}, {1, 0}, {-1, 0}, {-1, 0}},
            {{1, -1, 0}, {1, -1, 0}, {0, 0, 1}, {0, 0, -1}},
            {{1, -1, 0, 0}}},
            dyTypes = {{},
            {{1}, {-1}, {0}, {0}},
            {{0, 0}, {1, -1}},
            {{0, 1}, {0, -1}, {0, 1}, {0, -1}},
            {{0, 0, 1}, {0, 0, -1}, {1, -1, 0}, {1, -1, 0}},
            {{0, 0, 1, -1}}};
    private int min = Integer.MAX_VALUE;

    public BJ15683(String input) {
        map = input.lines().skip(1).map(line -> Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        M = map.length; N = map[0].length;
        watched = new int[M][N];
        for (int i = 0; i < M; i++) for (int j = 0; j < N; j++) if (map[i][j] != 0) {
            watched[i][j] = 1;
            if (map[i][j] != 6) cameras.add(new int[]{i, j});
        }
    }

    public String solve() {
        recursive(0);
        return String.valueOf(min);
    }

    private void recursive(int cIdx) {
        if (cIdx == cameras.size()) {
            min = Math.min(min, (int) IntStream.range(0, M).mapToLong(i ->
                    IntStream.range(0, N).filter(j -> watched[i][j] == 0).count()).sum());
            return;
        }

        int[] camera = cameras.get(cIdx);
        int x = camera[0], y = camera[1], cType = map[x][y];
        for (int p = 0; p < dxTypes[cType].length; p++) {
            int[] dxs = dxTypes[cType][p], dys = dyTypes[cType][p];

            for (int dx : dxs) if (dx != 0) IntStream.iterate(x, i -> i >= 0 && i < M, i -> i + dx)
                    .takeWhile(i -> map[i][y] != 6).forEach(i -> watched[i][y]++);
            for (int dy : dys) if (dy != 0) IntStream.iterate(y, i -> i >= 0 && i < N, i -> i + dy)
                    .takeWhile(i -> map[x][i] != 6).forEach(i -> watched[x][i]++);

            recursive(cIdx + 1);

            for (int dx : dxs) if (dx != 0) IntStream.iterate(x, i -> i >= 0 && i < M, i -> i + dx)
                    .takeWhile(i -> map[i][y] != 6).forEach(i -> watched[i][y]--);
            for (int dy : dys) if (dy != 0) IntStream.iterate(y, i -> i >= 0 && i < N, i -> i + dy)
                    .takeWhile(i -> map[x][i] != 6).forEach(i -> watched[x][i]--);
        }
    }

}
