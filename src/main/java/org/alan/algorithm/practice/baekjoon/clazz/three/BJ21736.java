package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.LinkedList;
import java.util.Queue;

public class BJ21736 {
    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, -1, 0, 1};

    public String solve(String input) {
        Queue<int[]> queue = new LinkedList<>();
        char[][] map = input.lines().skip(1).map(String::toCharArray).toArray(char[][]::new);
        boolean[][] visited = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) for (int j = 0; j < map[0].length; j++) if (map[i][j] == 'I') {
            queue.offer(new int[]{i, j});
            visited[i][j] = true;
            break;
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + DX[i];
                int nextY = now[1] + DY[i];
                if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length || visited[nextX][nextY] || map[nextX][nextY] == 'X') continue;
                visited[nextX][nextY] = true;
                queue.offer(new int[]{nextX, nextY});
                if (map[nextX][nextY] == 'P') count++;
            }
        }
        return count == 0 ? "TT" : String.valueOf(count);
    }
}
