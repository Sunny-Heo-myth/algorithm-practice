package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ1261 {
    public String solve(String input) {
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        int[][] map = input.lines().skip(1).map(s -> s.chars().map(i -> i - '0').toArray()).toArray(int[][]::new);
        int n = map.length, m = map[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(ints -> ints[2]));

        visited[0][0] = true;
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] pop = pq.poll();
            if (pop[0] == n - 1 && pop[1] == m - 1) return String.valueOf(pop[2]);

            for (int i = 0; i < 4; i++) {
                int nx = pop[0] + dx[i], ny = pop[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if (map[nx][ny] == 1) pq.offer(new int[]{nx, ny, pop[2] + 1});
                else pq.offer(new int[]{nx, ny, pop[2]});
            }
        }
        return "-1";
    }
}
