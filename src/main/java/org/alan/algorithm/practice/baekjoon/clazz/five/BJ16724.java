package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Stack;

public class BJ16724 {
    public String solve(String input) {
        int[] dx = {-1, 1, 0 ,0}, dy = {0, 0, -1, 1};
        int[][] map = input.lines().skip(1).map(s -> s.chars().map(ch -> switch (ch) {
            case 'U' -> 0;
            case 'D' -> 1;
            case 'L' -> 2;
            case 'R' -> 3;
            default -> throw new IllegalStateException();
        }).toArray()).toArray(int[][]::new);
        int[][] visited = new int[map.length][map[0].length];

        int answer = 0;
        int count = 0;
        for (int i = 0; i < map.length; i++) for (int j = 0; j < map[0].length; j++) if (visited[i][j] == 0) {
            answer++;
            Stack<int[]> stack = new Stack<>();

            visited[i][j] = ++count;
            stack.push(new int[]{i, j});

            int idx = 0;
            while (idx++ < 1_000_000) {
                int[] peek = stack.peek();
                int x = peek[0], y = peek[1], nx = x + dx[map[x][y]], ny = y + dy[map[x][y]];
                if (visited[nx][ny] != 0) {
                    if (visited[nx][ny] != count) {
                        stack.forEach(xy -> visited[xy[0]][xy[1]] = visited[nx][ny]);
                        answer--;
                    }
                    break;
                } else {
                    visited[nx][ny] = count;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
        return String.valueOf(answer);
    }
}
