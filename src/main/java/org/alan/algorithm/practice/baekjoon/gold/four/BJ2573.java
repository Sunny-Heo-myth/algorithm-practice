package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;

public class BJ2573 {
    public String solve(String input) {
        int[] dx = {1, 0, -1, 0}; int[] dy = {0, -1, 0, 1};
        int[][] map = input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        int m = map.length; int n = map[0].length;

        int time = 0;
        long ice = Arrays.stream(map).flatMapToInt(Arrays::stream).filter(i -> i > 0).count();
        while (ice > 0) {
            time++;

            int[][] nextMap = new int[m][n];
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) for (int j = 0; j < m; j++) if (map[i][j] > 0) {
                int water = 0;
                for (int k = 0; k < 4; k++) {
                    int ni = i + dx[k]; int nj = j + dy[k];
                    if (ni < 0 || ni >= m || nj < 0 || nj >= n || map[ni][nj] > 0) continue;
                    water++;
                }

                if (map[i][j] - water > 0) {
                    nextMap[i][j] = map[i][j] - water;
                    visited[i][j] = true;
                } else {
                    nextMap[i][j] = 0;
                    ice--;
                }
            }

            int block = 0;
            for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (visited[i][j]) {
                if (++block >= 2) return String.valueOf(time);
                Stack<int[]> stack = new Stack<>();

                stack.push(new int[]{i, j});
                visited[i][j] = false;

                while (!stack.isEmpty()) {
                    int[] pop = stack.pop();
                    int x = pop[0]; int y = pop[1];

                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k]; int ny = y + dy[k];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n || !visited[nx][ny]) continue;

                        stack.push(new int[]{nx, ny});
                        visited[nx][ny] = false;
                    }
                }
            }

            map = nextMap;
        }
        return "0";
    }
}
