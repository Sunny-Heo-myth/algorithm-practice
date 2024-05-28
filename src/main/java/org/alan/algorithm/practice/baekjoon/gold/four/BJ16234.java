package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class BJ16234 {
    private int L;
    private int R;
    private int[][] map;

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public String solve(String input) {
        String[] firstLine = input.split("\n")[0].split(" ");
        L = Integer.parseInt(firstLine[1]); R = Integer.parseInt(firstLine[2]);
        map = input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s)
                        .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);

        int day = 0;
        while (moved()) day++;
        return String.valueOf(day);
    }

    private boolean moved() {
        boolean[][] visited = new boolean[map.length][map.length];
        List<List<int[]>> paths = new ArrayList<>();

        for (int i = 0; i < map.length; i++) for (int j = 0; j < map.length; j++) if (!visited[i][j]) {
            List<int[]> merged = new ArrayList<>();
            Stack<int[]> stack = new Stack<>();

            visited[i][j] = true;
            stack.push(new int[]{i, j});
            merged.add(new int[]{i, j});

            while (!stack.isEmpty()) {
                int[] pop = stack.pop();
                int x = pop[0], y = pop[1];

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k]; int ny = y + dy[k];
                    if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length || visited[nx][ny]) continue;
                    int abs = Math.abs(map[x][y] - map[nx][ny]);
                    if (abs < L || abs > R) continue;

                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                    merged.add(new int[]{nx, ny});
                }
            }

            if (merged.size() > 1) paths.add(merged);
        }

        if (paths.isEmpty()) return false;
        paths.forEach(cd -> {
            int distributed = cd.stream().mapToInt(ints -> map[ints[0]][ints[1]]).sum() / cd.size();
            cd.forEach(ints -> map[ints[0]][ints[1]] = distributed);
        });
        return true;
    }

}
