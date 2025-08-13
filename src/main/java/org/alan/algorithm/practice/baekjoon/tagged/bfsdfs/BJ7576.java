package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import java.util.*;

public class BJ7576 {
    private static final int RIPE = 1, UNRIPE = 0, NO_TOMATO = -1;
    private static final int[] DX = {1, 0, -1, 0}, DY = {0, -1, 0, 1};

    private final int[][] box;

    public BJ7576(String input) {
        box = input.lines().skip(1).map(s ->
                Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
    }

    public String solve() {
        Queue<int[]> edges = new LinkedList<>();
        int unripeCount = 0, dayPassed = 0, dailyEdge;
        for (int i = 0; i < box.length; i++) for (int j = 0; j < box[0].length; j++) {
            if (box[i][j] == RIPE) {
                edges.add(new int[]{i, j});
            } else if (box[i][j] == UNRIPE) {
                unripeCount++;
            }
        }

        while (!edges.isEmpty()) {
            dailyEdge = edges.size();
            while (!edges.isEmpty() && dailyEdge-- > 0) {
                int[] edge = edges.poll();
                int x = edge[0], y = edge[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + DX[i], ny = y + DY[i];
                    if (nx < 0 || nx >= box.length || ny < 0 || ny >= box[0].length || box[nx][ny] != UNRIPE) continue;

                    unripeCount--;
                    box[nx][ny] = RIPE;
                    edges.offer(new int[]{nx, ny});
                }
            }
            if (edges.isEmpty()) break;
            dayPassed++;
        }
        return String.valueOf(unripeCount == 0 ? dayPassed : -1);
    }
}
