package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.Stack;

public class BJ1303 {
    public String solve(String input) {
        int[] dx = {1, 0, -1, 0}; int[] dy = {0, -1, 0, 1};
        int friendly = 'W'; int enemy = 'B'; int fp = 0; int ep = 0;
        int[][] map = input.lines().skip(1).map(s -> s.chars().toArray()).toArray(int[][]::new);
        boolean[][] visited = new boolean[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) for (int j = 0; j < map[0].length; j++) {
            if (visited[i][j]) continue;

            int team = map[i][j]; int total = 0;
            Stack<int[]> stack = new Stack<>();

            stack.push(new int[]{i, j}); visited[i][j] = true; total++;

            while (!stack.isEmpty()) {
                int[] pop = stack.pop();
                for (int k = 0; k < 4; k++) {
                    int nx = pop[0] + dx[k]; int ny = pop[1] + dy[k];
                    if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length
                            || visited[nx][ny] || team != map[nx][ny]) continue;
                    stack.push(new int[]{nx, ny}); visited[nx][ny] = true; total++;
                }
            }

            if (team == friendly) fp += total * total;
            else ep += total * total;
        }

        return fp + " " + ep;
    }
}
