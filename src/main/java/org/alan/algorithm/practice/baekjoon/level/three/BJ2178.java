package org.alan.algorithm.practice.baekjoon.level.three;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class BJ2178 {
    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    public String solve(String input) {
        int[][] map = Pattern.compile("\n").splitAsStream(input).skip(1)
                .map(s -> s.chars().map(i -> i - 48).toArray()).toArray(int[][]::new);

        int numberOfRow = map.length;
        int numberOfColumn = map[0].length;
        boolean[][] visited = new boolean[numberOfRow][numberOfColumn];

        int answer = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            if (nowX == numberOfRow - 1 && nowY == numberOfColumn - 1) {
                return String.valueOf(Integer.min(map[nowX][nowY], answer));
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + DX[i];
                int nextY = nowY + DY[i];
                if (nextX >= 0 && nextY >= 0 && nextX < numberOfRow && nextY < numberOfColumn
                        && map[nextX][nextY] > 0 && !visited[nextX][nextY]) {
                    queue.offer(new int[]{nextX, nextY});
                    map[nextX][nextY] = map[nowX][nowY] + 1;
                    visited[nowX][nowY] = true;
                }
            }
        }

        return String.valueOf(answer);
    }
}
