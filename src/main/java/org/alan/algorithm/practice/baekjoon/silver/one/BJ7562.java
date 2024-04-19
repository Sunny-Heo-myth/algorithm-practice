package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BJ7562 {
    private boolean[][] visited;
    private int[][] min;
    private final int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
    private final int[] dy = {-2, 2, -2, 2, -1, 1, -1, 1};

    public String solve(String input) {
        String[] lines = input.split("\n");
        int length = Integer.parseInt(lines[0]);
        visited = new boolean[length][length];
        min = new int[length][length];
        for (int i = 0; i < length; i++) Arrays.fill(min[i], length * length);

        String[] fromLine = lines[1].split(" ");
        String[] toLine = lines[2].split(" ");
        int[] from = new int[]{Integer.parseInt(fromLine[0]), Integer.parseInt(fromLine[1])};
        int[] to = new int[]{Integer.parseInt(toLine[0]), Integer.parseInt(toLine[1])};

        min[from[0]][from[1]] = 0;
        visited[from[0]][from[1]] = true;
        recur(from[0], from[1], 1);

        return String.valueOf(min[to[0]][to[1]]);
    }

    private void recur(int x, int y, int count) {
        for (int i = 0; i < 8; i++) {
            int xx = x + dx[i]; int yy = y + dy[i];
            if (xx < 0 || xx >= visited.length || yy < 0 || yy >= visited[0].length
                    || visited[xx][yy] || count >= min[xx][yy]) continue;
            min[xx][yy] = count;
            visited[xx][yy] = true;
            recur(xx, yy, count + 1);
            visited[xx][yy] = false;
        }
    }

    public String solve2(String input) {
        String[] lines = input.split("\n");
        int length = Integer.parseInt(lines[0]);
        min = new int[length][length];

        String[] fromLine = lines[1].split(" ");
        String[] toLine = lines[2].split(" ");
        int[] from = new int[]{Integer.parseInt(fromLine[0]), Integer.parseInt(fromLine[1])};
        int[] to = new int[]{Integer.parseInt(toLine[0]), Integer.parseInt(toLine[1])};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(from);
        min[from[0]][from[1]] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0]; int y = poll[1];

            if (to[0] == x && to[1] == y) return String.valueOf(min[x][y] - 1);

            for (int i = 0; i < 8; i++) {
                int xx = x + dx[i]; int yy = y + dy[i];
                if (xx < 0 || xx >= length || yy < 0 || yy >= length || min[xx][yy] != 0) continue;
                min[xx][yy] = min[x][y] + 1;
                queue.offer(new int[]{xx, yy});
            }
        }

        return "-1";
    }
}
