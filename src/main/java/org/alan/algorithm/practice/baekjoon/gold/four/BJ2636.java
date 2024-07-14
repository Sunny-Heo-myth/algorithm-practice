package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class BJ2636 {

    public String solve(String input) {
        int[][] map = input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        int time = 0, h = map.length, w = map[0].length;
        long cheese = input.lines().skip(1).flatMap(s ->
                Pattern.compile(" ").splitAsStream(s).filter(ss -> ss.equals("1"))).count();
        long previous = cheese;
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{0, 0});
        map[0][0] = 2;

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + pop[0], ny = dy[k] + pop[1];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] != 0) continue;
                stack.push(new int[]{nx, ny});
                map[nx][ny] = 2;
            }
        }

        while (cheese > 0) {
            time++;

            List<int[]> melt = new ArrayList<>();
            for (int i = 1; i < h - 1; i++) for (int j = 1; j < w - 1; j++) if (map[i][j] == 1)
                for (int k = 0; k < 4; k++) if (map[i + dx[k]][j + dy[k]] == 2) {
                    melt.add(new int[]{i, j});
                    break;
                }

            previous = cheese;
            cheese -= melt.size();
            for (int[] xy : melt) {
                stack.push(new int[]{xy[0], xy[1]});
                map[xy[0]][xy[1]] = 2;

                while (!stack.isEmpty()) {
                    int[] pop = stack.pop();
                    for (int k = 0; k < 4; k++) {
                        int nx = dx[k] + pop[0], ny = dy[k] + pop[1];
                        if (nx < 1 || nx >= h - 1 || ny < 1 || ny >= w - 1 || map[nx][ny] != 0) continue;
                        stack.push(new int[]{nx, ny});
                        map[nx][ny] = 2;
                    }
                }
            }
        }

        return time + "\n" + previous;
    }

}
