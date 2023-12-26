package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.regex.Pattern;

public class BJ16236 {
    private int shark = 2;
    private int eaten = 0;
    private int answer = 0;
    private static final int[] DX = {-1, 0, 0, 1};
    private static final int[] DY = {0, -1, 1, 0};

    public String solve(String input) {
        int[][] map = Pattern.compile("\n").splitAsStream(input).skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);

        int[] ateAt = new int[2];
        for (int i = 0; i < map.length; i++) for (int j = 0; j < map.length; j++) if (map[i][j] == 9) {
            ateAt = new int[]{i, j, 0};
            map[i][j] = 0;
            break;
        }

        Queue<int[]> sharkQueue = new LinkedList<>();
        sharkQueue.offer(ateAt);
        while (!sharkQueue.isEmpty()) {
            boolean ate = false;
            boolean[][] visited = new boolean[map.length][map.length];
            PriorityQueue<int[]> vertexQueue = new PriorityQueue<>(
                    (ints1, ints2) -> ints1[2] != ints2[2] ?
                    Integer.compare(ints1[2], ints2[2]) : (ints1[0] != ints2[0] ?
                    Integer.compare(ints1[0], ints2[0]) : Integer.compare(ints1[1], ints2[1])));

            ateAt = sharkQueue.poll();
            int[] nextAteAt = new int[3];

            vertexQueue.offer(ateAt);
            visited[ateAt[0]][ateAt[1]] = true;
            while (!vertexQueue.isEmpty()) {
                int[] now = vertexQueue.poll();
                if (map[now[0]][now[1]] < shark && map[now[0]][now[1]] != 0) {
                    map[now[0]][now[1]] = 0;
                    ate = true;
                    sharkQueue.offer(new int[]{now[0], now[1], 0});
                    nextAteAt = now;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = now[0] + DX[i];
                    int nextY = now[1] + DY[i];
                    if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map.length
                            || visited[nextX][nextY] || map[nextX][nextY] > shark) continue;

                    visited[nextX][nextY] = true;
                    vertexQueue.offer(new int[]{nextX, nextY, now[2] + 1});
                }
            }

            if (ate) {
                eaten++;
                if (eaten == shark) {
                    shark++;
                    eaten = 0;
                }
            } else {
                return String.valueOf(answer);
            }
            answer += nextAteAt[2];
        }

        return String.valueOf(answer);
    }
}
