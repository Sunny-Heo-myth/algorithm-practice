package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class BJ10026 {
    private char[][] chars;
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, -1, 0, 1};

    public String solve(String input) {
        chars = Pattern.compile("\n").splitAsStream(input).skip(1).map(String::toCharArray).toArray(char[][]::new);
        boolean[][] visited = new boolean[chars.length][chars.length];
        boolean[][] colorBlindVisited = new boolean[chars.length][chars.length];

        int count = 0;
        int colorBlindCount = 0;
        for (int i = 0; i < chars.length; i++) for (int j = 0; j < chars.length; j++) {
            char baseColor = chars[i][j];

            if (!visited[i][j]) {
                count++;
                visit(i, j, visited, baseColor, false);
            }

            if (!colorBlindVisited[i][j]) {
                colorBlindCount++;
                visit(i, j, colorBlindVisited, baseColor, true);
            }
        }
        return count + " " + colorBlindCount;
    }

    private void visit(int i, int j, boolean[][] visited, char baseColor, boolean isColorBlind) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nextX = now[0] + dx[k];
                int nextY = now[1] + dy[k];
                if (isVisitable(nextX, nextY, visited) && isLookedSame(isColorBlind, baseColor, nextX, nextY)) {
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    private boolean isLookedSame(boolean isColorBlind, char nowColor, int nextX, int nextY) {
        char nextColor = chars[nextX][nextY];
        if (isColorBlind) return nowColor == 'B' ? nextColor == 'B' : nextColor == 'R' || nextColor == 'G';
        else return nextColor == nowColor;
    }

    private boolean isVisitable(int x, int y, boolean[][] map) {
        return x >= 0 && x < chars.length && y >= 0 && y < chars.length && !map[x][y];
    }
}
