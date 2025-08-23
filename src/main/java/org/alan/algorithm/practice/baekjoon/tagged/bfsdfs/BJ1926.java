package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BJ1926 {
    private final int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1};
    private final boolean[][] pic, visited;


    public BJ1926(String input) {
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        int m = Integer.parseInt(firstLine[0]), n = Integer.parseInt(firstLine[1]);
        pic = new boolean[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < lines.length - 1; i++) {
            String[] line = lines[i + 1].split(" ");
            for (int j = 0; j < line.length; j++) pic[i][j] = Objects.equals(line[j], "1");
        }
    }

    public String solve() {
        int m = pic.length, n = pic[0].length, count = 0, max = 0;
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (pic[i][j] && !visited[i][j]) {
            count++;
            Queue<int[]> queue = new LinkedList<>();

            int size = 1;
            visited[i][j] = true;
            queue.offer(new int[]{i, j});
            while (!queue.isEmpty()) {
                int[] xy = queue.poll();
                int x = xy[0], y = xy[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || !pic[nx][ny] || visited[nx][ny]) continue;

                    size++;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
            max = Math.max(size, max);
        }
        return count + "\n" + max;
    }
}
