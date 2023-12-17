package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.regex.Pattern;

public class BJ14500 {
    private int[][] map;
    private boolean[][] visited;
    private int max = Integer.MIN_VALUE;
    private final int[] DX = {1, 0, -1, 0};
    private final int[] DY = {0, -1, 0, 1};

    public String solve(String input) {
        map = Pattern.compile("\n").splitAsStream(input).skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        visited = new boolean[map.length][map[0].length];

        for (int x = 0; x < visited.length; x++) for (int y = 0; y < visited[0].length; y++) {
            visited[x][y] = true;
            tetromino(x, y, map[x][y], 1);
            visited[x][y] = false;
        }
        return String.valueOf(max);
    }

    private void tetromino(int x, int y, int sum, int count) {
        if (count == 4) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            final int nextX = x + DX[i];
            final int nextY = y + DY[i];
            if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length || visited[nextX][nextY]) continue;

            if (count == 2) {
                visited[nextX][nextY] = true;
                tetromino(x, y, sum + map[nextX][nextY], count + 1);
                visited[nextX][nextY] = false;
            }

            visited[nextX][nextY] = true;
            tetromino(nextX, nextY, sum + map[nextX][nextY], count + 1);
            visited[nextX][nextY] = false;
        }
    }

}
