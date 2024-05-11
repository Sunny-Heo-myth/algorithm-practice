package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.Stack;

public class BJ3184 {
    public String solve(String input) {
        int[] dx = {1, 0, -1, 0}; int[] dy = {0, -1, 0, 1};
        int fence = '#'; int wolf = 'v'; int sheep = 'o';
        int[][] map = input.lines().skip(1).map(s -> s.chars().toArray()).toArray(int[][]::new);
        boolean[][] visited = new boolean[map.length][map[0].length];


        int numberOfSheep = 0; int numberOfWolf = 0;
        for (int i = 0; i < map.length; i++) for (int j = 0; j < map[0].length; j++) {
            if (map[i][j] == fence || visited[i][j]) continue;

            Stack<int[]> stack = new Stack<>();
            int ns = 0; int nw = 0;

            stack.push(new int[]{i, j}); visited[i][j] = true;
            if (map[i][j] == sheep) ns++;
            else if (map[i][j] == wolf) nw++;

            while (!stack.isEmpty()) {
                int[] pop = stack.pop();
                for (int k = 0; k < 4; k++) {
                    int nx = pop[0] + dx[k]; int ny = pop[1] + dy[k];
                    if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length
                            || map[nx][ny] == fence || visited[nx][ny]) continue;

                    stack.push(new int[]{nx, ny}); visited[nx][ny] = true;
                    if (map[nx][ny] == sheep) ns++;
                    else if (map[nx][ny] == wolf) nw++;
                }
            }

            if (ns <= nw) numberOfWolf += nw;
            else numberOfSheep += ns;
        }
        
        return numberOfSheep + " " + numberOfWolf;
    }
}
