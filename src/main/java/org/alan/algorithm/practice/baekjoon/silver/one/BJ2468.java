package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.Stack;
import java.util.regex.Pattern;

public class BJ2468 {
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, -1, 0, 1};

    public String solve(String input) {
        int[][] mtx = input.lines().skip(1).map(s ->
                        Pattern.compile(" ").splitAsStream(s).mapToInt(ss -> Integer.parseInt(ss) + 1).toArray())
                .toArray(int[][]::new);

        int answer = 0;
        for (int n = 0; n < 100; n++) {
            boolean[][] visited = new boolean[mtx.length][mtx[0].length];
            for (int i = 0; i < mtx.length; i++) for (int j = 0; j < mtx[i].length; j++) {
                if (mtx[i][j] != 0) mtx[i][j]--;
                if (mtx[i][j] == 0) visited[i][j] = true;
            }

            int count = 0;
            for (int i = 0; i < mtx.length; i++) for (int j = 0; j < mtx[i].length; j++) {
                if (visited[i][j]) continue;
                count++;

                Stack<int[]> stack = new Stack<>();
                stack.push(new int[]{i, j});
                while (!stack.isEmpty()) {
                    int[] point = stack.pop();
                    int x = point[0], y = point[1];
                    visited[x][y] = true;

                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k], ny = y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= mtx.length || ny >= mtx[0].length || visited[nx][ny]) continue;
                        stack.push(new int[]{nx, ny});
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        return String.valueOf(answer);
    }
}
