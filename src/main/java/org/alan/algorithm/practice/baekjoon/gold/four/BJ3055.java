package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.LinkedList;
import java.util.Queue;

public class BJ3055 {
    public String solve(String input) {
        int[] dx = {1, -1, 0, 0}; int[] dy = {0, 0, -1, 1};
        int beaver = 'D'; int hedgehog = 'S'; int rock = 'X'; int water = '*'; int land = '.';
        int[][] map = input.lines().skip(1).map(s -> s.chars().toArray()).toArray(int[][]::new);
        boolean[][] visited = new boolean[map.length][map[0].length];
        int currentTime = 0;

        Queue<int[]> queue = new LinkedList<>();
        loop: for (int i = 0; i < map.length; i++) for (int j = 0; j < map[i].length; j++) if (map[i][j] == hedgehog) {
            visited[i][j] = true;
            queue.offer(new int[]{i, j, 0});
            break loop;
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], time = poll[2];
            if (map[x][y] == beaver) return String.valueOf(time);

            if (currentTime == time) {
                currentTime++;
                for (int i = 0; i < map.length; i++) for (int j = 0; j < map[0].length; j++) if (map[i][j] == land) for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k], ny = j + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && map[nx][ny] == water) {
                        map[i][j] = water;
                        break;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && map[nx][ny] == land && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, time + 1});
                }
            }
        }
        return "KAKTUS";
    }
}
