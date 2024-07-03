package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BJ3055 {
    public String solve(String input) {
        int[] dx = {1, -1, 0, 0}; int[] dy = {0, 0, -1, 1};
        int beaver = 'D', hedgehog = 'S', rock = 'X', water = '*', land = '.', visited = '0';
        int[][] map = input.lines().skip(1).map(s -> s.chars().toArray()).toArray(int[][]::new);

        int currentTime = 0;
        Queue<int[]> queue = new LinkedList<>();
        Stack<int[]> waterStack = new Stack<>();

        for (int i = 0; i < map.length; i++) for (int j = 0; j < map[i].length; j++)
            if (map[i][j] == hedgehog) queue.offer(new int[]{i, j, 0});
            else if (map[i][j] == water) waterStack.push(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], time = poll[2];

            if (currentTime == time) {
                Stack<int[]> nextWaterStack = new Stack<>();
                currentTime++;
                while (!waterStack.isEmpty()) {
                    int[] pop = waterStack.pop();
                    int wx = pop[0], wy = pop[1];
                    for (int i = 0; i < 4; i++) {
                        int nx = wx + dx[i], ny = wy + dy[i];
                        if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length
                                || map[nx][ny] == rock || map[nx][ny] == water || map[nx][ny] == beaver) continue;
                        map[nx][ny] = water;
                        nextWaterStack.push(new int[]{nx, ny});
                    }
                }
                waterStack = nextWaterStack;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || map[nx][ny] == visited) continue;
                if (map[nx][ny] == beaver) return String.valueOf(time + 1);
                else if (map[nx][ny] == land || map[nx][ny] == hedgehog) {
                    map[nx][ny] = visited;
                    queue.offer(new int[]{nx, ny, time + 1});
                }
            }
        }
        return "KAKTUS";
    }
}
