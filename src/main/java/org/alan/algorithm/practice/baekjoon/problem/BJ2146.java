package org.alan.algorithm.practice.baekjoon.problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class BJ2146 {

    // Mark each land with id
    // for each land find the length of the shortest bridge
    // print the shortest for them all
    public String solve(String input) {
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};
        int[][] matrix = input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        int[][] map = new int[matrix.length][matrix.length];

        int landCount = 0;
        Queue<int[]> landQueue = new LinkedList<>();
        for (int i = 0; i < map.length; i++) for (int j = 0; j < map.length; j++) if (matrix[i][j] == 1 && map[i][j] == 0) {
            map[i][j] = ++landCount;
            landQueue.offer(new int[]{i, j});

            while (!landQueue.isEmpty()) {
                int[] polled = landQueue.poll();
                int x = polled[0], y = polled[1];

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k], ny = y + dy[k];
                    if (nx < 0 || ny < 0 || nx >= matrix.length || ny >= matrix.length
                            || matrix[nx][ny] == 0 || map[nx][ny] != 0) continue;

                    map[nx][ny] = landCount;
                    landQueue.offer(new int[]{nx, ny});
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        int homeland = 0;
        while (homeland++ < landCount) {
            Queue<int[]> bridgeQueue = new LinkedList<>();
            boolean[][] visited = new boolean[map.length][map.length];
            for (int i = 0; i < map.length; i++) for (int j = 0; j < map.length; j++) if (map[i][j] == homeland) {
                bridgeQueue.offer(new int[]{i, j, 0});  // fixme: ALAN => performance boost by make bridge map
                visited[i][j] = true;
            }

            bridge: while (!bridgeQueue.isEmpty()) {
                int[] polled = bridgeQueue.poll();
                int x = polled[0], y = polled[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= map.length || ny >= map.length || visited[nx][ny]) continue;
                    if (map[nx][ny] != 0) {
                        answer = Math.min(answer, polled[2]);
                        break bridge;
                    }

                    bridgeQueue.offer(new int[]{nx, ny, polled[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return String.valueOf(answer);
    }
}
