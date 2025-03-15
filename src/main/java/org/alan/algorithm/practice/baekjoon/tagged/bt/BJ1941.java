package org.alan.algorithm.practice.baekjoon.tagged.bt;

import java.util.Stack;

public class BJ1941 {
    private final boolean[][] map = new boolean[5][5];
    private final int[][] seats = {
            {0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4},
            {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4},
            {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4},
            {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4},
            {4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4},
    };
    private final int[]
            dx = {0, 0, 1, -1},
            dy = {1, -1, 0, 0};
    private final Stack<Integer> stack = new Stack<>();
    private int count = 0;

    public BJ1941(String input) {
        String[] lines = input.lines().toArray(String[]::new);
        for (int i = 0; i < 5; i++) {
            int[] line = lines[i].chars().toArray();
            for (int j = 0; j < 5; j++) map[i][j] = line[j] == 'S';
        }
    }

    public String solve() {
        recur(-1);
        return String.valueOf(count);
    }

    private void recur(int from) {
        if (stack.size() == 7) {
            boolean[][] visited = new boolean[5][5];
            if (stack.stream().map(s -> seats[s])
                    .peek(s -> visited[s[0]][s[1]] = true)
                    .filter(s -> map[s[0]][s[1]])
                    .count() < 4) return;

            Stack<int[]> connected = new Stack<>();
            int size = 0;
            int x = seats[from][0], y = seats[from][1];

            visited[x][y] = false;
            connected.push(new int[]{x, y});
            size++;
            while (!connected.isEmpty()) {
                int[] pop = connected.pop();

                for (int i = 0; i < 4; i++) {
                    int nx = pop[0] + dx[i], ny = pop[1] + dy[i];
                    if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || !visited[nx][ny]) continue;

                    visited[nx][ny] = false;
                    connected.push(new int[]{nx, ny});
                    size++;
                }
            }
            if (size == 7) count++;
            return;
        }

        for (int s = from + 1; s < 25; s++) {
            stack.push(s);
            recur(s);
            stack.pop();
        }
    }

}
